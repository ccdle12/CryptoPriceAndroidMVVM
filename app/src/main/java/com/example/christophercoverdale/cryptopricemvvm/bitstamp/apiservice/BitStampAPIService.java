package com.example.christophercoverdale.cryptopricemvvm.bitstamp.apiservice;

import com.example.christophercoverdale.cryptopricemvvm.bitstamp.bitstampmodel.BitStampModel;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by christophercoverdale on 11/12/2017.
 */

public interface BitStampAPIService
{
    @GET("api/v2/ticker/{coin}usd")
    Observable<BitStampModel> getSpotPrice(@Path("coin") String coin);
}
