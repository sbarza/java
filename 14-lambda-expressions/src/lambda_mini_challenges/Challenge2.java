package lambda_mini_challenges;

import java.util.function.UnaryOperator;

public class Challenge2 {

    public static void main(String[] args) {

        UnaryOperator<String> everySecondCharLambda = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }

            return returnVal.toString();
        };

        System.out.println(everySecondCharLambda.apply("1234567890"));

    }

    // Write the following method as lambda expression.
    public static String everySecondChar(String source) {

        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i % 2 == 1) {
                returnVal.append(source.charAt(i));
            }
        }

        return returnVal.toString();
    }

    public static String everySecondCharacter(UnaryOperator<String> function, String value) {
        return function.apply(value);
    }
}
