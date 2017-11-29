package com.example.christophercoverdale.cryptopricemvvm.datamodelmanager;

import android.support.annotation.NonNull;

import com.example.christophercoverdale.cryptopricemvvm.dagger.AppComponentInjector;
import com.example.christophercoverdale.cryptopricemvvm.datamodel.ExchangesDataModel;
import com.example.christophercoverdale.cryptopricemvvm.helpers.RestApiHelper;
import com.example.christophercoverdale.cryptopricemvvm.realmdatabase.DatabaseManager;

import java.util.List;

import javax.inject.Inject;

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
    @Inject
    public RestApiHelper restApiHelper;

    @NonNull
    @Inject
    public DatabaseManager databaseManager;


    /**
     * Constructor
     */
    public DataModelManager()
    {
        AppComponentInjector.get().inject(this);

    }

    /**
     * Fetch Data Model
     */
    public Observable<ExchangesDataModel> requestExchangeModel()
    {
        return requestUpdatedExchanges();
    }

    private Observable<ExchangesDataModel> requestUpdatedExchanges()
    {
        List<Observable<?>> obsList = this.restApiHelper.getUpdatedPricesFromExchanges();
        return Observable.zip(obsList, (i) -> new ExchangesDataModel(i));
    }
}
