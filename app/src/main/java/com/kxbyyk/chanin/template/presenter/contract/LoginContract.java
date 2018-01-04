package com.kxbyyk.chanin.template.presenter.contract;


import com.kxbyyk.chanin.template.base.BasePresenter;
import com.kxbyyk.chanin.template.base.BaseView;

/**
 * Created by Chanin on 2017/6/16.
 */
public interface LoginContract {

    interface View extends BaseView {
        void gotoMainActivity();

        void showProgress(boolean show);
    }


    interface Presenter extends BasePresenter<View> {
           void login(String name, String password);
    }

}
