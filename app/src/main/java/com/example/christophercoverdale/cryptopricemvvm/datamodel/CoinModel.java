package com.example.christophercoverdale.cryptopricemvvm.datamodel;

import android.support.annotation.NonNull;

/**
 * Created by christophercoverdale on 28/11/2017.
 */

public abstract class CoinModel
{
    /**
     * Instance Variables
     */
    @NonNull
    private String symbol;

    @NonNull
    private String price;


    /**
     * Getters and Setters
     */
    @NonNull
    public String getSymbol()
    {
        return symbol;
    }


    public void setSymbol(@NonNull String symbol)
    {
        this.symbol = symbol;
    }

    @NonNull
    public String getPrice()
    {
        return price;
    }

    public void setPrice(@NonNull String price)
    {
        this.price = price;
    }
}
