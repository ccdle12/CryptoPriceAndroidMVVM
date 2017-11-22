package com.example.christophercoverdale.cryptopricemvvm.Dagger;

import com.example.christophercoverdale.cryptopricemvvm.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by christophercoverdale on 22/11/2017.
 */

@Singleton
@Component(modules = {AppModule.class, FragmentModule.class})
public interface AppComponent
{
    void inject(MainActivity mainActivity);
}
