package arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // First way to create and populate an array
        int[] ar = new int[5];

        for (int i = 1; i < ar.length; i++) {
            ar[i] = i;
        }

        // Second way: Array Initializer: instantiation and initialization
        int[] newAr = new int[]{5, 4, 3, 2, 1};

        // Third way: by using an anonymous array
        int[] newArray = {1, 2, 3, 4, 5};

        // java.util.Arrays: Helper class which provides  the common
        // functionality we'd want for many array operations. These are
        // static methods on Arrays. They are class methods, not instance methods.

        // The first method: Arrays.toString()
        // This method returns a String which starts with [ and ends with ],
        // with elements from array separated by a comma and space(, ).
        // If the array passed to it is null, the method return the string "null"
        // instead of throwing an exception.
        System.out.println(Arrays.toString(newArray));
        newArray = null;
        System.out.println(newArray);

        System.out.println();

        // The second method: Arrays.sort()
        // This method sorts arrays in ascending order. It is highly optimized, using Dual-Pivot Quicksort
        // for primitive types and TimSOrt dor object arrays.

        int[] randomArray = getRandomArray(10);
        System.out.println("Random Array:");
        System.out.println(Arrays.toString(randomArray));

        System.out.println("Sorted Array");
        Arrays.sort(randomArray);
        System.out.println(Arrays.toString(randomArray));

        // Arrays.sort variations:
        // 1# Subarray Sorting: We can sort only a specific range by providing
        // start (inclusive) and end (exclusive) indices.
        // Arrays.sort(array, fromIndex, toIndex);
        randomArray = getRandomArray(10);
        System.out.println("Random Array:");
        System.out.println(Arrays.toString(randomArray));

        System.out.println("Sorted Array from third element to seventh element");
        Arrays.sort(randomArray, 2, 7);
        System.out.println(Arrays.toString(randomArray));
        System.out.println();

        // Arrays.sort variations:
        // 2# Custom Object Sorting: For arrays of objects (like a Student class)
        // the objects must either implement the Comparable interface or you must
        // provide a Comparator as a second argument.
        Student[] students = new Student[5];
        students[0] = new Student("Bob", 44);
        students[1] = new Student("Débora", 40);
        students[2] = new Student("Clarice", 39);
        students[3] = new Student("Ana", 42);
        students[4] = new Student("Gustavo", 43);

        System.out.println("Array of Students");
        System.out.println(Arrays.toString(students));

        System.out.println("Array of Students Sorted by Name ascending:");
        Arrays.sort(students, Comparator.comparing(s -> s.getName().toUpperCase()));
        System.out.println(Arrays.toString(students));
        System.out.println();

        // The third method: Arrays.fill()
        // Quickly assigns a specific value to all elements or a specific range of elements in an array
        // Fill Entire Array: Arrays.fill(array, value);
        System.out.println("Array filled with all elements 50");

        newArray = new int[10];
        Arrays.fill(newArray, 50);

        System.out.println(Arrays.toString(newArray));
        System.out.println();

        // Fill Specific Range: Arrays.fill(array, fromIndex, toIndex, value);
        // Assigns the value to elements from fromIndex (inclusive) to toIndex (exclusive)
        System.out.println("Filling the array with value 10 from second to fourth elements");
        Arrays.fill(newArray, 1, 4, 10);
        System.out.println(Arrays.toString(newArray));
        System.out.println();

        // The fourth method: Arrays.copyOf()
        // It is a static method in Java used to create a new array by copying an existing one.
        // It is the standard way to duplicate an array or resize it while preserving existing data.
        // public static int[] copyOf(int[] original, int newLength)
        // Behavior 1 -> Equal Length: If newLength matches the original, it creates an exact duplicate.
        newArray = getRandomArray(10);
        int[] copiedArray = Arrays.copyOf(newArray, newArray.length);
        Arrays.sort(copiedArray);

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(newArray));
        System.out.println("Array created using copyOf from Original Array and sorted. It doesn't affect the Original:");
        System.out.println(Arrays.toString(copiedArray));
        System.out.println();

        // Behavior 2 -> Truncating: If newLength is smaller than the original,
        // the copy is truncated to the first newLength elements.
        copiedArray = Arrays.copyOf(newArray, 5);
        System.out.println();
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(newArray));
        System.out.println("Array created using copyOf from Original Array and sorted. Length = 5:");
        System.out.println(Arrays.toString(copiedArray));
        System.out.println();

        // Behavior 3 -> Padding: If newLength is larger, the new array
        // is padded with default values for the remaining slots (e.g., 0 for int, false for boolean, null for objects).
        copiedArray = Arrays.copyOf(newArray, 15);
        System.out.println();
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(newArray));
        System.out.println("Array created using copyOf from Original Array and sorted. Length = 15:");
        System.out.println(Arrays.toString(copiedArray));
        System.out.println();

        // The fifth method: Arrays.binarySearch()
        // It is a built-in static method in the java.util.Arrays class used to quickly find the
        // index of a specific element in a sorted array.
        // It is significantly faster than a linear search for large datasets, operating
        // with (O(log n)) time complexity.
        // It returns the index of the element found in the array. Otherwise, a negative number.
        // Important: The array must be sorted in ascending order.
        // binarySearch(type[] a, type key)

        String[] sArray = {"Able", "Jane", "Mark", "Ralph", "David"};
        Arrays.sort(sArray);
        System.out.println("Array of Strings");
        System.out.println(Arrays.toString(sArray));
        int result = Arrays.binarySearch(sArray, "Mark");
        if (result >= 0) {
            System.out.println("Found Mark in the list at index " + result);
        } else {
            System.out.println("Mark wasn't found! Result is " + result);
        }
        System.out.println();

        // binarySearch(type[] a, int fromIndex, int toIndex, type key)
        // Searches only from fromIndex (inclusive) to toIndex (exclusive).
        System.out.println("Searching Mark from the first element to the third");
        result = Arrays.binarySearch(sArray, 0, 3, "Mark");
        if (result >= 0) {
            System.out.println("Found Mark in the list at index " + result);
        } else {
            System.out.println("Mark wasn't found in the index range (0 to 3 exclusive). Result is "+ result);
        }
        System.out.println();

        // binarySearch(T[] a, T key, Comparator<? super T> c):
        // Searches an object array using a custom Comparator.
        System.out.println("Students:");
        System.out.println(Arrays.toString(students));
        System.out.println("Searching Clarice in the array");
        result = Arrays.binarySearch(
                students,
                new Student("Clarice", 39),
                Comparator.comparing(s -> s.getName().toUpperCase())
        );
        if (result >= 0) {
            System.out.println("Found Student whose name is Clarice in the list at index " + result);
        } else {
            System.out.println("Student whose name is Clarice wasn't found in the array. Result is "+ result);
        }
        System.out.println();

        // binarySearch(T[] a, T key, Comparator<? super T> c):
        // Searches an object array using a custom Comparator.
        System.out.println("Students:");
        System.out.println(Arrays.toString(students));
        System.out.println("Searching Clarice in the array from the first element to the second element");
        result = Arrays.binarySearch(
                students,
                0,
                2,
                new Student("Clarice", 39),
                Comparator.comparing(s -> s.getName().toUpperCase())
        );
        if (result >= 0) {
            System.out.println("Found Student whose name is Clarice in the list at index " + result);
        } else {
            System.out.println("Student whose name is Clarice wasn't found in the index range (0 to 2 exclusive). Result is "+ result);
        }
        System.out.println();

        // The sixth method: Arrays.equals()
        // It is used to determine if two arrays are equal by content.
        // Important: Two arrays are equal if they contain the same number of elements and
        // all elements in the same position in both arrays are equal.
        int[] s1 = {1, 2, 3, 4, 5};
        int[] s2 = {1, 2, 3, 4, 5};

        if (Arrays.equals(s1, s2)) {
            System.out.println("Arrays are equal");
        } else {
            System.out.println("Arrays are not equal");
        }

    }

    private static int[] getRandomArray(int length) {
        int[] array = new int[length];
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(100);
        }

        return array;
    }
}
