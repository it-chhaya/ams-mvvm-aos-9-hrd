package com.devkh.ams.ui.base;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.devkh.ams.AmsApp;
import com.devkh.ams.di.component.ActivityComponent;
import com.devkh.ams.di.component.DaggerActivityComponent;
import com.devkh.ams.di.module.ActivityModule;
import com.devkh.ams.utils.CommonUtils;
import com.google.android.material.progressindicator.CircularProgressIndicator;

import javax.inject.Inject;

public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel> extends AppCompatActivity {

    private CircularProgressIndicator mCircularProgressIndicator;

    private T mViewDataBinding;

    public T getViewDataBinding() {
        return mViewDataBinding;
    }

    @Inject
    protected V mViewModel;

    /*
    * Will override by UI for set binding variable
    */
    public abstract int getBindingVariable();

    /*
     * return layout resource ID
     */
    public abstract @LayoutRes int getLayoutId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        performDI(getBuildComponent());
        super.onCreate(savedInstanceState);

        performDataBinding();
    }

    private ActivityComponent getBuildComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(((AmsApp)getApplication()).appComponent)
                .activityModule(new ActivityModule(this))
                .build();
    }

    public abstract void performDI(ActivityComponent activityComponent);

    private void performDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel);
        mViewDataBinding.executePendingBindings();
    }

    protected void hideLoading() {
        if (mCircularProgressIndicator != null && mCircularProgressIndicator.isShown()) {
            mCircularProgressIndicator.hide();
        }
    }

    protected void showLoading() {
        hideLoading();
        mCircularProgressIndicator = CommonUtils.showLoading(this);
    }


}
