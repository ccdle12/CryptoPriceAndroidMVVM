package com.example.christophercoverdale.cryptopricemvvm.helpers;

import android.content.RestrictionEntry;
import android.support.annotation.NonNull;

import com.example.christophercoverdale.cryptopricemvvm.datamodel.ExchangesDataModel;

import rx.Observable;

/**
 * Created by christophercoverdale on 23/11/2017.
 */

public class RestApiHelper
{
    /**
     * Instance Variables
     */
    @NonNull
    private static RestApiHelper restApiHelper;



    /**
     * Constructor
     */
    private RestApiHelper() {};

    public static RestApiHelper getInstance()
    {
        if (restApiHelper == null)
            restApiHelper = new RestApiHelper();

        return restApiHelper;
    }


    /**
     * Public accessor methods
     */
    public Observable<ExchangesDataModel> getUpdatedPricesFromExchanges()
    {
        return Observable.just(new ExchangesDataModel());
    }
}
