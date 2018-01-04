package com.kxbyyk.chanin.template.util.algorithm;

import java.security.MessageDigest;

/**
 * Created by Chanin on 2017-12-11.
 */

public class Md5Util {

    public static final String ALGORITHM = "MD5";
    public static final String CHARSET = "UTF-8";

    public static byte[] encryptMD5(byte[] data) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance(ALGORITHM);
        md5.update(data);
        return md5.digest();
    }

    /**
     * @param data 要签名的明文
     * @return BASE64 编码的签名
     * @throws Exception
     */
    public static String encryptMD5(String data) throws Exception{
        return Base64Util.encodeToString(encryptMD5(data.getBytes(CHARSET)));
    }


}
