package com.example.christophercoverdale.cryptopricemvvm.helpers;

import android.support.annotation.NonNull;

import com.example.christophercoverdale.cryptopricemvvm.bitfinex.apiservice.BitfinexAPIService;
import com.example.christophercoverdale.cryptopricemvvm.bitfinex.bitfinexmodel.BitfinexDeserializer;
import com.example.christophercoverdale.cryptopricemvvm.bitfinex.bitfinexmodel.BitfinexModel;
import com.example.christophercoverdale.cryptopricemvvm.coinbase.apiservice.CoinbaseAPIService;
import com.example.christophercoverdale.cryptopricemvvm.coinbase.coinbasemodel.CoinbaseDeserializer;
import com.example.christophercoverdale.cryptopricemvvm.coinbase.coinbasemodel.CoinbaseModel;
import com.example.christophercoverdale.cryptopricemvvm.dagger.AppComponentInjector;
import com.example.christophercoverdale.cryptopricemvvm.datamodel.Exchange;
import com.example.christophercoverdale.cryptopricemvvm.schedulers.IScheduleProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by christophercoverdale on 23/11/2017.
 */

public class RestApiHelper
{
    /**
     * Instance Variables
     */
    @NonNull
    @Inject
    public IScheduleProvider scheduleProvider;


    /**
     * Constructor
     */
    public RestApiHelper()
    {
        AppComponentInjector.get().inject(this);
    }


    private Retrofit retrofitInstance(String url, Gson gson)
    {
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }


    /**
     * Public accessor methods
     */
    @NonNull
    public List<Observable<?>> getUpdatedPricesFromExchanges()
    {
        return Arrays.asList(getCoinbaseExchange(), getBitfinexExchange());
    }

    @NonNull
    public Observable<Exchange> getCoinbaseExchange()
    {

        return Observable.zip(
                Observable.just("Coinbase"),
                getPriceFromCoinbase("BTC"),
                getPriceFromCoinbase("ETH"),
                getPriceFromCoinbase("LTC"),
                Exchange::new);
    }

    @NonNull
    public Observable<Exchange> getBitfinexExchange()
    {
        return Observable.zip(
                Observable.just("Bitfinex"),
                getPriceFromBitfinex("BTC"),
                getPriceFromBitfinex("ETH"),
                getPriceFromBitfinex("LTC"),
                Exchange::new);
    }


    public Observable<CoinbaseModel> getPriceFromCoinbase(String coin)
    {
        Gson gson = new GsonBuilder().registerTypeAdapter(CoinbaseModel.class, new CoinbaseDeserializer()).create();
        Retrofit retrofit = retrofitInstance("https://api.coinbase.com", gson);

        return retrofit
                .create(CoinbaseAPIService.class)
                .getSpotPrice(coin)
                .subscribeOn(scheduleProvider.io())
                .observeOn(scheduleProvider.ui())
                .onErrorReturn(error -> new CoinbaseModel("Information is currently unavailable", coin))
                .doOnNext(emittedCoin -> emittedCoin.setSymbol(emittedCoin.getBase()))
                .doOnNext(emittedCoin1 -> emittedCoin1.setPrice(emittedCoin1.getAmount()));
    }

    public Observable<BitfinexModel> getPriceFromBitfinex(String coin)
    {
        Gson gson = new GsonBuilder().registerTypeAdapter(BitfinexModel.class, new BitfinexDeserializer()).create();
        Retrofit retrofit = retrofitInstance("https://api.bitfinex.com/", gson);

        return retrofit
                .create(BitfinexAPIService.class)
                .getSpotPrice(coin)
                .subscribeOn(scheduleProvider.io())
                .observeOn(scheduleProvider.ui())
                .onErrorReturn(error -> new BitfinexModel("Information is currently unavailable", coin))
                .doOnNext(emittedCoin -> emittedCoin.setSymbol(coin.toUpperCase()))
                .doOnNext(emittedCoin1 -> emittedCoin1.setPrice(emittedCoin1.getLastPrice()));
    }

}
