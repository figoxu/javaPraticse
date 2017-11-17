package me.figoxu.aes;

import me.figoxu.rsa.NumHelp;

/**
 * Created by xujianhui on 2017/11/17.
 */
public class Main {
    public static void main(String args[]) {
        System.out.println("AES加解密测试：");

        byte[] password = randomPassword();
        String content = "问世间，是否比此删更高";
        // 加密（传输)
        System.out.println("加密前：" + content);
        byte[] encryptResult = AESHelper.encrypt(content, password);


        System.out.println("Encry Info Is : ===>");
        NumHelp.printBytes(encryptResult);
        // 以HEX进行传输
        String codedtextb = Base64.encode(encryptResult);// data transfer as text
        System.out.println("Base64 format:" + codedtextb);
        encryptResult = Base64.decode(codedtextb);

        // 解密
        String decryptResultb = AESHelper.decrypt(encryptResult, password);
        System.out.println("解密后：" + decryptResultb);
    }


    public static byte[] randomPassword(){
        byte[] pwd = new byte[16];
        for(int i=0;i<pwd.length;i++){
            Double v = Math.random()*256;
            pwd[i]=v.byteValue();
        }
        System.out.println("PWD Is As Follow ===>");
        NumHelp.printBytes(pwd);
        return pwd;
    }
}
