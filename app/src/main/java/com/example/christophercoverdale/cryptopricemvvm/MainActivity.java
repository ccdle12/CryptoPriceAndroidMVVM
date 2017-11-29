package com.example.christophercoverdale.cryptopricemvvm;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.christophercoverdale.cryptopricemvvm.dagger.AppComponentInjector;
import com.example.christophercoverdale.cryptopricemvvm.dashboard.Dashboard;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity
{
    @NonNull
    @Inject
    Dashboard dashboardFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppComponentInjector.get(this).inject(this);
        setupFragmentInContainer();
    }

    private void setupFragmentInContainer()
    {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_fragment_container, dashboardFragment)
                .commit();
    }

}
