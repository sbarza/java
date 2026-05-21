package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumElementChallenge {

    public static void main(String[] args) {

        int[] values = readIntegers();
        System.out.println("Integers entered:");
        System.out.println(Arrays.toString(values));

        System.out.println();

        int minimumValue = findMin(values);
        System.out.println("The minimum element entered: " + minimumValue);


    }

    public static int findMin(int[] integers) {

        if (integers == null || integers.length == 0) {
            throw new IllegalArgumentException("Enter a valid argument");
        }

        // Solution 1: Find manually the value by looping over the array and update the minimum
        int min = Integer.MAX_VALUE;
        for (int value : integers) {
            if (value < min) {
                min = value;
            }
        }

        return min;

//        // Solution 2: Using Arrays.sort() and pick the first element from array sorted ascending
//        int[] copyIntegers = Arrays.copyOf(integers, integers.length);
//        Arrays.sort(copyIntegers);
//
//        return copyIntegers[0];

    }

    public static int[] readIntegers() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a list of integers, separated by comma:");
        String[] sInput = scanner.nextLine().split(",");
        int[] integers = new int[sInput.length];

        for (int index = 0; index < sInput.length; index++) {
            integers[index] = Integer.parseInt(sInput[index].trim());
        }

        return integers;
    }
}
