package com.kxbyyk.chanin.template.di.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kxbyyk.chanin.template.app.App;
import com.kxbyyk.chanin.template.model.db.DBHelper;
import com.kxbyyk.chanin.template.model.prefs.PrefsHelper;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.http.GET;

/**
 * Created by Chanin on 2017/6/14.
 */
@Module
public class AppModule {

    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    App provideApplicationContext() {
        return app;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().disableHtmlEscaping().create();
    }

    @Provides
    @Singleton
    DBHelper provideDBHelper(App app, Gson gson) {
        return new DBHelper(app, gson);
    }
    @Provides
    @Singleton
    PrefsHelper providePrefsHelper(App app, Gson gson){
        return new PrefsHelper(app,gson);
    }


}
