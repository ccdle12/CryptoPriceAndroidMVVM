package com.example.christophercoverdale.cryptopricemvvm.dashboard;

import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.christophercoverdale.cryptopricemvvm.R;
import com.example.christophercoverdale.cryptopricemvvm.dagger.AppComponentInjector;

import javax.inject.Inject;

/**
 * Created by christophercoverdale on 22/11/2017.
 */

public class Dashboard extends Fragment
{
    /**
     * Instance variables
     */
    @NonNull
    @Inject
    DashboardViewModel dashboardViewModel;


    /**
     * Lifecycle
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.dashboard, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        AppComponentInjector.get().inject(this);

    }
}
