package com.example.christophercoverdale.cryptopricemvvm.Dagger;

/**
 * Created by christophercoverdale on 22/11/2017.
 */

public class ControllerComponentInjector
{
    private static ControllerComponent controllerComponent;

    private ControllerComponentInjector() {};

    public static ControllerComponent get()
    {
        if (controllerComponent == null)
            controllerComponent = DaggerControllerComponent.builder()
                    .controllerModule(new ControllerModule()).build();

        return controllerComponent;
    }
}
