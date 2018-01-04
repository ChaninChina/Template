package com.kxbyyk.chanin.template.model.db;

import com.google.gson.Gson;

import com.kxbyyk.chanin.template.app.App;

import org.greenrobot.greendao.database.Database;

/**
 * Created by Chanin on 2017-07-04.
 */
public class DBHelper {

    private App app;
    private Gson gson;
    private static final String DB_NAME = "mode.db";


    public DBHelper(App app,Gson gson) {
        this.app = app;
        this.gson = gson;

//        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(app, DB_NAME);
//        Database writableDb = devOpenHelper.getWritableDb();
//        daoSession = new DaoMaster(writableDb).newSession();
    }


}
