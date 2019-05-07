package arrays;

import java.util.*;

/**
 * @link https://www.hackerrank.com/challenges/minimum-swaps-2/
 */
public class MinimumSwaps2 {
    public static void main(String[] args) {
        int[] test1 = new int[]{2, 3, 4, 1, 5};
        int[] test2 = new int[]{1, 3, 5, 2, 4, 6, 7};

        minimumSwaps(test1); // 3
        minimumSwaps(test2); // 3
    }

    static int minimumSwaps(int[] arr) {

        int swaps = 0;

        Integer[] originalArray = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            originalArray[i] = arr[i];
        }

        Integer[] sortedArray = new Integer[originalArray.length];
        new TreeSet<>(Arrays.asList(originalArray)).toArray(sortedArray);

        for (int i = 0; i < originalArray.length; i++) {
            if (!sortedArray[i].equals(originalArray[i])) {
                int temp = originalArray[i];
                for (int j = i + 1; j < originalArray.length; j++) {
                    if (sortedArray[j].equals(temp)) {
                        originalArray[j] = temp;
//                        System.out.println("swap(" + i + ',' + j + ')');
                        originalArray[i] = sortedArray[i];

//                        System.out.println("Temp: " + Arrays.toString(originalArray));
                        swaps++;

                        break;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(originalArray) + ", swaps: " + swaps);

        return swaps;
    }

}
