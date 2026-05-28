package arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class ArrayChallenge {

    public static void main(String[] args) {

        // Solution 1: Using Array of integers (primitives)
        System.out.println("Solution 1:");
        int[] integers = createRandomArray(19);

        System.out.println("Array Generated Randomly:");
        System.out.println(Arrays.toString(integers));

        int[] integersCopied = Arrays.copyOf(integers, integers.length);
        Arrays.sort(integersCopied);

        sortArrayInDescendingOrder(integersCopied);

        System.out.println("Array Sorted in Descending Order");
        System.out.println(Arrays.toString(integersCopied));
        System.out.println();

        // Solution 2: Using Array of Integers (Wrapper class of primitive int)
        System.out.println("Solution 2");
        Integer[] integers2 = createRandomArray2(19);

        System.out.println("Array Generated Randomly:");
        System.out.println(Arrays.toString(integers2));

        Integer[] integers2Copied = Arrays.copyOf(integers2, integers2.length);
        Arrays.sort(integers2Copied, Comparator.reverseOrder());

        System.out.println("Array Sorted in Descending Order");
        System.out.println(Arrays.toString(integers2Copied));
        System.out.println();

    }

    private static Integer[] createRandomArray2(int length) {
        Integer[] integers = new Integer[length];
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            integers[i] = random.nextInt(100);
        }

        return integers;
    }

    private static void sortArrayInDescendingOrder(int[] array) {
        int length = array.length;
        int middleIndex = length / 2;
        int relativeFirstElement;
        int relativeLastIndex;

        for (int index = 0; index < middleIndex; index++) {
            relativeLastIndex = length - 1 - index;
            relativeFirstElement = array[index];
            array[index] = array[relativeLastIndex];
            array[relativeLastIndex] = relativeFirstElement;
        }
    }

    private static int[] createRandomArray(int length) {
        int[] integers = new int[length];
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            integers[i] = random.nextInt(100);
        }

        return integers;
    }
}
