package com.kxbyyk.chanin.template.di.component;

import com.google.gson.Gson;
import com.kxbyyk.chanin.template.app.App;
import com.kxbyyk.chanin.template.di.module.AppModule;
import com.kxbyyk.chanin.template.di.module.HttpModule;
import com.kxbyyk.chanin.template.model.db.DBHelper;
import com.kxbyyk.chanin.template.model.http.HttpHelper;
import com.kxbyyk.chanin.template.model.prefs.PrefsHelper;


import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Chanin on 2017/6/14.
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    App getContext();

    Gson getGson();

    DBHelper getDBHelper();

    HttpHelper getHttpHelper();

    PrefsHelper getPrefsHelper();



}
