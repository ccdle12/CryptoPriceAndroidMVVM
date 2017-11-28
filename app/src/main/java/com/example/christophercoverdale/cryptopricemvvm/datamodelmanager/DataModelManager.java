package com.example.christophercoverdale.cryptopricemvvm.datamodelmanager;

import android.support.annotation.NonNull;

import com.example.christophercoverdale.cryptopricemvvm.coinbase.coinbasemodel.CoinbaseModel;
import com.example.christophercoverdale.cryptopricemvvm.dagger.AppComponentInjector;
import com.example.christophercoverdale.cryptopricemvvm.datamodel.ExchangesDataModel;
import com.example.christophercoverdale.cryptopricemvvm.helpers.RestApiHelper;

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
        return getUpdatedExchanges();
    }

    private Observable<ExchangesDataModel> getUpdatedExchanges()
    {
        List<Observable<?>> obsList = this.restApiHelper.getUpdatedPricesFromExchanges();
        return Observable.zip(obsList, (i) -> new ExchangesDataModel(i));
    }
}
