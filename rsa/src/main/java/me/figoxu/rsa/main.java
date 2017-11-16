package me.figoxu.rsa;

import javax.crypto.Cipher;
import java.security.PublicKey;
import java.util.Base64;

/**
 * Created by xujianhui on 2017/11/16.
 */
public class main {

    public static final String publicKey = "-----BEGIN PUBLIC KEY-----\n" +
            "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDTNQybk1sCt4yFb+l8HQX9nBd3\n" +
            "QkCUTenx+zzsyQycuJvGmX13/b/03La8OvxVm9a1WZTk/lnhA0erVedLzC1Lp7hI\n" +
            "fnfZhHRoEZzj9afpMa8B47k55Lh5s4GgRwx0zw0IEKFzxwN8O3IJTpeeeZgABoWc\n" +
            "fJhVSiujzxbEpw2EaQIDAQAB\n" +
            "-----END PUBLIC KEY-----";
    /**
     *利用Go语言产生的公钥加密
     * @param plainText 需要加密的字符串
     */
    public static String encByGoPubKey(String plainText) throws Exception {
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

    public static void main(String[] args) throws Exception {
        System.out.println(encByGoPubKey("helloworld"));
    }

}
