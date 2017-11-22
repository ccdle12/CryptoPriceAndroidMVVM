package com.example.christophercoverdale.cryptopricemvvm.Dagger;

import com.example.christophercoverdale.cryptopricemvvm.MainActivity;
import javax.inject.Singleton;
import dagger.Component;

/**
 * Created by christophercoverdale on 22/11/2017.
 */

@Singleton
@Component(modules = {ControllerModule.class})
public interface ControllerComponent
{
    void inject(MainActivity mainActivity);
}
