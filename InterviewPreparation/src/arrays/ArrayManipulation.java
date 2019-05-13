package arrays;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ArrayManipulation {

    public static void main(String[] args) throws IOException {

        File f = new File (Objects.requireNonNull(ArrayManipulation.class.getClassLoader().getResource("ArrayManipulation_2490686975.txt")).getFile());
        Scanner scanner = new Scanner(f);

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        System.out.println("Result " + result + ", isTrue = " + (2490686975L == result));

        scanner.close();
    }

    static long arrayManipulation(int n, int[][] queries) {

        System.out.println("SHANO!");
        long[] array = new long[n];

        int[] aArr = new int[queries.length];
        int[] bArr = new int[queries.length];
        int[] kArr = new int[queries.length];

        int i = 0;
        for (int[] query : queries) {

            int a = query[0] - 1;
            int b = query[1] - 1;
            int k = query[2];

//            for (int j = a; j <= b; j++) {
//                array[j] += k;
//            }
        }

//        System.out.println(Arrays.toString(array));

        System.out.println("SHANO2");
        return Arrays.stream(array).max().getAsLong();
    }
}
