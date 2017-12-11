package com.example.christophercoverdale.cryptopricemvvm.dashboard;

import android.support.annotation.NonNull;

import com.example.christophercoverdale.cryptopricemvvm.datamodel.CoinModel;
import com.example.christophercoverdale.cryptopricemvvm.datamodel.ExchangeParent;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * Created by christophercoverdale on 28/11/2017.
 */

public interface IDashboardViewModel
{
    Observable<List<ExchangeParent>> getSupportedExchanges();
    Observable<List<CoinModel>> getCoins();
    void exchangeSelected(@NonNull final ExchangeParent exchange);
    void coinSelected(@NonNull final CoinModel coinModel);
    Observable<String> getPrice();
    String getLastUpdatedDate();
    boolean isInternetConnected();
}
