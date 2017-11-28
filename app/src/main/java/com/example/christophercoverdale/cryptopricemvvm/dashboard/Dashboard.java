package com.example.christophercoverdale.cryptopricemvvm.dashboard;

import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.christophercoverdale.cryptopricemvvm.R;
import com.example.christophercoverdale.cryptopricemvvm.adapters.CoinsSpinnerAdapter;
import com.example.christophercoverdale.cryptopricemvvm.adapters.ExchangesSpinnerAdapter;
import com.example.christophercoverdale.cryptopricemvvm.dagger.AppComponentInjector;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

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

    @BindView(R.id.exchanges_spinner)
    Spinner exchangesSpinner;

    @BindView(R.id.coins_spinner)
    Spinner coinsSpinner;

    @BindView(R.id.coin_price_text_view)
    TextView coinPrice;

    private ExchangesSpinnerAdapter exchangesSpinnerAdapter;

    private CoinsSpinnerAdapter coinsSpinnerAdapter;


    /**
     * Lifecycle
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.dashboard, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        AppComponentInjector.get().inject(this);
    }
}
