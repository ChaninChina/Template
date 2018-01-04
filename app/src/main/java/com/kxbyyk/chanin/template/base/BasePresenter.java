package com.kxbyyk.chanin.template.base;

/**
 * Created by Chanin on 2017/6/14.
 */
public interface BasePresenter<T extends BaseView> {

    void attachView(T view);

    void unSubscribe();

    void detachView();


}
