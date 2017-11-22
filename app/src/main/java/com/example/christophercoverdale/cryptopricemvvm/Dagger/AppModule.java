package com.example.christophercoverdale.cryptopricemvvm.Dagger;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by christophercoverdale on 22/11/2017.
 */

@Module
public class AppModule
{
    Application application;

    public AppModule(Application application)
    {
        this.application = application;
    }

    @Provides
    @Singleton
    Application providesApplication()
    {
        return application;
    }
}
