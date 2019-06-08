package algocourse.dynamicprogramming;

import java.util.Arrays;

public class Fibonacci {

    private static int[] array = new int[1001];

    public static void main(String[] args) {
        fibonacci(1000) ;
        System.out.println(Arrays.toString(array));

        fibonacciIterative(1000);
    }

    private static int fibonacci(int n) {

        if (array[n] != 0) {
            return array[n];
        }

        if (n == 1 || n == 2) {
            array[n] = 1;
            return 1;
        }

        array[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return array[n];
    }

    private static void fibonacciIterative(int n) {

        if (n == 0) {
            System.out.println("[0]");
            return;
        } else if (n == 1) {
            System.out.println("[0, 1]");
            return;
        }

        int[] array = new int[n + 1];

        array[0] = 0;
        array[1] = 1;

        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }

        System.out.println(Arrays.toString(array));
    }
}
