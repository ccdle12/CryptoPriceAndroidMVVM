package com.example.christophercoverdale.cryptopricemvvm.dagger;

import com.example.christophercoverdale.cryptopricemvvm.datamodelmanager.DataModelManager;

import javax.inject.Singleton;
import dagger.Component;

/**
 * Created by christophercoverdale on 22/11/2017.
 */

@Singleton
@Component(modules = {ControllerModule.class})
public interface ControllerComponent
{
    void inject(DataModelManager dataModelManager);
}
