package functional_interfaces.function_and_supplier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of(
                "alpha", "bravo", "charlie", "delta"));

        list.removeIf(s -> s.equalsIgnoreCase("bravo"));
        list.forEach(s -> System.out.println(s));

        list.addAll(List.of("echo", "easy", "earnest"));
        list.forEach(s -> System.out.println(s));

        System.out.println("-".repeat(20));
        list.removeIf(s -> s.startsWith("ea"));
        list.forEach(s -> System.out.println(s));

        list.replaceAll(s -> s.charAt(0) + " - " + s.toUpperCase());
        System.out.println("-".repeat(20));
        list.forEach(s -> System.out.println(s));

        System.out.println("-".repeat(20));
        String[] emptyStrings = new String[10];
        System.out.println(Arrays.toString(emptyStrings));

        Arrays.fill(emptyStrings, "");
        System.out.println(Arrays.toString(emptyStrings));

        Arrays.setAll(emptyStrings, (i)-> "" + (i + 1) + ". ");
        System.out.println(Arrays.toString(emptyStrings));

        Arrays.setAll(emptyStrings, (i)-> "" + (i + 1) + ". "
            + switch (i) {
                    case 0 -> "one";
                    case 1 -> "two";
                    case 2 -> "three";
                    default -> "";
                }
        );
        System.out.println(Arrays.toString(emptyStrings));
    }

}
