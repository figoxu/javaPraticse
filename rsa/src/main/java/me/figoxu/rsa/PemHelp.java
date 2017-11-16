package me.figoxu.rsa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by xujianhui on 2017/11/16.
 */
public class PemHelp {

    public static PublicKey publicKey(String publicKeyStr) {
        if (publicKeyStr == null) {
            publicKeyStr = "";
        }
        try {
            byte[] b = pemFromStr(publicKeyStr);
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


    public static byte[] pemFromStr(String strPem) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(strPem));
        String s = br.readLine();//skip first line
        String str = "";
        s = br.readLine();
        while (s.charAt(0) != '-') {
            str += s + "\r";
            s = br.readLine();
        }
        byte[] b =  Base64Help.decodeBase64(str.getBytes("UTF-8"));
        return b;
    }
}
