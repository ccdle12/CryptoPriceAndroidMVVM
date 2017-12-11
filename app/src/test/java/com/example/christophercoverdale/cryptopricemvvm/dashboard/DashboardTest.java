package com.example.christophercoverdale.cryptopricemvvm.dashboard;

import android.support.annotation.NonNull;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

/**
 * Created by christophercoverdale on 29/11/2017.
 */
public class DashboardTest
{

    @Mock
    private IDashboardViewModel dashboardViewModel;

    @NonNull
    private Dashboard dashboard;

    @Before
    public void setup() throws Exception
    {
        MockitoAnnotations.initMocks(this);

        this.dashboard = new Dashboard();
    }

    @Test
    public void testDashboardIsNotNull()
    {
        Assert.assertTrue(this.dashboard != null);
    }
}