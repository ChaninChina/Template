package com.kxbyyk.chanin.template.util.algorithm;

import java.nio.charset.Charset;
import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * Created by Chanin on 2017-12-11.
 */

public class DesUtil {

    public static final String ALGORITHM = "DES";
    public static final String CHARSET = "UTF-8";

    public static byte[] decryptBASE64(String key) throws Exception {
        return Base64Util.decode(key);
    }

    public static String encryptBASE64(byte[] key) throws Exception {
        return Base64Util.encodeToString(key);
    }

    private static Key toKey(byte[] key) throws Exception {
        DESKeySpec dks = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        SecretKey secretKey = keyFactory.generateSecret(dks);

        // 当使用其他对称加密算法时，如AES、Blowfish等算法时，用下述代码替换上述三行代码
        // SecretKey secretKey = new SecretKeySpec(key, ALGORITHM);

        return secretKey;
    }

    public static byte[] decrypt(byte[] data, String key) throws Exception {
        Key k = toKey(decryptBASE64(key));

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, k);

        return cipher.doFinal(data);
    }

    public static byte[] encrypt(byte[] data, String key) throws Exception {
        Key k = toKey(decryptBASE64(key));
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, k);

        return cipher.doFinal(data);
    }

    public static String initKey() throws Exception {
        return initKey(null);
    }

    public static String initKey(String seed) throws Exception {
        SecureRandom secureRandom = null;

        if (seed != null) {
            secureRandom = new SecureRandom(decryptBASE64(seed));
        } else {
            secureRandom = new SecureRandom();
        }

        KeyGenerator kg = KeyGenerator.getInstance(ALGORITHM);
        kg.init(secureRandom);

        SecretKey secretKey = kg.generateKey();

        return encryptBASE64(secretKey.getEncoded());
    }



    /**
     * @param data 要加密的明文
     * @param key  采用Base64编码的DES加密字符串
     * @return 采用Base64编码的密文
     * @throws Exception
     */
    public static String encrypt(String data,String key) throws Exception {
        return Base64Util.encodeToString(encrypt(data.getBytes(CHARSET),key));
    }


    /**
     * @param data 采用Base64编码的密文
     * @param key 采用Base64编码的DES加密字符串
     * @return 明文
     * @throws Exception
     */
    public static String decrypt(String data,String key)throws Exception{
        return new String(decrypt(Base64Util.decode(data),key), Charset.forName(CHARSET));
    }
}
