package com.example.christophercoverdale.cryptopricemvvm.Dagger;

import android.app.Application;

/**
 * Created by christophercoverdale on 22/11/2017.
 */

public class AppComponentInjector
{
    private static AppComponent appComponent;

    private AppComponentInjector() {}

    public static AppComponent get(Application application)
    {
        if (appComponent == null)
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(application)).build();

        return appComponent;

    }
}
