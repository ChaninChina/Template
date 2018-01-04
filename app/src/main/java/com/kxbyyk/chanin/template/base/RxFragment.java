package com.kxbyyk.chanin.template.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.kxbyyk.chanin.template.app.App;
import com.kxbyyk.chanin.template.di.component.DaggerFragmentComponent;
import com.kxbyyk.chanin.template.di.component.FragmentComponent;
import com.kxbyyk.chanin.template.di.module.FragmentModule;

import javax.inject.Inject;


/**
 * Created by Chanin on 2017/6/14.
 */
public abstract class RxFragment<T extends BasePresenter> extends BaseFragment implements BaseView {

    @Inject
    public T mPresenter;


    public FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder()
                .appComponent(App.getAppComponent())
                .fragmentModule(new FragmentModule(this))
                .build();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectView();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    public void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    /**
     * 在Fragment不可见时，是否终止后台线程，视情况在子类使用。
     * //Transaction show() hide()时会调用
     *
     * @Override public void onHiddenChanged(boolean hidden) {
     * if(hidden){
     * if (mPresenter != null) {
     * mPresenter.unSubscribe();
     * }
     * }
     * super.onHiddenChanged(hidden);
     * }
     * <p>
     * //FragmentAdapter 切换时会调用
     * @Override public void setUserVisibleHint(boolean isVisibleToUser) {
     * if(!isVisibleToUser){
     * if (mPresenter != null) {
     * mPresenter.unSubscribe();
     * }
     * }
     * super.setUserVisibleHint(isVisibleToUser);
     * }
     */

    protected abstract void injectView();

    @Override
    public void useNightMode(boolean isNight) {

    }
}
