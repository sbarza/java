package functional_interfaces.consumer_and_predicate;

import java.util.Arrays;
import java.util.function.BiConsumer;

public class Main {

    public static void main(String[] args) {
        var coords = Arrays.asList(
                new double[]{47.2160, -95.2348},
                new double[]{29.1566, -89.2495},
                new double[]{35.1556, -90.0659}
        );

        coords.forEach(s -> System.out.println(Arrays.toString(s)));

        BiConsumer<Double, Double> p1 = (lat, lng) ->
                System.out.printf("[lat:%.3f lon:%.3f]%n", lat, lng);

        var firstPoint = coords.get(0);
        processPoint(firstPoint[0], firstPoint[1], p1);

        System.out.println("-".repeat(20));
        coords.forEach(s -> processPoint(s[0], s[1], p1));
        coords.forEach(s -> processPoint(s[0], s[1],
                (lat, lng) ->
                        System.out.printf("[lat:%.3f lon:%.3f]%n", lat, lng)));
    }

    public static <T> void processPoint(T t1, T t2, BiConsumer<T, T> consumer) {
        consumer.accept(t1, t2);
    }
}
