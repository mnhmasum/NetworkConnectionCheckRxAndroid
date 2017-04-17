package com.example.nazmul.networkchecker;

import android.app.Application;

public class App extends Application {
    private static App instance;

    private RxBus bus;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        bus = new RxBus();
    }

    public static App get() {
        return instance;
    }

    public RxBus bus() {
        return bus;
    }
}
