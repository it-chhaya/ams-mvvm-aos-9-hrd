package com.devkh.ams;

import android.app.Application;

import com.devkh.ams.di.component.AppComponent;
import com.devkh.ams.di.component.DaggerAppComponent;

public class AmsApp extends Application {

    public AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                                        .application(this)
                                        .build();
        appComponent.inject(this);
    }

}
