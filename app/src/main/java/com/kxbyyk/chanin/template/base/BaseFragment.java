package com.kxbyyk.chanin.template.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Chanin on 2017/6/14.
 */
public abstract class BaseFragment extends Fragment {


    protected View mView;
    protected Activity mActivity;
    protected Context mContext;
    private Unbinder mUnBinder;
    private boolean isInited = false;

    @Override
    public void onAttach(Context context) {
        mActivity = (Activity) context;
        mContext = context;
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        mActivity = null;
        mContext = null;
        super.onDetach();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(getLayoutId(), container,false);
        mUnBinder = ButterKnife.bind(this, mView);
        initView(mView);
        return mView;
    }

    protected abstract void initView(View mView);

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!isInited&&!isHidden()) {
            isInited = true;
            initEventAndData(savedInstanceState);
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!isInited && !hidden) {
            isInited = true;
            initEventAndData(null);
        }
    }

    @Override
    public void onDestroyView() {
        mUnBinder.unbind();
        super.onDestroyView();

    }

    @Override
    public void onDestroy() {

        super.onDestroy();
    }

    protected abstract int getLayoutId();

    protected abstract void initEventAndData(Bundle savedInstanceState);
}
