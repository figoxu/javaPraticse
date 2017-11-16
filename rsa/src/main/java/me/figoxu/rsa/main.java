package me.figoxu.rsa;

import javax.crypto.Cipher;
import java.security.PrivateKey;
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

    public static void main(String[] args) throws Exception {
        String v_base64 = encodeByPubK("helloworld");
        System.out.println(v_base64);
        byte[] decode = Base64.getDecoder().decode(v_base64);
        decodeByPriK(decode);

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

    public static final String private_key = "-----BEGIN PRIVATE KEY-----\n" +
            "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBANM1DJuTWwK3jIVv\n" +
            "6XwdBf2cF3dCQJRN6fH7POzJDJy4m8aZfXf9v/Tctrw6/FWb1rVZlOT+WeEDR6tV\n" +
            "50vMLUunuEh+d9mEdGgRnOP1p+kxrwHjuTnkuHmzgaBHDHTPDQgQoXPHA3w7cglO\n" +
            "l555mAAGhZx8mFVKK6PPFsSnDYRpAgMBAAECgYEAr3/gRxItyNcuK97vW5NeW/st\n" +
            "QIrL0K/hWpKScIsrMLrxrhfyuxceP2B7c3NsI9LHmY+jepijpKauEf/inwg9BaL5\n" +
            "oEn/LUbBC5H+JXOULEm3yslXJSXdGOLhQhuxhf/QzC743ExDjdu+/1hP/zOJ+l3e\n" +
            "ER0YKD0K4Q3jlM8kX7UCQQDur7e7L+ciScGZMk2RlXjfxcC1YfmM0r55gTWOeSCe\n" +
            "2lfuxBTbWhTNDRZuv9oSmsS70q4AcfWuhokB7ojABNHvAkEA4ocOvabcz6QWrDGr\n" +
            "v6czfqsoRSBuYm0nKlP1J639S1BnG9QYMuL537/KImqK8dcrHKCmT3dNtxfgyu0J\n" +
            "SKwHJwJAUh3MFS9G0qoTW/RNcX++JSZwxTZe148NjtngJhMQIPa3d+Kn1ktoip8t\n" +
            "D48bpHjwpDm4OVj7kD6i1jJNg9pkqwJAVwxPPdHBSIllrQXpWdyGjUZ4UxgDUw9e\n" +
            "3YUlz/msPCTJeogmRGe0Xab1pgQLIKPujTGutxrBYnpqh5BO4P46QQJBAMLGpasK\n" +
            "o28QRpMZyV+oDMrUFrSYRup+mDUF7qgMVGF7ToFm4K9PiwZHXhanKCKh7hleQo80\n" +
            "h/T3oy87xO/iKQE=\n" +
            "-----END PRIVATE KEY-----\n";


}
