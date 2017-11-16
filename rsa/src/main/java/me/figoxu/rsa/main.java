package me.figoxu.rsa;

import javax.crypto.Cipher;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * Created by xujianhui on 2017/11/16.
 */
public class main {

    public static final String pk = "-----BEGIN PUBLIC KEY-----\n" +
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
        PublicKey publicKey =  getPublicKeyFromPublicPemString(pk);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] enBytes = cipher.doFinal(plainTextBytes);
        String encryptString = Base64.getEncoder().encodeToString(enBytes);
        return encryptString;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(encByGoPubKey("helloworld"));
    }

    public static PublicKey getPublicKeyFromPublicPemString(String strPublicPem) {
        if (strPublicPem == null) {
            strPublicPem = "";
        }
        try {
            byte[] b = readPemFromString(strPublicPem);
            KeyFactory kf = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(b);
            return kf.generatePublic(keySpec);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static byte[] readPemFromString(String strPem) throws IOException {
        BufferedReader br = null;
        br = new BufferedReader(new StringReader(strPem));
        String s = br.readLine();
        String str = "";
        s = br.readLine();
        while (s.charAt(0) != '-') {
            str += s + "\r";
            s = br.readLine();
        }
//        byte[] b = Base64Help.getDecoder().decode(str);
        byte[] b =  Base64Help.decodeBase64(str.getBytes("UTF-8"));

        return b;
    }
}
