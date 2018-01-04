package com.kxbyyk.chanin.template.presenter;



import com.kxbyyk.chanin.template.base.RxPresenter;
import com.kxbyyk.chanin.template.model.http.HttpHelper;
import com.kxbyyk.chanin.template.presenter.contract.LoginContract;

import javax.inject.Inject;

/**
 * Created by Chanin on 2017-07-13.
 */

public class LoginPresenter extends RxPresenter<LoginContract.View> implements LoginContract.Presenter{

    HttpHelper httpHelper;

    @Inject
    public LoginPresenter(HttpHelper httpHelper) {
        this.httpHelper = httpHelper;
    }

    @Override
    public void login(String name, String password) {

    }
}
