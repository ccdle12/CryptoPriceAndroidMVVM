package com.example.christophercoverdale.cryptopricemvvm.Dagger;

import com.example.christophercoverdale.cryptopricemvvm.Dashboard.Dashboard;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by christophercoverdale on 22/11/2017.
 */

@Module
public class FragmentModule
{
    @Provides
    @Singleton
    public Dashboard providesDashboard()
    {
        return new Dashboard();
    }
}
