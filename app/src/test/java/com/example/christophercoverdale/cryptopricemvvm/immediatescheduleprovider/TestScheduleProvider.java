package com.example.christophercoverdale.cryptopricemvvm.immediatescheduleprovider;

import android.support.annotation.NonNull;

import com.example.christophercoverdale.cryptopricemvvm.schedulers.IScheduleProvider;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by christophercoverdale on 28/11/2017.
 */

public class TestScheduleProvider implements IScheduleProvider
{
    @NonNull
    public Scheduler computation() {
        return null;
    }

    @NonNull
    public Scheduler ui() {
        return null;
    }

    @Override
    public Scheduler io() {
        return null;
    }
}
