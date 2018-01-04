package com.kxbyyk.chanin.template.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;

import com.kxbyyk.chanin.template.ui.login.LoginActivity;


/**
 * Created by Chanin on 2017-08-17.
 */

public class ActivityUtil {


    public static void startActivity(Activity activity, Intent intent) {
        ActivityOptionsCompat options = ActivityOptionsCompat.makeCustomAnimation(activity, android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            activity.startActivity(intent, options.toBundle());
        } else {
            activity.startActivity(intent);
        }
    }


    public static void startActivityForResult(Activity activity, Intent intent, int requestCode) {
        ActivityOptionsCompat options = ActivityOptionsCompat.makeCustomAnimation(activity, android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            activity.startActivityForResult(intent, requestCode, options.toBundle());
        } else {
            activity.startActivityForResult(intent, requestCode);
        }
    }

    public static void startLoginAgain(Activity context){
        Intent intent = new Intent(context, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        ActivityUtil.startActivity(context,intent);
    }
}
