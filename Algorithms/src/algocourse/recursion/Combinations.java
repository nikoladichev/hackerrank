package algocourse.recursion;

import java.util.Arrays;

public class Combinations {

    public static void main(String[] args) {
        int[] set = new int[] {1, 2, 3, 4};
        int[] vector = new int[] {0 , 0};
        genCombinations(set, vector, 0, 0);
    }

    static void genCombinations(int[] set, int[] vector, int index, int border) {

        if (index >= vector.length) {
            System.out.println(Arrays.toString(vector));
        } else {
            for (int i = border; i < set.length; i++) {
                vector[index] = set[i];
                genCombinations(set, vector, index + 1, i + 1);
            }
        }
    }
}
