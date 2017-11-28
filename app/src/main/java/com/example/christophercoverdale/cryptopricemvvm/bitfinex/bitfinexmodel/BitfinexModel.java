package com.example.christophercoverdale.cryptopricemvvm.bitfinex.bitfinexmodel;

import com.example.christophercoverdale.cryptopricemvvm.datamodel.CoinModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by christophercoverdale on 28/11/2017.
 */

public class BitfinexModel extends CoinModel
{
    @SerializedName("mid")
    @Expose
    private String mid;

    @SerializedName("bid")
    @Expose
    private String bid;

    @SerializedName("ask")
    @Expose
    private String ask;

    @SerializedName("last_price")
    @Expose
    private String lastPrice;

    @SerializedName("low")
    @Expose
    private String low;

    @SerializedName("high")
    @Expose
    private String high;

    @SerializedName("volume")
    @Expose
    private String volume;

    @SerializedName("timestamp")
    @Expose
    private String timestamp;

    public BitfinexModel() {};

    public BitfinexModel(String errorMessage, String coin)
    {

    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
