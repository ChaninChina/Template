package com.kxbyyk.chanin.template.util.algorithm;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by Chanin on 2017-12-11.
 */

public class HmacUtil {

    public static final String CHARSET = "UTF-8";
    public static String HmacMD5 = "HmacMD5"; //摘要长度128
    public static String HmacSHA1 = "HmacSHA1";  //摘要长度160
    public static String HmacSHA256 = "HmacSHA256";    //摘要长度256
    public static String HmacSHA384 = "HmacSHA384";     //摘要长度384
    public static String HmacSHA512 = "HmacSHA512";        //摘要长度512


    public static byte[] decryptBASE64(String key) throws Exception {
        return Base64Util.decode(key);
    }

    public static String encryptBASE64(byte[] key) throws Exception {
        return Base64Util.encodeToString(key);
    }

    /**
     * 初始化HMAC密钥
     *
     * @return
     * @throws Exception
     */
    public static String initMacKey(String ALGORITHM) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        SecretKey secretKey = keyGenerator.generateKey();
        return encryptBASE64(secretKey.getEncoded());
    }

    /**
     * HMAC加密
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encryptHMAC(byte[] data, String key, String ALGORITHM) throws Exception {

        //SecretKey secretKey = new SecretKeySpec(decryptBASE64(key), "HmacMD5");
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);//直接用给定的字符串进行
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        mac.init(secretKey);

        return mac.doFinal(data);

    }

    /**
     * @param data 要加密的明文
     * @param key HmacSHA1秘钥
     * @return HmacSHA1加密的密文
     * @throws Exception
     */
    public static String encryptHmacSHA1(String data,String key) throws Exception{
        return Base64Util.encodeToString(encryptHMAC(data.getBytes(CHARSET),key,HmacSHA1));
    }


    /**
     * @param data 要加密的明文
     * @param key HmacSHA256秘钥
     * @return HmacSHA256加密的密文
     * @throws Exception
     */
    public static String encryptHmacSHA256(String data,String key) throws Exception{
        return Base64Util.encodeToString(encryptHMAC(data.getBytes(CHARSET),key,HmacSHA256));
    }


    /**
     * @param data 要加密的明文
     * @param key HmacSHA384秘钥
     * @return HmacSHA384加密的密文
     * @throws Exception
     */
    public static String encryptHmacSHA384(String data,String key) throws Exception{
        return Base64Util.encodeToString(encryptHMAC(data.getBytes(CHARSET),key,HmacSHA384));
    }


    /**
     * @param data 要加密的明文
     * @param key HmacSHA512秘钥
     * @return HmacSHA512加密的密文
     * @throws Exception
     */
    public static String encryptHmacSHA512(String data,String key) throws Exception{
        return Base64Util.encodeToString(encryptHMAC(data.getBytes(CHARSET),key,HmacSHA512));
    }


    /**
     * @param data 要加密的明文
     * @param key HmacMD5秘钥
     * @return HmacMD5加密的密文
     * @throws Exception
     */
    public static String encryptHmacMD5(String data,String key) throws Exception{
        return Base64Util.encodeToString(encryptHMAC(data.getBytes(CHARSET),key,HmacMD5));
    }

}
