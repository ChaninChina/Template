package com.kxbyyk.chanin.template.util.algorithm;

import java.security.MessageDigest;

/**
 * Created by Chanin on 2017-12-11.
 */

public class ShaUtil {

    public static final String CHARSET = "UTF-8";

    public static final String SHA_1 = "SHA-1";
    public static final String SHA_224 = "SHA-224";
    public static final String SHA_256 = "SHA-256";
    public static final String SHA_384 = "SHA-384";
    public static final String SHA_512 = "SHA-512";

    /**
     *
     * @param data to be encrypted
     * @param shaN encrypt method,SHA-1,SHA-224,SHA-256,SHA-384,SHA-512
     * @return 已加密的数据
     * @throws Exception
     */
    public static byte[] encryptSHA(byte[] data, String shaN) throws Exception {
        MessageDigest sha = MessageDigest.getInstance(shaN);
        sha.update(data);
        return sha.digest();
    }

    /**
     * @param data 明文
     * @param algorithm SHA签名策略
     * @return Base64编码的密文
     * @throws Exception
     */
    public static String encrypt(String data,String algorithm) throws Exception{
        return Base64Util.encodeToString(encryptSHA(data.getBytes(CHARSET),algorithm));
    }



}
