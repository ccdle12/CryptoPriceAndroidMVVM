package com.example.christophercoverdale.cryptopricemvvm.datamodelmanager;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;

import com.example.christophercoverdale.cryptopricemvvm.coinbase.coinbasemodel.CoinbaseModel;
import com.example.christophercoverdale.cryptopricemvvm.datamodel.CoinModel;
import com.example.christophercoverdale.cryptopricemvvm.datamodel.Exchange;
import com.example.christophercoverdale.cryptopricemvvm.datamodel.ExchangesDataModel;
import com.example.christophercoverdale.cryptopricemvvm.helpers.RestApiHelper;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;

import rx.Observable;
import rx.observers.TestSubscriber;

import static org.junit.Assert.*;

/**
 * Created by christophercoverdale on 28/11/2017.
 */
public class DataModelManagerTest
{
    @Mock
    private RestApiHelper restApiHelper;

    @NonNull
    private DataModelManager dataModelManager;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        this.dataModelManager = new DataModelManager();
    }

    @Test
    public void testDataModelManagerInitializes()
    {
        Assert.assertTrue(dataModelManager != null);
    }
    
}