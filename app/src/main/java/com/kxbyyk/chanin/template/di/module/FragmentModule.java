package com.kxbyyk.chanin.template.di.module;




import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;


import com.kxbyyk.chanin.template.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Chanin on 2017/6/14.
 */
@Module
public class FragmentModule {

    private Fragment fragment;


    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }



    @Provides
    @FragmentScope
    public Fragment provideFragment(){
        return fragment;
    }


    @Provides
    @FragmentScope
    public Activity provideActivity(){
        return fragment.getActivity();
    }


    @Provides
    @FragmentScope
    public Context provideContext(){
        return fragment.getContext();
    }
}
