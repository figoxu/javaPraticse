package me.figoxu.aes;

import me.figoxu.rsa.NumHelp;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES {

    public static byte[] encrypt(byte[] origData,byte[] keyBytes) throws GeneralSecurityException {
        byte[] buf = new byte[16];
        System.arraycopy(keyBytes, 0, buf, 0, keyBytes.length > buf.length ? keyBytes.length : buf.length);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(buf, "AES"), new IvParameterSpec(keyBytes));
        return cipher.doFinal(origData);

    }

    public static byte[] decrypt(byte[] crypted,byte[] keyBytes) throws GeneralSecurityException {
        byte[] buf = new byte[16];
        System.arraycopy(keyBytes, 0, buf, 0, keyBytes.length > buf.length ? keyBytes.length : buf.length);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(buf, "AES"), new IvParameterSpec(keyBytes));
        return cipher.doFinal(crypted);
    }

    public static void main(String[] args) throws GeneralSecurityException, UnsupportedEncodingException {

        System.out.println("AES加解密测试：");

        byte[] password = randomPassword();
        String content = "问世间，是否比此删更高";
        // 加密（传输)
        System.out.println("加密前：" + content);
        byte[] encryptResult = encrypt(content.getBytes("UTF-8"), password);


        System.out.println("Encry Info Is : ===>");
        NumHelp.printUint8(encryptResult);
        // 以HEX进行传输
        String codedtextb = Base64.encode(encryptResult);// data transfer as text
        System.out.println("Base64 format:" + codedtextb);
        encryptResult = Base64.decode(codedtextb);

        // 解密
        byte[] decrypt = decrypt(encryptResult, password);
        System.out.println("=====解密后=====");
        NumHelp.printUint8(decrypt);
        System.out.println("解密后：" + new String(decrypt,"UTF-8"));

    }

    public static byte[] randomPassword(){
        byte[] pwd = new byte[16];
        for(int i=0;i<pwd.length;i++){
            Double v = Math.random()*256;
            pwd[i]=v.byteValue();
            System.out.println();
        }
        System.out.println("PWD In Java Is ==>");
        NumHelp.printBytes(pwd);
        System.out.println("PWD Is As Follow ===>");
        NumHelp.printUint8(pwd);
//        byte[] pwd = new byte[]{-48,-126,-97,99,-25,-21,-73,11,-113,-86,60,9,-73,15,29,-85};
        return pwd;
    }
}