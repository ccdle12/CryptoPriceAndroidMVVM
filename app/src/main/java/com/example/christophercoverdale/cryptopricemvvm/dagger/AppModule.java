package com.example.christophercoverdale.cryptopricemvvm.dagger;


import android.content.Context;
import android.support.annotation.NonNull;

import com.example.christophercoverdale.cryptopricemvvm.dashboard.Dashboard;
import com.example.christophercoverdale.cryptopricemvvm.dashboard.DashboardViewModel;
import com.example.christophercoverdale.cryptopricemvvm.dashboard.IDashboardViewModel;
import com.example.christophercoverdale.cryptopricemvvm.datamodelmanager.DataModelManager;
import com.example.christophercoverdale.cryptopricemvvm.helpers.RestApiHelper;
import com.example.christophercoverdale.cryptopricemvvm.realmdatabase.DatabaseManager;
import com.example.christophercoverdale.cryptopricemvvm.schedulers.IScheduleProvider;
import com.example.christophercoverdale.cryptopricemvvm.schedulers.ScheduleProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by christophercoverdale on 22/11/2017.
 */

@Module
public class AppModule
{
    @NonNull
    private Context context;

    public AppModule(Context context)
    {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context providesContext()
    {
        return this.context;
    }

    @Provides
    @Singleton
    public Dashboard providesDashboard()
    {
        return new Dashboard();
    }

    @Provides
    @Singleton
    public IDashboardViewModel providesDashboardViewModel() { return new DashboardViewModel(providesDataModelManager()); }

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

    @Provides
    @Singleton
    public CompositeSubscription providesCompositeSubscription()
    {
        return new CompositeSubscription();
    }

    @Provides
    @Singleton
    public DatabaseManager providesDatabaseManager()
    {
        return new DatabaseManager(providesContext());
    }
}
