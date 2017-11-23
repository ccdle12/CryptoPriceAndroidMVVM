package com.example.christophercoverdale.cryptopricemvvm.helpers;

import android.support.annotation.NonNull;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by christophercoverdale on 23/11/2017.
 */
public class RestApiHelperTest
{
    @NonNull
    RestApiHelper restApiHelper;

    @Before
    public void setup()
    {
        restApiHelper = RestApiHelper.getInstance();
    }

    @Test
    public void testShouldGetInstance()
    {
        Assert.assertTrue(restApiHelper != null);
    }
}