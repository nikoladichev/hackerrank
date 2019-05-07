package arrays;

public class TwoDimensionalArray {
    public static void main(String[] args) {
        int[][] arr1 = new int[][]
                {
                        {1, 1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0},
                        {1, 1, 1, 0, 0, 0},
                        {0, 0, 2, 4, 4, 0},
                        {0, 0, 0, 2, 0, 0},
                        {0, 0, 1, 2, 4, 0}
                };
        System.out.println("Result: " + hourglassSum(arr1)); // 19
    }

    static int hourglassSum(int[][] arr) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {

            for (int j = 0; j < arr[i].length - 2; j++) {
                int a = arr[i][j];
                int b = arr[i][j + 1];
                int c = arr[i][j + 2];
                int d = arr[i + 1][j + 1];
                int e = arr[i + 2][j];
                int f = arr[i + 2][j + 1];
                int g = arr[i + 2][j + 2];

                System.out.println(a + " " + b + " " + c);
                System.out.println(" " + d + " ");
                System.out.println(e + " " + f + " " + g);

                int sum = a + b + c + d + e + f + g;
                 if (result < sum) {
                     result = sum;
                 }
            }
        }
        return result;
    }

}
