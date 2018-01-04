package com.kxbyyk.chanin.template.base;


import com.kxbyyk.chanin.template.util.RxBus;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Chanin on 2017/6/16.
 */
public class RxPresenter<T extends BaseView> implements BasePresenter<T> {



    protected WeakReference<T> mView;//使用弱引用，防止onDestroy()不执行时内存泄漏
    protected CompositeDisposable mCompositeDisposable;


    protected void addSubscribe(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    protected T getView() {
        T t = mView.get();
        if (t == null) {
            detachView();
            return null;
        }
        return t;
    }


    protected <U> void addRxBusSubscribe(Class<U> eventType, Consumer<U> act) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(RxBus.getDefault().toDefaultFlowable(eventType, act));
    }

    @Override
    public void unSubscribe() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
        }
    }

    @Override
    public void attachView(T view) {
        this.mView = new WeakReference<T>(view);
    }


    @Override
    public void detachView() {
        if(this.mView!=null){
            this.mView.clear();
            this.mView = null;
        }
        unSubscribe();
    }

}
