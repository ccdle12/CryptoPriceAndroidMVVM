package com.example.christophercoverdale.cryptopricemvvm.bitfinex.apiservice;

import com.example.christophercoverdale.cryptopricemvvm.bitfinex.bitfinexmodel.BitfinexModel;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by christophercoverdale on 28/11/2017.
 */

public interface BitfinexAPIService
{
    @GET("v1/pubticker/{coin}usd")
    Observable<BitfinexModel> getSpotPrice(@Path("coin") String coin);
}
