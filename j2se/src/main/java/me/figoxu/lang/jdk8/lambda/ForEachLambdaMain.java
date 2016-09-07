package me.figoxu.lang.jdk8.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: figo
 * Date: 16-9-7
 * Time: 下午3:17
 * To change this template use File | Settings | File Templates.
 */
public class ForEachLambdaMain {
    public static void main(String[] args) {
        Arrays.asList("Lambdas", "Default Method", "Stream API","Date and Time API").forEach(n -> System.out.println(n));
    }
}
