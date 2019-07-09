package algocourse.combinations;

import java.util.Arrays;

public class Permutation {

    static int[] arr = new int[] { 1, 2, 5 };

    // v1
    static boolean[] isVisited = new boolean[arr.length];
    static int[] permutations = new int[arr.length];

    // v2 - swapping

    public static void main(String[] args) {
        permutationV2(0);
    }

    static void permutation(int index) {

        if (index >= arr.length) {
            System.out.println(Arrays.toString(permutations));
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (!isVisited[i]) {

                    isVisited[i] = true;
                    permutations[index] = arr[i];
                    permutation(index + 1);
                    isVisited[i] = false;

                }
            }
        }
    }

    static void permutationV2(int index) {

        if (index >= arr.length) {
            System.out.println(Arrays.toString(arr));
        } else {
            permutationV2(index + 1);
            for (int i = index + 1; i < arr.length; i++) {
                swap(index, i);
                permutationV2(index + 1);
                swap(index, i);

            }
        }

    }

    static void swap(int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
