package com.kxbyyk.chanin.template.di.module;

import android.app.Activity;


import com.kxbyyk.chanin.template.di.scope.AcitvityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Chanin on 2017/6/14.
 */
@Module
public class ActivityMode {
    private Activity mActivity;

    public ActivityMode(Activity mActivity) {
        this.mActivity = mActivity;
    }
    @Provides
    @AcitvityScope
    public Activity provideActivity(){
        return mActivity;
    }
}
