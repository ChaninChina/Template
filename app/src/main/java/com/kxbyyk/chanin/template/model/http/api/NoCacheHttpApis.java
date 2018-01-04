package com.kxbyyk.chanin.template.model.http.api;


import com.kxbyyk.chanin.template.model.http.response.ResultMessage;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by Chanin on 2017-07-04.
 */
public interface NoCacheHttpApis {

    String HOST="http://192.168.0.162:8080/xjm/data/";


    @Headers("CacheTag:缓存策略")
    @GET("test/test")
    Flowable<ResultMessage> getTest(@Query("param") String param);


    @GET("test/test")
    Flowable<ResultMessage> getTest(@Header("CacheTag") String cache, @Query("param") String param);

}
