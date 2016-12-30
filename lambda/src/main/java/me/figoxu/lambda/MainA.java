package me.figoxu.lambda;

import java.util.function.Supplier;

/**
 * Created by figo on 2016/12/30.
 */
public class MainA {

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> System.out.println("In Java8, Lambda expression rocks !!")).start();
        System.out.println("Hello");

        Supplier<Integer> supplier = () -> 1;
        System.out.println(supplier.get());
        Thread.sleep(1000);
    }


}
