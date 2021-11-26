package com.devkh.ams.ui.main;

import android.os.Bundle;

import com.devkh.ams.BR;
import com.devkh.ams.R;
import com.devkh.ams.databinding.ActivityMainBinding;
import com.devkh.ams.di.component.ActivityComponent;
import com.devkh.ams.ui.base.BaseActivity;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    private ActivityMainBinding mActivityMainBinding;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = getViewDataBinding();
    }

    @Override
    public void performDI(ActivityComponent activityComponent) {

    }

}