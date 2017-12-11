package com.example.christophercoverdale.cryptopricemvvm.bitstamp.bitstampmodel;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by christophercoverdale on 11/12/2017.
 */

public class BitStampDeserializer implements JsonDeserializer<BitStampModel>
{
    @Override
    public BitStampModel deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        /**
         * Get the json object from the parsed JSON
         */
        JsonElement bitstampModel = json.getAsJsonObject();

        /**
         * Deserialize the JsonElement as GSON
         */
        return new Gson().fromJson(bitstampModel, BitStampModel.class);
    }
}
