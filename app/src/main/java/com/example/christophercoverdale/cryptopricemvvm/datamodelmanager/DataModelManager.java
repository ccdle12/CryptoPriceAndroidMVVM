package com.example.christophercoverdale.cryptopricemvvm.datamodelmanager;

import android.support.annotation.NonNull;

import com.example.christophercoverdale.cryptopricemvvm.dagger.ControllerComponentInjector;
import com.example.christophercoverdale.cryptopricemvvm.datamodel.ExchangesDataModel;
import com.example.christophercoverdale.cryptopricemvvm.helpers.RestApiHelper;

import rx.Observable;

/**
 * Created by christophercoverdale on 23/11/2017.
 */

public class DataModelManager
{
    /**
     * Instance Variables
     */
    @NonNull
    private RestApiHelper restApiHelper;


    /**
     * Constructor
     */
    public DataModelManager()
    {
        ControllerComponentInjector.get().inject(this);
    }

    /**
     * Fetch Data Model
     */
    public Observable<ExchangesDataModel> requestExchangeModel()
    {
        return this.restApiHelper.getUpdatedPricesFromExchanges();
    }
}
