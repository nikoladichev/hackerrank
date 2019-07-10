package arrays;

import java.util.Arrays;

/**
 * <a href="https://www.hackerrank.com/challenges/arrays-ds/problem">ReverseArray at HackerRank</a>
 */
public class ReverseArray {


    public static void main(String[] args) {
        int[] case1 = {1, 4, 3, 2};
        int[] reverseCase1 = reverseArray(case1);

        Arrays.stream(reverseCase1).forEach(e -> System.out.print(e + " "));
    }

    private static int[] reverseArray(int[] a) {

        int[] reverse = new int[a.length];
        for (int i = a.length; i > 0; i--) {
            reverse[a.length - i] = a[i - 1];
        }

        return reverse;
    }
}
