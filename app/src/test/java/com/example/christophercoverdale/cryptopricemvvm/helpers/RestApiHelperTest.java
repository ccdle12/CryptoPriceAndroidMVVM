package com.example.christophercoverdale.cryptopricemvvm.helpers;

import android.support.annotation.NonNull;

import com.example.christophercoverdale.cryptopricemvvm.coinbase.coinbasemodel.CoinbaseModel;
import com.example.christophercoverdale.cryptopricemvvm.immediatescheduleprovider.TestScheduleProvider;
import com.example.christophercoverdale.cryptopricemvvm.schedulers.ScheduleProvider;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import rx.Observable;
import rx.observers.TestSubscriber;

/**
 * Created by christophercoverdale on 28/11/2017.
 */
public class RestApiHelperTest
{

    @NonNull
    private RestApiHelper restApiHelper;


    @Before
    public void setup()
    {
        this.restApiHelper = new RestApiHelper();
        this.restApiHelper.scheduleProvider = new TestScheduleProvider();
    }


    @Test
    public void testRestApiHelperIsInitialized()
    {
        Assert.assertTrue(restApiHelper != null);
    }

}