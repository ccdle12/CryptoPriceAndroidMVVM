package com.example.christophercoverdale.cryptopricemvvm.coinbase.apiservice;

import com.example.christophercoverdale.cryptopricemvvm.coinbase.coinbasemodel.CoinbaseModel;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by christophercoverdale on 28/11/2017.
 */

public interface CoinbaseAPIService
{
    @GET("/v2/prices/{coin}-USD/spot")
    Observable<CoinbaseModel> getSpotPrice(@Path("coin") String coin);
}
