package com.example.christophercoverdale.cryptopricemvvm.bitfinex.bitfinexmodel;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by christophercoverdale on 28/11/2017.
 */

public class BitfinexDeserializer implements JsonDeserializer<BitfinexModel>
{

    @Override
    public BitfinexModel deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        /**
         * Get the json object from the parsed JSON
         */
        JsonElement bitfinexModel = json.getAsJsonObject();

        /**
         * Deserialize the JsonElement as GSON
         */
        return new Gson().fromJson(bitfinexModel, BitfinexModel.class);
    }
}
