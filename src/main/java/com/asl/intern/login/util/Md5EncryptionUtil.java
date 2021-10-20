package com.asl.intern.login.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5EncryptionUtil {
  public static String Encrypt(String dataStr) {
        final String salt="flkghdfkjl@djhfkdfhnljk345645";
        StringBuffer sb=new StringBuffer();
        dataStr = salt + dataStr;
        try {
            MessageDigest md = MessageDigest.getInstance("Md5");
            md.update(dataStr.getBytes(StandardCharsets.UTF_8));
            byte s[] = md.digest();
            for(byte a:s){
                sb.append(Integer.toHexString(0xff&a));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
