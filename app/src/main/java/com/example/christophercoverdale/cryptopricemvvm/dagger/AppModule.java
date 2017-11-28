package com.example.christophercoverdale.cryptopricemvvm.dagger;


import com.example.christophercoverdale.cryptopricemvvm.dashboard.Dashboard;
import com.example.christophercoverdale.cryptopricemvvm.dashboard.DashboardViewModel;
import com.example.christophercoverdale.cryptopricemvvm.datamodelmanager.DataModelManager;
import com.example.christophercoverdale.cryptopricemvvm.helpers.RestApiHelper;
import com.example.christophercoverdale.cryptopricemvvm.schedulers.IScheduleProvider;
import com.example.christophercoverdale.cryptopricemvvm.schedulers.ScheduleProvider;

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

    @Provides
    @Singleton
    public IScheduleProvider providesScheduleProvider()
    {
        return ScheduleProvider.getInstance();
    }

    @Provides
    @Singleton
    public RestApiHelper providesRestApiHelper()
    {
        return new RestApiHelper();
    }

    @Provides
    @Singleton
    public DataModelManager providesDataModelManager()
    {
        return new DataModelManager();
    }
}
