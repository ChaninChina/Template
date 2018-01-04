package com.kxbyyk.chanin.template.di.qualifier;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by Chanin on 2017-07-04.
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface NoCache {
}
