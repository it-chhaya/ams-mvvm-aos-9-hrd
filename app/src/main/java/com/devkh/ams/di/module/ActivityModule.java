package com.devkh.ams.di.module;

import com.devkh.ams.ui.base.BaseActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private BaseActivity<?, ?> activity;

    public ActivityModule(BaseActivity<?, ?> activity) {
        this.activity = activity;
    }

    @Provides
    String provideBaseUrl() {
        return "https://ams.kshrd-ite.com/";
    }

}
