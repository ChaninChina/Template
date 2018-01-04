package com.kxbyyk.chanin.template.di.component;

import android.app.Activity;


import com.kxbyyk.chanin.template.di.module.ActivityMode;
import com.kxbyyk.chanin.template.di.scope.AcitvityScope;
import com.kxbyyk.chanin.template.ui.login.LoginActivity;
import com.kxbyyk.chanin.template.ui.start.SplashActivity;

import dagger.Component;

/**
 * Created by Chanin on 2017/6/14.
 */
@AcitvityScope
@Component(dependencies=AppComponent.class,modules = ActivityMode.class)
public interface ActivityComponent {
    Activity getActivity();


    void Inject(SplashActivity splashActivity);

    void Inject(LoginActivity loginActivity);
}
