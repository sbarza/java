package arrays;

import java.util.Scanner;
import java.util.Arrays;

public class Exercise1 {

    public static void main(String[] args) {

        int[] integers = getIntegers(5);
        printArray(integers);
        System.out.println();
        int[] sortedAIntegers = sortDescendingIntegers(integers);
        printArray(sortedAIntegers);
    }

    public static int[] getIntegers(int length) {

        Scanner scanner = new Scanner(System.in);
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            result[i] = scanner.nextInt();
        }

        return result;
    }

    public static void printArray(int[] arr) {
        for (int index = 0; index < arr.length; index++) {
            System.out.printf("Element %d contents %d%n", index, arr[index]);
        }
    }

    public static int[] sortDescendingIntegers(int[] arr) {

        int[] descSortedArray = Arrays.copyOf(arr, arr.length);
        int temp;
        boolean flag = true;

        while (flag) {
            flag = false;

            for (int i = 0; i < arr.length - 1; i++) {
                System.out.println("Round " + (i + 1));
                if (descSortedArray[i] < descSortedArray[i + 1]) {
                    temp = descSortedArray[i];
                    descSortedArray[i] = descSortedArray[i + 1];
                    descSortedArray[i + 1] = temp;
                    flag = true;
                    System.out.println("----->" + Arrays.toString(descSortedArray));
                }
            }
            System.out.println("-->" + Arrays.toString(descSortedArray));
        }

        return descSortedArray;
    }
}
