package com.kxbyyk.chanin.template.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDelegate;


import com.kxbyyk.chanin.template.app.App;
import com.kxbyyk.chanin.template.di.component.ActivityComponent;
import com.kxbyyk.chanin.template.di.component.DaggerActivityComponent;
import com.kxbyyk.chanin.template.di.module.ActivityMode;

import javax.inject.Inject;


/**
 * Created by Chanin on 2017/6/14.
 */
public abstract class RxActivity<T extends BasePresenter> extends BaseActivity implements BaseView {


    @Inject
    public T mPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        injectView();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStop() {
        if(mPresenter != null){
            mPresenter.unSubscribe();
        }
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();

    }

    @Override
    public void useNightMode(boolean isNight) {
        if (isNight) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        recreate();

    }

    public ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(App.getAppComponent())
                .activityMode(new ActivityMode(this))
                .build();
    }

    protected abstract void injectView();//依赖注入
}
