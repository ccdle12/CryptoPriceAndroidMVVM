package com.example.christophercoverdale.cryptopricemvvm.dashboard;

import android.support.annotation.NonNull;

import com.example.christophercoverdale.cryptopricemvvm.dagger.AppComponentInjector;
import com.example.christophercoverdale.cryptopricemvvm.datamodel.CoinModel;
import com.example.christophercoverdale.cryptopricemvvm.datamodel.ExchangeParent;
import com.example.christophercoverdale.cryptopricemvvm.datamodel.ExchangesDataModel;
import com.example.christophercoverdale.cryptopricemvvm.datamodelmanager.DataModelManager;
import java.util.List;
import javax.inject.Inject;

import rx.Observable;
import rx.schedulers.Schedulers;
import rx.subjects.BehaviorSubject;

/**
 * Created by christophercoverdale on 23/11/2017.
 */

public class DashboardViewModel implements IDashboardViewModel
{
    /**
     * Instance variables
     */
    @NonNull
    private DataModelManager dataModelManager;

    @NonNull
    private ExchangesDataModel exchangesDataModel;

    @NonNull
    private final BehaviorSubject<ExchangeParent> selectedExchange = BehaviorSubject.create();

    @NonNull
    private final BehaviorSubject<CoinModel> selectedCoin = BehaviorSubject.create();

    /**
     * Getters and Setters
     */
    public void setExchangesDataModel(@NonNull ExchangesDataModel exchangesDataModel)
    {
        this.exchangesDataModel = exchangesDataModel;
    }


    /**
     * Constructor
     */
    @Inject
    public DashboardViewModel(DataModelManager dataModelManager)
    {
        setDataModelManager(dataModelManager);
        AppComponentInjector.get().inject(this);
    }

    public void setDataModelManager(@NonNull DataModelManager dataModelManager)
    {
        this.dataModelManager = dataModelManager;
    }




    /**
     * Interface Methods
     */
    @Override
    public Observable<List<ExchangeParent>> getSupportedExchanges()
    {
        return this.dataModelManager.requestExchangeModel()
                .doOnNext(this::setExchangesDataModel)
                .flatMap(exchangeModel -> Observable.just(exchangeModel.getExchanges()));
    }

    @Override
    public Observable<List<CoinModel>> getCoins()
    {
        return this.selectedExchange
                .map(ExchangeParent::getCoins);
    }

    public void exchangeSelected(@NonNull final ExchangeParent abstractExchange)
    {
        this.selectedExchange.onNext(abstractExchange);
    }

    @Override
    public void coinSelected(@NonNull CoinModel coinModel)
    {
        this.selectedCoin.onNext(coinModel);
    }

    @Override
    public Observable<String> getPrice()
    {
        return this.selectedCoin
                .map(CoinModel::getPrice);
    }

    @Override
    public String getLastUpdatedDate()
    {
        return this.exchangesDataModel.getLastUpdatedDate().toString();
    }
}
