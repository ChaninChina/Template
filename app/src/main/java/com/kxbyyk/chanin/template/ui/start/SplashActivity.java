package com.kxbyyk.chanin.template.ui.start;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;

import com.kxbyyk.chanin.template.R;
import com.kxbyyk.chanin.template.base.RxActivity;
import com.kxbyyk.chanin.template.presenter.SplashPresenter;
import com.kxbyyk.chanin.template.presenter.contract.SplashContract;
import com.kxbyyk.chanin.template.ui.login.LoginActivity;
import com.kxbyyk.chanin.template.util.ActivityUtil;


public class SplashActivity extends RxActivity<SplashPresenter> implements SplashContract.View {


    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {

        mPresenter.delay(2000);
    }

    @Override
    protected void injectView() {
        getActivityComponent().Inject(this);
    }

    @Override
    public void gotoMainActivity() {

        Intent intent = new Intent(this, LoginActivity.class);
        ActivityUtil.startActivity(this,intent);

    }

    @Override
    public void showError(String msg) {

    }
}
