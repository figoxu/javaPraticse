package me.figoxu.rsa;

import javax.crypto.Cipher;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

/**
 * Created by xujianhui on 2017/11/16.
 */
public class RsaHelp {

    public static String encodeByPubK(String plainText) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        byte[] plainTextBytes = plainText.getBytes();
        PublicKey publicKey =  PemHelp.publicKey(main.publicKey);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] enBytes = cipher.doFinal(plainTextBytes);
        for(int i=0;i<enBytes.length;i++){
            int uint8 = new NumHelp().getUint8(enBytes[i]);
            System.out.print(","+uint8);
        }
        System.out.println("");
        String encryptString = Base64.getEncoder().encodeToString(enBytes);
        return encryptString;
    }

    public static String decodeByPriK(byte[] bs)throws Exception{

        Cipher cipher = Cipher.getInstance("RSA");
        PrivateKey privateKey = PemHelp.privateKey(main.private_key);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] enBytes = cipher.doFinal(bs);
        for(int i=0;i<enBytes.length;i++){
            int uint8 = new NumHelp().getUint8(enBytes[i]);
            System.out.print(","+uint8);
        }
        System.out.println();
        System.out.println(new String(enBytes,"UTF-8"));
        System.out.println("");
        String encryptString = Base64.getEncoder().encodeToString(enBytes);
        return encryptString;
    }


    public static String encodeByPriK(String plainText) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        byte[] plainTextBytes = plainText.getBytes();
        PrivateKey privateKey = PemHelp.privateKey(main.private_key);
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        byte[] enBytes = cipher.doFinal(plainTextBytes);
        for(int i=0;i<enBytes.length;i++){
            int uint8 = new NumHelp().getUint8(enBytes[i]);
            System.out.print(","+uint8);
        }
        System.out.println("");
        String encryptString = Base64.getEncoder().encodeToString(enBytes);
        return encryptString;
    }

    public static String decodeByPubK(byte[] bs)throws Exception{
        Cipher cipher = Cipher.getInstance("RSA");
        PublicKey publicKey =  PemHelp.publicKey(main.publicKey);
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] enBytes = cipher.doFinal(bs);
        for(int i=0;i<enBytes.length;i++){
            int uint8 = new NumHelp().getUint8(enBytes[i]);
            System.out.print(","+uint8);
        }
        System.out.println();
        System.out.println(new String(enBytes,"UTF-8"));
        System.out.println("");
        String encryptString = Base64.getEncoder().encodeToString(enBytes);
        return encryptString;
    }

}
