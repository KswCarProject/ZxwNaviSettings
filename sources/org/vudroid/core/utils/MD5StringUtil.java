package org.vudroid.core.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.UByte;

public class MD5StringUtil {
    private static final MessageDigest digest;

    static {
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String md5StringFor(String str) {
        byte[] digest2 = digest.digest(str.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : digest2) {
            sb.append(Integer.toString(b & UByte.MAX_VALUE, 16));
        }
        return sb.toString();
    }
}
