package com.kxbyyk.chanin.template.presenter.contract;


import com.kxbyyk.chanin.template.base.BasePresenter;
import com.kxbyyk.chanin.template.base.BaseView;

/**
 * Created by Chanin on 2017/6/16.
 */
public interface SplashContract {

    interface View extends BaseView {
        void gotoMainActivity();
    }


    interface Presenter extends BasePresenter<View> {
           void  delay(int time);

    }

}
