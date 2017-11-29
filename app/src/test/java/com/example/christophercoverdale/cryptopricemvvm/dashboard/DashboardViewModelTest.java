package com.example.christophercoverdale.cryptopricemvvm.dashboard;

import android.support.annotation.NonNull;

import com.example.christophercoverdale.cryptopricemvvm.coinbase.coinbasemodel.CoinbaseModel;
import com.example.christophercoverdale.cryptopricemvvm.datamodel.CoinModel;
import com.example.christophercoverdale.cryptopricemvvm.datamodel.Exchange;
import com.example.christophercoverdale.cryptopricemvvm.datamodel.ExchangeParent;
import com.example.christophercoverdale.cryptopricemvvm.datamodel.ExchangesDataModel;
import com.example.christophercoverdale.cryptopricemvvm.datamodelmanager.DataModelManager;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import rx.Observable;
import rx.observers.TestObserver;
import rx.observers.TestSubscriber;

import static org.junit.Assert.*;

/**
 * Created by christophercoverdale on 28/11/2017.
 */
public class DashboardViewModelTest
{
    @Mock
    DataModelManager dataModelManager;

    @NonNull
    private DashboardViewModel dashboardViewModel;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        this.dashboardViewModel = new DashboardViewModel(this.dataModelManager);
    }

    @Test
    public void testDashboardViewModelIsInitialized()
    {
        Assert.assertTrue(dashboardViewModel != null);
    }

    @Test
    public void testGetSupportedExchanges_returnsObservableListOfExchanges()
    {
        //CoinbaseModel
        CoinbaseModel coinbaseModel = new CoinbaseModel();

        //Exchange and list of Exchanges
        Exchange coinbaseExchange = new Exchange("Coinbase", coinbaseModel, coinbaseModel, coinbaseModel);
        Object[] exchangeParentList = {coinbaseExchange};

        //Exchanges Data Model holding multiple Exchange
        ExchangesDataModel exchangesDataModel = new ExchangesDataModel(exchangeParentList);

        //When the dataModelManager -requestExchangeModel is called, then return the above exchangesDataModel
        Mockito.when(this.dataModelManager.requestExchangeModel()).thenReturn(Observable.just(exchangesDataModel));

        TestSubscriber<List<ExchangeParent>> testSubscriber = new TestSubscriber<>();

        this.dashboardViewModel.getSupportedExchanges().subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        testSubscriber.assertValue(exchangesDataModel.getExchanges());
    }

    @Test
    public void testGetCoins_returnsObservableListOfCoinsSize()
    {

        /**
         * Setup
         */
        //CoinModel
        CoinbaseModel coinbaseModelBTC = new CoinbaseModel();
        coinbaseModelBTC.setBase("BTC");

        CoinbaseModel coinbaseModelETH = new CoinbaseModel();
        coinbaseModelETH.setBase("ETH");

        CoinbaseModel coinbaseModelLTC = new CoinbaseModel();
        coinbaseModelLTC.setBase("LTC");

        //Set selected Exchange
        ExchangeParent exchange = new Exchange("coinbase", coinbaseModelBTC, coinbaseModelETH, coinbaseModelLTC);
        this.dashboardViewModel.exchangeSelected(exchange);


        /**
         * When
         */
        List<CoinModel> listOfCoins = this.dashboardViewModel.getCoins().toBlocking().first();
        int expectedSizeOfList = listOfCoins.size();


        /**
         * Then
         */
        Assert.assertEquals(exchange.getCoins().size(), expectedSizeOfList);
    }

    @Test
    public void testGetCoins_returnsObservableListOfCoinsWithTheSameSymbol()
    {
        /**
         * Setup
         */
        ///CoinModel
        CoinbaseModel coinbaseModelBTC = new CoinbaseModel();
        coinbaseModelBTC.setSymbol("BTC");

        CoinbaseModel coinbaseModelETH = new CoinbaseModel();
        coinbaseModelETH.setSymbol("ETH");

        CoinbaseModel coinbaseModelLTC = new CoinbaseModel();
        coinbaseModelLTC.setSymbol("LTC");

        //Set selected Exchange
        ExchangeParent exchange = new Exchange("coinbase", coinbaseModelBTC, coinbaseModelETH, coinbaseModelLTC);
        this.dashboardViewModel.exchangeSelected(exchange);


        /**
         * When
         */
        List<CoinModel> listOfCoins = this.dashboardViewModel.getCoins().toBlocking().first();
        String symbol = listOfCoins.get(0).getSymbol();


        /**
         * Then
         */
        Assert.assertEquals(coinbaseModelBTC.getSymbol(), symbol);
    }

    @Test
    public void testGetPrice_fromSelectedACoin()
    {
        /**
         * Setup
         */
        //Create the selected coin
        CoinModel coinbaseModelBTC = new CoinbaseModel();
        coinbaseModelBTC.setSymbol("BTC");
        coinbaseModelBTC.setPrice("10000");

        //Set selected coin to coinbaseModelBTC
        this.dashboardViewModel.coinSelected(coinbaseModelBTC);


        /**
         * When
         */
        String price = this.dashboardViewModel.getPrice().toBlocking().first();


        /**
         * Then
         */
        Assert.assertEquals(coinbaseModelBTC.getPrice(), price);
    }
}