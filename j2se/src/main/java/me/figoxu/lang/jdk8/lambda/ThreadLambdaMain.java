package me.figoxu.lang.jdk8.lambda;

/**
 * Created with IntelliJ IDEA.
 * User: figo
 * Date: 16-9-7
 * Time: 下午3:06
 * To change this template use File | Settings | File Templates.
 */
public class ThreadLambdaMain {
    public static void main(String[] args) {
        new Thread(
                ()->System.out.println("This is lambda thread")
        ).start();

        new Thread(
                ()->{
                    System.out.println("Hello");
                    System.out.println("This is lambda thread");
                    System.out.println("World");
                }
        ).start();
    }
}
