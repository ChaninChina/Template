package com.kxbyyk.chanin.template.presenter;



import com.kxbyyk.chanin.template.base.RxPresenter;
import com.kxbyyk.chanin.template.presenter.contract.SplashContract;
import com.kxbyyk.chanin.template.util.RxUtil;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by Chanin on 2017/6/16.
 */
public class SplashPresenter extends RxPresenter<SplashContract.View> implements SplashContract.Presenter {

    @Inject
    public SplashPresenter() {
    }

    @Override
    public void delay(int time) {
        addSubscribe(Flowable.timer(time, TimeUnit.MILLISECONDS)
                .compose(RxUtil.<Long>rxSchedulerHelper())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(@NonNull Long aLong) throws Exception {
                        getView().gotoMainActivity();
                    }
                }));
    }
}
