package me.figoxu.aes;


import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;



/**
 * AES算法加密，传输，解密过程示例(AES可以使用128、192、和256位密钥，并且用128位分组加密和解密数据)
 * JRE默认只能用16个字节(128)位密钥，
 * 使用密钥长度无限制模式：http://czj4451.iteye.com/blog/1986483
 * http://www.oracle.com/technetwork/java/javase/downloads/jce-7-download-432124.html
 * http://www.oracle.com/technetwork/java/javase/downloads/jce-6-download-429243.html
 */
public class AESHelper {

    private static Cipher cipher = null; // 私鈅加密对象Cipher



    static {
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }


    public static byte[] encrypt(String message, byte[] passWord) {
        try {
			/* AES算法 */
            SecretKey secretKey = new SecretKeySpec(passWord, "AES");// 获得密钥
			/* 获得一个私鈅加密类Cipher，DESede-》AES算法，ECB是加密模式，PKCS5Padding是填充方式 */
            cipher.init(Cipher.ENCRYPT_MODE, secretKey); // 设置工作模式为加密模式，给出密钥
            byte[] resultBytes = cipher.doFinal(message.getBytes("UTF-8")); // 正式执行加密操作
            return resultBytes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decrypt(byte[] messageBytes, byte[] passWord) {
        String result = "";
        try {
			/* AES算法 */
            SecretKey secretKey = new SecretKeySpec(passWord, "AES");// 获得密钥
            cipher.init(Cipher.DECRYPT_MODE, secretKey); // 设置工作模式为解密模式，给出密钥
            byte[] resultBytes = cipher.doFinal(messageBytes);// 正式执行解密操作
            result = new String(resultBytes, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}