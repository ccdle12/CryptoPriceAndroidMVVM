package com.example.christophercoverdale.cryptopricemvvm.dashboard;

import android.support.annotation.NonNull;

import com.example.christophercoverdale.cryptopricemvvm.coinbase.coinbasemodel.CoinbaseModel;
import com.example.christophercoverdale.cryptopricemvvm.dagger.AppComponentInjector;
import com.example.christophercoverdale.cryptopricemvvm.datamodelmanager.DataModelManager;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by christophercoverdale on 23/11/2017.
 */

public class DashboardViewModel
{
    @NonNull
    @Inject
    public DataModelManager dataModelManager;

    public DashboardViewModel()
    {
        AppComponentInjector.get().inject(this);
    }


}
