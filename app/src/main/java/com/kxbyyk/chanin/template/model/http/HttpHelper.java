package com.kxbyyk.chanin.template.model.http;


import com.kxbyyk.chanin.template.model.http.api.HaveCacheApis;
import com.kxbyyk.chanin.template.model.http.api.NoCacheHttpApis;

/**
 * Created by Chanin on 2017-07-07.
 */
public class HttpHelper {


    public HaveCacheApis haveCacheApis;
    public NoCacheHttpApis noCacheHttpApis;


    public HttpHelper(HaveCacheApis haveCacheApis, NoCacheHttpApis noCacheHttpApis) {
        this.haveCacheApis = haveCacheApis;
        this.noCacheHttpApis = noCacheHttpApis;
    }



}
