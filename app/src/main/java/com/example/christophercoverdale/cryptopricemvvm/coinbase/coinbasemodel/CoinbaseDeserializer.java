package com.example.christophercoverdale.cryptopricemvvm.coinbase.coinbasemodel;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by christophercoverdale on 28/11/2017.
 */

public class CoinbaseDeserializer implements JsonDeserializer<CoinbaseModel>
{

    @Override
    public CoinbaseModel deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        /**
         * Get the "data" json object from the parsed JSON
         */
        JsonElement coinbaseModel = json.getAsJsonObject().get("data");


        /**
         * Deserialize the JsonElement as GSON
         */
        return new Gson().fromJson(coinbaseModel, CoinbaseModel.class);
    }
}
