package me.figoxu.lang.jdk8.lambda;

/**
 * Created with IntelliJ IDEA.
 * User: figo
 * Date: 16-9-7
 * Time: 下午3:05
 * To change this template use File | Settings | File Templates.
 */
public class ThreadMain {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("This is a common thread");
            }
        }).start();
    }
}
