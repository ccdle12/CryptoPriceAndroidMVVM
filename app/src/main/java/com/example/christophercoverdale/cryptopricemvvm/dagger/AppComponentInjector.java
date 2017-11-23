package com.example.christophercoverdale.cryptopricemvvm.dagger;
/**
 * Created by christophercoverdale on 22/11/2017.
 */

public class AppComponentInjector
{
    private static AppComponent appComponent;

    private AppComponentInjector() {}

    public static AppComponent get()
    {
        if (appComponent == null)
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule()).build();

        return appComponent;

    }

}
