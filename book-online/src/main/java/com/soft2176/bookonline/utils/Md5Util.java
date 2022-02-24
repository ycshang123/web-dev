package com.soft2176.bookonline.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @program: java-web-dev
 * @description:
 * @author: ycshang
 * @create: 2022-02-24 17:37
 **/
public class Md5Util {
    public static String crypt(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("不能为空串或长度为0的字符串加密");
        }
        StringBuilder hexString = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] hash = md.digest();
            for (byte b : hash) {
                if ((0xff & b) < 0x10) {
                    hexString.append("0").append(Integer.toHexString((0xFF & b)));
                } else {
                    hexString.append(Integer.toHexString(0xFF & b));
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hexString.toString();
    }
}