package com.kxbyyk.chanin.template.ui.login;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ScrollView;


import com.kxbyyk.chanin.template.R;
import com.kxbyyk.chanin.template.base.RxActivity;
import com.kxbyyk.chanin.template.presenter.LoginPresenter;
import com.kxbyyk.chanin.template.presenter.contract.LoginContract;
import com.kxbyyk.chanin.template.util.ActivityUtil;
import com.kxbyyk.chanin.template.util.SnackbarUtil;
import com.kxbyyk.chanin.template.widget.ClearWriteEditText;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A login screen that offers login via UserName/mPassword.
 */
public class LoginActivity extends RxActivity<LoginPresenter> implements LoginContract.View {


    private static final int REGISTER_REQUEST_CODE = 300;
    @BindView(R.id.view_toolbar)
    Toolbar viewToolbar;
    @BindView(R.id.login_progress)
    RelativeLayout mProgressView;
    @BindView(R.id.username)
    ClearWriteEditText mUserName;
    @BindView(R.id.password)
    ClearWriteEditText mPassword;
    @BindView(R.id.login_form)
    ScrollView mLoginFormView;


    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {

        setToolBar(viewToolbar, "登录");

    }

    @Override
    protected void injectView() {
        getActivityComponent().Inject(this);
    }


    private boolean isUserNameValid(String UserName) {

        if (TextUtils.isEmpty(UserName)) {
            mUserName.setShakeAnimation();
            mUserName.setError("不能为空！");
            mUserName.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    private boolean isPasswordValid(String password) {

        if (TextUtils.isEmpty(password)) {
            mPassword.setShakeAnimation();
            mPassword.setError("不能为空！");
            mPassword.requestFocus();
            return false;
        } else {
            return true;
        }


    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    @Override
    public void showProgress(final boolean show) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }


    @Override
    public void showError(String msg) {
        showProgress(false);
        SnackbarUtil.show(mProgressView, msg);
    }

    @Override
    public void gotoMainActivity() {
//        Intent intent = new Intent(this, MainActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        ActivityUtil.startActivity(this, intent);
        finish();
    }





    private void login() {
        final String username = mUserName.getText().toString().trim();
        final String password = mPassword.getText().toString().trim();
        if (!isUserNameValid(username) || !isPasswordValid(password)) {
            return;
        }
        showProgress(true);
        mPresenter.login(username, password);
    }


    @OnClick({R.id.tv_login_register, R.id.user_sign_in_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_login_register:
//                Intent intent = new Intent(this, RegisterActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                ActivityUtil.startActivityForResult(this, intent, REGISTER_REQUEST_CODE);

                break;
            case R.id.user_sign_in_button:
                login();
                //gotoMainActivity();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REGISTER_REQUEST_CODE && resultCode == RESULT_OK) {
            String userName = data.getStringExtra("username");
            String password = data.getStringExtra("password");
            mUserName.setText(userName);
            mPassword.setText(password);
        }

    }

}

