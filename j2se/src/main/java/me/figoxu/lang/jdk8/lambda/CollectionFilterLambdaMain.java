package me.figoxu.lang.jdk8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: figo
 * Date: 16-9-7
 * Time: 下午6:06
 * To change this template use File | Settings | File Templates.
 */
public class CollectionFilterLambdaMain {
    public static void main(String[] args) {
        parseFilterOld2NewCollection();
        parseStringList2String();
        parseListAsDistinct();
    }

    private static void parseListAsDistinct() {
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map( i -> i*i).distinct()
                .collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);
    }

    private static void parseStringList2String() {
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany",  "Italy", "U.K.", "Canada");
        String G7Countries = G7.stream().map(x -> x.toUpperCase())
                .collect(Collectors.joining(", "));
        System.out.println(G7Countries);
    }

    private static void parseFilterOld2NewCollection() {
        List<String> strList = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        List<String> filtered = strList.stream().filter(x -> x.length()> 2)
                .collect(Collectors.toList());
        System.out.printf("Original List : %s, filtered list : %s %n",
                strList, filtered);
    }
}
