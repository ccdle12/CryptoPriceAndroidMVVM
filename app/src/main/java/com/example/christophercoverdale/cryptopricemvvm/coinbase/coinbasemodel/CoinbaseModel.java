package com.example.christophercoverdale.cryptopricemvvm.coinbase.coinbasemodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by christophercoverdale on 28/11/2017.
 */

public class CoinbaseModel
{
    @SerializedName("base")
    @Expose
    private String base;

    @SerializedName("currency")
    @Expose
    private String currency;

    @SerializedName("amount")
    @Expose
    private String amount;


    public CoinbaseModel() {};

    public CoinbaseModel(String onErrorMessage, String coin)
    {
        setAmount(onErrorMessage);
        setBase(coin);
    }

    public String getBase()
    {
        return base;
    }

    public void setBase(String base)
    {
        this.base = base;
    }

    public String getCurrency()
    {
        return currency;
    }

    public void setCurrency(String currency)
    {
        this.currency = currency;
    }

    public String getAmount()
    {
        return amount;
    }

    public void setAmount(String amount)
    {
        this.amount = amount;
    }
}
