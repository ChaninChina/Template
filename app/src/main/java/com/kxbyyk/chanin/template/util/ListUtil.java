package com.kxbyyk.chanin.template.util;

import java.util.Collections;
import java.util.List;

/**
 * Created by Chanin on 2017-07-10.
 */
public class ListUtil {


    public static boolean isEmpty(List list){

        if(list == null ||list.size()<=0){
            return true;
        }
        return false;
    }

}
