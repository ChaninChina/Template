package com.kxbyyk.chanin.template.util;



import com.kxbyyk.chanin.template.app.App;

import java.io.File;

/**
 * Created by Chanin on 2017/6/9.
 */
public class Constants {

    public static final String BUGLY_ID = "6641104962";

    public static final String EXTERNAL_PATH_DATA = App.getInstance().getExternalCacheDir().getPath() + File.separator + "data";
    public static final String PATH_DATA = App.getInstance().getCacheDir().getPath() + File.separator + "data";
    public static final String PATH_HTTP_CACHE = EXTERNAL_PATH_DATA+File.separator+"httpCache";

    public static final String AUTHORITIES = "com.kxbyyk.chanin.template.fileprovider";
}
