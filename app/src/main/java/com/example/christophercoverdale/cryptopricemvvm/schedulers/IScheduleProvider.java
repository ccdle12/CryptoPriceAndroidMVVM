package com.example.christophercoverdale.cryptopricemvvm.schedulers;

import rx.Scheduler;

/**
 * Created by christophercoverdale on 28/11/2017.
 */

public interface IScheduleProvider
{
    Scheduler computation();
    Scheduler ui();
    Scheduler io();

}
