package com.example.christophercoverdale.cryptopricemvvm.datamodel;

/**
 * Created by christophercoverdale on 28/11/2017.
 */

public class Exchange extends ExchangeParent
{

    /**
     * Constructor
     *
     * @param exchangeName
     */
    public Exchange(String exchangeName, CoinModel bitcoin, CoinModel ethereum, CoinModel litecoin)
    {
        super(exchangeName);

    }
}
