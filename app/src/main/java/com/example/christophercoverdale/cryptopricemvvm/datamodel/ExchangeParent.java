package com.example.christophercoverdale.cryptopricemvvm.datamodel;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

import rx.Observable;

/**
 * Created by christophercoverdale on 28/11/2017.
 */

public abstract class ExchangeParent
{
    /**
     * Instance Variables
     */
    @NonNull
    private String exchangeName;

    @NonNull
    private ArrayList<CoinModel> coins;

    @NonNull
    private HashMap<String, CoinModel> coinSymbolPairedWithModel;


    /**
     * Constructor
     */
    public ExchangeParent(String exchangeName)
    {
        setupInstanceVariables();
        setExchangeName(exchangeName);
    }

    private void setupInstanceVariables()
    {
        coins = new ArrayList<>();
        coinSymbolPairedWithModel = new HashMap<>();
    }

    public void addModelToListAndMap(ArrayList<CoinModel> coinbaseModelList)
    {
        Observable.from(coinbaseModelList)
                .doOnNext(coinModel -> coins.add(coinModel))
                .subscribe(coinModel1 -> coinSymbolPairedWithModel.put(coinModel1.getSymbol(), coinModel1));
    }


    /**
     * Getters and Setters
     */
    @NonNull
    public ArrayList<CoinModel> getCoins()
    {
        return coins;
    }

    public void setCoins(@NonNull ArrayList<CoinModel> coins)
    {
        this.coins = coins;
    }

    @NonNull
    public String getExchangeName()
    {
        return exchangeName;
    }

    public void setExchangeName(@NonNull String exchangeName)
    {
        this.exchangeName = exchangeName;
    }



    /**
     * Accessor methods to coins list and map
     */
    public void add(CoinModel coinModel)
    {
        coins.add(coinModel);
    }

    public boolean isEmpty()
    {
        return coins.isEmpty();
    }

    @Nullable
    public CoinModel getCoin(String symbol) { return coinSymbolPairedWithModel.get(symbol); }
}
