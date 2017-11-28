package com.example.christophercoverdale.cryptopricemvvm.datamodel;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by christophercoverdale on 23/11/2017.
 */

public class ExchangesDataModel
{
    /**
     * Instance Variables
     */
    @NonNull
    private ArrayList<ExchangeParent> exchangeParents;

    @NonNull
    private HashMap<String, ExchangeParent> exchangeNamePairedWithExchange;

    @NonNull
    private ArrayList<String> listOfSupportedCoins;


    /**
     * Constructor
     */
    public ExchangesDataModel(Object[] exchangesList)
    {
        setupInstanceVariables();
        unpackExchangesList(exchangesList);
    }

    private void unpackExchangesList(Object[] exchangesList)
    {
        for (int i = 0; i < exchangesList.length; i++)
        {
            ExchangeParent exchange = (ExchangeParent) exchangesList[i] ;

            exchangeParents.add(exchange);
            exchangeNamePairedWithExchange.put(exchange.getExchangeName(), exchange);
        }
    }

    private void setupInstanceVariables()
    {
        exchangeParents = new ArrayList<>();
        exchangeNamePairedWithExchange = new HashMap<>();
        listOfSupportedCoins = new ArrayList<>();

        listOfSupportedCoins.add("BTC");
        listOfSupportedCoins.add("ETH");
        listOfSupportedCoins.add("LTC");
    }


    /**
     * Getters and Setters
     */
    @NonNull
    public ArrayList<ExchangeParent> getExchanges()
    {
        return exchangeParents;
    }

    @Nullable
    public ExchangeParent getExchange(String name)
    {
        return exchangeNamePairedWithExchange.get(name);
    }


    public void setExchangeParents(@NonNull ArrayList<ExchangeParent> exchangeParents)
    {
        this.exchangeParents = exchangeParents;
    }

    @NonNull
    public ArrayList<String> getListOfSupportedCoins()
    {
        return listOfSupportedCoins;
    }

    public void setListOfSupportedCoins(@NonNull ArrayList<String> listOfSupportedCoins)
    {
        this.listOfSupportedCoins = listOfSupportedCoins;
    }
}
