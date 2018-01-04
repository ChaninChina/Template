package com.kxbyyk.chanin.template.util;

import android.provider.Settings;
import android.view.View;

/**
 * 防止连续点击
 * Created by Chanin on 2017-07-11.
 */

public abstract class RdOnClicklistener implements View.OnClickListener{

    private long last;
    private long interval;//按钮点击响应间隔

    public RdOnClicklistener(long interval) {
        this.interval = interval;
    }

    @Override
    public void onClick(View v) {
       long clickTime  = System.currentTimeMillis();
        if(clickTime-last<interval){
            return;
        }
        last = clickTime;
        onRdClick(v);

    }

    public abstract void onRdClick(View v);
}
