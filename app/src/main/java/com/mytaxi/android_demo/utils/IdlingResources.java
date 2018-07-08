package com.mytaxi.android_demo.utils;

import android.support.test.espresso.idling.CountingIdlingResource;

public class IdlingResources {

    public static CountingIdlingResource countingIdlingResource = new CountingIdlingResource("mytaxi");

    public static void increment() {
        countingIdlingResource.increment();
    }

    public static void decrement() {
        countingIdlingResource.decrement();
    }
}