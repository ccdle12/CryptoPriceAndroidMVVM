package com.example.christophercoverdale.cryptopricemvvm.dagger;

import com.example.christophercoverdale.cryptopricemvvm.MainActivity;
import com.example.christophercoverdale.cryptopricemvvm.dashboard.Dashboard;
import com.example.christophercoverdale.cryptopricemvvm.dashboard.DashboardViewModel;
import com.example.christophercoverdale.cryptopricemvvm.datamodelmanager.DataModelManager;
import com.example.christophercoverdale.cryptopricemvvm.helpers.RestApiHelper;

import javax.inject.Singleton;
import dagger.Component;

/**
 * Created by christophercoverdale on 22/11/2017.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent
{
    void inject(MainActivity mainActivity);
    void inject(Dashboard dashboard);

    void inject(DashboardViewModel dashboardViewModel);

    void inject(DataModelManager dataModelManager);

    void inject(RestApiHelper restApiHelper);

}
