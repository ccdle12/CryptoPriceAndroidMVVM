package com.example.christophercoverdale.cryptopricemvvm.dashboard;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.christophercoverdale.cryptopricemvvm.R;
import com.example.christophercoverdale.cryptopricemvvm.adapters.CoinsSpinnerAdapter;
import com.example.christophercoverdale.cryptopricemvvm.adapters.ExchangesSpinnerAdapter;
import com.example.christophercoverdale.cryptopricemvvm.dagger.AppComponentInjector;
import com.example.christophercoverdale.cryptopricemvvm.datamodel.CoinModel;
import com.example.christophercoverdale.cryptopricemvvm.datamodel.ExchangeParent;
import com.example.christophercoverdale.cryptopricemvvm.schedulers.IScheduleProvider;
import com.example.christophercoverdale.cryptopricemvvm.schedulers.ScheduleProvider;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

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
    IDashboardViewModel dashboardViewModel;

    @NonNull
    @Inject
    IScheduleProvider scheduleProvider;

    @NonNull
    CompositeSubscription subscription;

    @NonNull
    @BindView(R.id.exchanges_spinner)
    Spinner exchangesSpinner;

    @NonNull
    @BindView(R.id.coins_spinner)
    Spinner coinsSpinner;

    @NonNull
    @BindView(R.id.coin_price_text_view)
    TextView coinPrice;

    @NonNull
    @BindView(R.id.last_updated_date)
    TextView lastUpdatedDate;

    @NonNull
    private ExchangesSpinnerAdapter exchangesSpinnerAdapter;

    @NonNull
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

        setupListeners();
    }

    private void setupListeners()
    {
        setupExchangeSpinnerListener();
        setupCoinSpinnerListener();
    }

    private void setupExchangeSpinnerListener()
    {
        this.exchangesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
            {
                exchangeSelected(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });
    }

    private void setupCoinSpinnerListener()
    {
        this.coinsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
            {
                coinSelected(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });
    }


    @Override
    public void onResume()
    {
        super.onResume();
        bind();
    }

    private void bind()
    {
        this.subscription = new CompositeSubscription();

        this.subscription.add(this.dashboardViewModel.getSupportedExchanges()
                .subscribeOn(scheduleProvider.io())
                .observeOn(scheduleProvider.ui())
                .doOnNext(result -> setLastUpdatedDate(this.dashboardViewModel.getLastUpdatedDate()))
                .subscribe(this::setExchangesInSpinner));

        this.subscription.add(this.dashboardViewModel.getCoins()
                .subscribeOn(scheduleProvider.io())
                .observeOn(scheduleProvider.ui())
                .subscribe(this::setCoinsInSpinner));

        this.subscription.add(this.dashboardViewModel.getPrice()
                .subscribeOn(scheduleProvider.io())
                .observeOn(scheduleProvider.ui())
                .subscribe(this::setPriceInView));
    }

    @Override
    public void onPause()
    {
        super.onPause();
        unbind();
    }

    private void unbind()
    {
        this.subscription.unsubscribe();
    }


    /**
     * Binding Data to View
     */
    private void setExchangesInSpinner(@NonNull final List<ExchangeParent> exchanges)
    {
        this.exchangesSpinnerAdapter = new ExchangesSpinnerAdapter(getContext(), R.layout.spinner_item, exchanges);

        this.exchangesSpinner.setAdapter(this.exchangesSpinnerAdapter);
    }

    private void setCoinsInSpinner(@NonNull final List<CoinModel> coins)
    {
        this.coinsSpinnerAdapter = new CoinsSpinnerAdapter(getContext(), R.layout.spinner_item, coins);

        this.coinsSpinner.setAdapter(this.coinsSpinnerAdapter);
    }

    private void setPriceInView(@NonNull final String price)
    {
        coinPrice.setText("$" + price);
    }


    private void exchangeSelected(@NonNull final int position)
    {
        ExchangeParent parentExchange = this.exchangesSpinnerAdapter.getItem(position);
        this.dashboardViewModel.exchangeSelected(parentExchange);
    }

    private void coinSelected(@NonNull final int position)
    {
        CoinModel coinModelSelected = this.coinsSpinnerAdapter.getItem(position);
        this.dashboardViewModel.coinSelected(coinModelSelected);
    }

    private void setLastUpdatedDate(String date)
    {
        lastUpdatedDate.setText(date);
    }
}
