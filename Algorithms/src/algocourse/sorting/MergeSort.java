package algocourse.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MergeSort {

    private static final int[] arr = {5, 4, 6, 12, 1, 7, 9, 18, 40, 6, 12, 59, 0, -3, 5, 6, 9, 1, 4, 6, 9};

    public static void main(String[] args) {
        int[] array = mergeSort(arr);
        System.out.println(Arrays.toString(array));
    }

    private static int[] mergeSort(int[] array) {

        if (array.length <= 1) {
            return array;
        }

        int middle = (array.length / 2) + (array.length % 2);

        int[] left = Arrays.copyOfRange(array,0, middle);
        int[] right = Arrays.copyOfRange(array, middle, array.length);

        int[] sortedLeft = mergeSort(left);
        int[] sortedRight = mergeSort(right);

        merge(array, sortedLeft, sortedRight, middle, array.length - middle);
        return array;
    }

    private static void merge(int[] array, int[] left, int[] right, int leftSize, int rightSize) {

        int i = 0, j = 0, size = 0;
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                array[size++] = left[i++];
            } else {
                array[size++] = right[j++];
            }
        }

        while (i < leftSize) {
            array[size++] = left[i++];
        }


        while (j < rightSize) {
            array[size++] = right[j++];
        }

    }

}
