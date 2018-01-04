package com.kxbyyk.chanin.template.di.component;



import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;


import com.kxbyyk.chanin.template.di.module.FragmentModule;
import com.kxbyyk.chanin.template.di.scope.FragmentScope;


import dagger.Component;

/**
 * Created by Chanin on 2017/6/14.
 */
@FragmentScope
@Component(dependencies = AppComponent.class,modules = FragmentModule.class)
public interface FragmentComponent {

    Fragment getFragment();

    Activity getActivity();

    Context getContext();


}
