package com.devkh.ams.di.component;

import com.devkh.ams.ui.main.MainActivity;
import com.devkh.ams.di.module.ActivityModule;
import com.devkh.ams.di.scope.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(modules = {ActivityModule.class}, dependencies = {AppComponent.class})
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
