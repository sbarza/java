package arrays;

import java.util.Arrays;

public class MultiDimensionalArrays {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.deepToString(matrix));

        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        for (int[] array : matrix) {
            System.out.println(Arrays.toString(array));
        }

        System.out.println();

        int[][] multiArray = new int[3][];
        multiArray[0] = new int[]{1, 2, 3};
        multiArray[1] = new int[]{10, 19};
        multiArray[2] = new int[]{23, 25, 27, 39};

        for (int[] array : multiArray) {
            System.out.println(Arrays.toString(array));
        }
    }
}
