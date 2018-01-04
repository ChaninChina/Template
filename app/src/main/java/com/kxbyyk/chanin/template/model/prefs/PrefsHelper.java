package com.kxbyyk.chanin.template.model.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.kxbyyk.chanin.template.app.App;


/**
 * Created by Chanin on 2017-07-07.
 */
public class PrefsHelper {

    private Gson gson;


    private static final String SHAREDPREFERENCES_NAME = "mode_sp";

    private final SharedPreferences mSPrefs;


    public PrefsHelper(App app, Gson gson) {
        this.gson = gson;
        mSPrefs = app.getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
    }


}
