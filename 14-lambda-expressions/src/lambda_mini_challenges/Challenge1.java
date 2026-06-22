package lambda_mini_challenges;

import java.util.Arrays;
import java.util.function.Consumer;

public class Challenge1 {

    public static void main(String[] args) {

        // Write the following anonymous class as lambda expression:

        Consumer<String> printWords = new Consumer<String>() {

            @Override
            public void accept(String sentence) {
                String[] parts = sentence.split(" ");
                for (String part : parts) {
                    System.out.println(part);
                }
            }
        };

        Consumer<String> printWordsLambda = s -> {
            String[] parts = s.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };

        Consumer<String> printWordsForEach = sentence ->
                Arrays.asList(sentence.split(" ")).forEach(part -> System.out.println(part));

        printWords.accept("Let's split this up into an array");
        printWordsLambda.accept("Let's split this up into an array");
    }
}
