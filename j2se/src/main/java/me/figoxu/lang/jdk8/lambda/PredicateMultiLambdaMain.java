package me.figoxu.lang.jdk8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Predicate Support  and / or / negate
 */
public class PredicateMultiLambdaMain {
    public static void main(String[] args) {
        List languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        Predicate<String> startsWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourLetterLong = (n) -> n.length() == 4;
        languages.stream()
                .filter(startsWithJ.and(fourLetterLong))
                .forEach((n) -> System.out.print("\nName, which starts with'J' and four letter long is : " + n));
    }
}
