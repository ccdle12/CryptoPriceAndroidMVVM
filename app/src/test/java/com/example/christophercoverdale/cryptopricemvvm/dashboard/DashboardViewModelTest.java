package com.example.christophercoverdale.cryptopricemvvm.dashboard;

import android.support.annotation.NonNull;

import com.example.christophercoverdale.cryptopricemvvm.datamodelmanager.DataModelManager;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

/**
 * Created by christophercoverdale on 28/11/2017.
 */
public class DashboardViewModelTest
{
    @NonNull
    private DashboardViewModel dashboardViewModel;

    @Before
    public void setup()
    {
        this.dashboardViewModel = new DashboardViewModel();
    }

    @Test
    public void testDashboardViewModelIsInitialized()
    {
        Assert.assertTrue(dashboardViewModel != null);
    }
}