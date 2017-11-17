package me.figoxu.rsa;

/**
 * Created by xujianhui on 2017/11/16.
 */
public class NumHelp {
    public int getUint8(short s){
        return s & 0x00ff;
    }


    public static void printBytes(byte[] bs){
        NumHelp numHelp = new NumHelp();
        for(int i=0;i<bs.length;i++){
            if(i==0){
                System.out.print("{"+numHelp.getUint8(bs[i]));
            }else if(i==bs.length-1){
                System.out.print(","+numHelp.getUint8(bs[i])+"}");
            }else{
                System.out.print(","+numHelp.getUint8(bs[i]));
            }
        }
        System.out.println();
    }
}
