package com.example.christophercoverdale.cryptopricemvvm.dagger;


import com.example.christophercoverdale.cryptopricemvvm.dashboard.Dashboard;
import com.example.christophercoverdale.cryptopricemvvm.dashboard.DashboardViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by christophercoverdale on 22/11/2017.
 */

@Module
public class AppModule
{
    @Provides
    @Singleton
    public Dashboard providesDashboard()
    {
        return new Dashboard();
    }

    @Provides
    @Singleton
    public DashboardViewModel providesDashboardViewModel() { return new DashboardViewModel(); }
}
