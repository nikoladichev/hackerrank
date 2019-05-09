package arrays;

import java.util.*;

/**
 * @link https://www.hackerrank.com/challenges/minimum-swaps-2/
 */
public class MinimumSwaps2 {
    public static void main(String[] args) {

        int[] test1 = new int[]{4, 3, 1, 2};
        int[] test2 = new int[]{2, 3, 4, 1, 5};
        int[] test3 = new int[]{1, 3, 5, 2, 4, 6, 7};

        minimumSwaps(test1); // 3
        minimumSwaps(test2); // 3
        minimumSwaps(test3); // 3
    }

    static int minimumSwaps(int[] originalArray) {

        int swaps = 0;

        int[] sortedArray = Arrays.copyOf(originalArray, originalArray.length);
        Arrays.sort(sortedArray);

        System.out.println(Arrays.toString(originalArray));

        for (int i = 0; i < originalArray.length; i++) {
            if (sortedArray[i] != originalArray[i]) {
                int nextVal = sortedArray[i];
                int index = getIndex(originalArray, nextVal, i + 1);

                int temp = originalArray[i];
                originalArray[i] = nextVal;
                originalArray[index] = temp;

                swaps++;
            }
        }

        System.out.println(Arrays.toString(originalArray) + ", swaps: " + swaps);

        return swaps;
    }

    private static int getIndex(int[] array, int value, int startIndex) {

        for (int i = startIndex; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }

        return -1;
    }

}
