package com.kxbyyk.chanin.template.util;




import com.kxbyyk.chanin.template.model.http.ex.ApiException;
import com.kxbyyk.chanin.template.model.http.response.ResultMessage;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by codeest on 2016/8/3.
 */
public class RxUtil {

    /**
     * 统一线程处理
     *
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<T, T> rxSchedulerHelper() {    //compose简化线程
        return new FlowableTransformer<T, T>() {
            @Override
            public Flowable<T> apply(Flowable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }



    public static <T> FlowableTransformer<ResultMessage<T>,T> handResultMessage(){
        return new FlowableTransformer<ResultMessage<T>, T>() {
            @Override
            public Flowable<T> apply(@NonNull Flowable<ResultMessage<T>> upstream) {
                return upstream.flatMap(new Function<ResultMessage<T>, Flowable<T>>() {
                    @Override
                    public Flowable<T> apply(@NonNull ResultMessage<T> tResultMessage) throws Exception {
                        if(ResultMessage.SUCCESS == tResultMessage.getResultCode()){
                            return createData(tResultMessage.getData());
                        }else {
                            return Flowable.error(new ApiException("数据请求失败！" + tResultMessage.getResultMsg()));
                        }


                    }
                });
            }
        };
    }


    /**
     * 生成Flowable
     *
     * @param <T>
     * @return
     */
    public static <T> Flowable<T> createData(final T t) {
        return Flowable.create(new FlowableOnSubscribe<T>() {
            @Override
            public void subscribe(FlowableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(t);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        }, BackpressureStrategy.BUFFER);
    }



}
