package com.example.christophercoverdale.cryptopricemvvm;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.christophercoverdale.cryptopricemvvm.Dagger.ControllerComponentInjector;
import com.example.christophercoverdale.cryptopricemvvm.Dashboard.Dashboard;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity
{
    @NonNull
    @Inject
    public Dashboard dashboardFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ControllerComponentInjector.get().inject(this);
        setupFragmentInContainer();
    }

    private void setupFragmentInContainer()
    {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_fragment_container, dashboardFragment)
                .commit();
    }

}
