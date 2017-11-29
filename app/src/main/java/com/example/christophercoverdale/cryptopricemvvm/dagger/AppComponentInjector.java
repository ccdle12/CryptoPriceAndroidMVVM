package com.example.christophercoverdale.cryptopricemvvm.dagger;

import android.content.Context;

import com.example.christophercoverdale.cryptopricemvvm.MainActivity;

/**
 * Created by christophercoverdale on 22/11/2017.
 */

public class AppComponentInjector
{
    private static AppComponent appComponent;

    private static Context context;

    private AppComponentInjector() {}

    public static AppComponent get(Context contextArg)
    {
        context = contextArg;

        if (appComponent == null)
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(context)).build();

        return appComponent;

    }

    public static AppComponent get()
    {
        if (appComponent == null)
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(context)).build();

        return appComponent;

    }

}
