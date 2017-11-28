package com.example.christophercoverdale.cryptopricemvvm.schedulers;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by christophercoverdale on 28/11/2017.
 */

public class ScheduleProvider implements IScheduleProvider
{
    @Nullable
    private static ScheduleProvider INSTANCE;

    private ScheduleProvider() {}

    public static ScheduleProvider getInstance()
    {
        if (INSTANCE == null)
            INSTANCE = new ScheduleProvider();

        return INSTANCE;
    }


    @NonNull
    @Override
    public Scheduler computation()
    {
        return Schedulers.computation();
    }

    @NonNull
    @Override
    public Scheduler ui()
    {
        return AndroidSchedulers.mainThread();
    }
}
