package com.example.christophercoverdale.cryptopricemvvm.Dashboard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.christophercoverdale.cryptopricemvvm.R;

/**
 * Created by christophercoverdale on 22/11/2017.
 */

public class Dashboard extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.dashboard, container, false);

        return rootView;
    }
}
