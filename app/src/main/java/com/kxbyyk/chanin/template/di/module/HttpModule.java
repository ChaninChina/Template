package com.kxbyyk.chanin.template.di.module;



import com.kxbyyk.chanin.template.BuildConfig;
import com.kxbyyk.chanin.template.di.qualifier.HaveCache;
import com.kxbyyk.chanin.template.di.qualifier.NoCache;
import com.kxbyyk.chanin.template.model.http.HttpHelper;
import com.kxbyyk.chanin.template.model.http.api.HaveCacheApis;
import com.kxbyyk.chanin.template.model.http.api.NoCacheHttpApis;
import com.kxbyyk.chanin.template.model.http.cache.CacheTag;
import com.kxbyyk.chanin.template.util.Constants;
import com.kxbyyk.chanin.template.util.ListUtil;
import com.kxbyyk.chanin.template.util.SystemUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Chanin on 2017/6/14.
 */
@Module
public class HttpModule {

    @Provides
    @Singleton
    Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Provides
    @Singleton
    OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

    @Provides
    @Singleton
    @HaveCache
    OkHttpClient provideCacheOkHttpClient(OkHttpClient.Builder builder) {
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
        }

        buildCache(builder);
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(true);

        return builder.build();
    }

    private void buildCache(OkHttpClient.Builder builder) {
        File cacheFile = new File(Constants.PATH_HTTP_CACHE);
        final Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
        builder.cache(cache);
        Interceptor networkInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);
                int maxAge = 60 * 60 * 24 * 28;
                response.newBuilder().header("Cache-Control", "public,max-age=" + maxAge)
                        .removeHeader("Pragma")
                        .build();//默认全部缓存，过期时间为4周。
                List<String> cacheTag = request.headers("cacheTag");
                if (!ListUtil.isEmpty(cacheTag)) {
                    for (String tag : cacheTag) {
                        if (CacheTag.NO_CACHE.equalsIgnoreCase(tag)) {
                            response.newBuilder().header("Cache-Control", "no-store")
                                    .removeHeader("Pragma")
                                    .build();//修改响应头，不缓存。
                        }
                    }
                }
                return response;
            }
        };

        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = null;
                List<String> cacheTag = request.headers("cacheTag");
                if (!ListUtil.isEmpty(cacheTag)) {
                    for (String tag : cacheTag) {
                        if (CacheTag.ONLY_CACHE.equalsIgnoreCase(tag)) {//只从缓存中读
                            request = request.newBuilder()
                                    .cacheControl(CacheControl.FORCE_CACHE)
                                    .build();
                        } else if (CacheTag.ONLY_NETWORK.equalsIgnoreCase(tag)) {//只从网络中获取
                            if (SystemUtil.isNetworkConnected()) {
                                request = request.newBuilder()
                                        .cacheControl(CacheControl.FORCE_NETWORK)
                                        .build();
                            }else {//若网络不可用直接抛出异常
                                throw new IOException("网络不可用！");
                            }
                        } else if (CacheTag.CACHE_ELSE_NETWORK.equalsIgnoreCase(tag)) {//先从缓存中获取，若无再请求网络
                            request = request.newBuilder()
                                    .cacheControl(CacheControl.FORCE_CACHE)
                                    .build();
                            response = chain.proceed(request);
                            Response cacheResponse = response.cacheResponse();
                            if (cacheResponse == null) {//无缓存的情况，从网络获取
                                response = null;
                                if (SystemUtil.isNetworkConnected()) {
                                    request = request.newBuilder()
                                            .cacheControl(CacheControl.FORCE_NETWORK)
                                            .build();
                                }else {//若网络不可用直接抛出异常
                                    throw new IOException("网络不可用！");
                                }
                            }
                        } else if (CacheTag.NETWORK_ELSE_CACHE.equalsIgnoreCase(tag)) {//先进行网络请求，请求失败再获取缓存
                            if (SystemUtil.isNetworkConnected()) {
                                request = request.newBuilder()
                                        .cacheControl(CacheControl.FORCE_NETWORK)
                                        .build();
                                try {
                                    response = chain.proceed(request);
                                } catch (Exception e) {//抛出异常，表示网络请求失败，改从本地获取
                                    request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE)
                                            .build();
                                }
                            } else {//网络不可用，直接从本地获取
                                request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE)
                                        .build();
                            }
                        }
                    }
                }

                if (response == null) {
                    response = chain.proceed(request);
                }
                return response;
            }
        };
        builder.addNetworkInterceptor(networkInterceptor);
        builder.addInterceptor(interceptor);
    }


    @Provides
    @Singleton
    @NoCache
    OkHttpClient provideNoCacheOkHttpClient(OkHttpClient.Builder builder) {
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
        }

        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(true);

        return builder.build();
    }

    @Provides
    @Singleton
    @HaveCache
    Retrofit createCacheRetrofit(Retrofit.Builder builder, @HaveCache OkHttpClient client) {
        return createRetrofit(builder, client, HaveCacheApis.HOST);
    }

    @Provides
    @Singleton
    @NoCache
    Retrofit createNoCacheRetrofit(Retrofit.Builder builder, @NoCache OkHttpClient client) {
        return createRetrofit(builder, client, NoCacheHttpApis.HOST);
    }



    private Retrofit createRetrofit(Retrofit.Builder builder, OkHttpClient client, String url) {
        return builder
                .baseUrl(url)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    NoCacheHttpApis provideNoCacheHttpApis(@NoCache Retrofit retrofit) {
        return retrofit.create(NoCacheHttpApis.class);
    }

    @Provides
    @Singleton
    HaveCacheApis provideHaveCacheHttpApis(@HaveCache Retrofit retrofit) {
        return retrofit.create(HaveCacheApis.class);
    }


    @Provides
    @Singleton
    HttpHelper provideHttpHelper(HaveCacheApis haveCacheApis, NoCacheHttpApis noCacheHttpApis) {
        return new HttpHelper(haveCacheApis, noCacheHttpApis);
    }



}
