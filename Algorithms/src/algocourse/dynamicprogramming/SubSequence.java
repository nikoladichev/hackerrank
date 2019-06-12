package algocourse.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubSequence {

    public static void main(String[] args) {
        int[] sequence = {3, 14, 5, 12, 15, 7, 8, 9, 11, 10, 1};
        longestSubSequence(sequence);
    }

    private static void longestSubSequence(int[] sequence) {

        int[] cache = new int[sequence.length];
        int[] indexes = new int[sequence.length];

        cache[0] = 1;
        indexes[0] = -1;

        int maxWeight = 1;
        int maxIndex = 0;

        for (int i = 1; i < sequence.length; i++) {
            int curSelected = sequence[i];
            int weight = 1, prevIndex = -1;

            for (int j = i - 1; j >= 0; j--) {
                if (sequence[j] < curSelected) {
                    if (prevIndex == -1) {
                        prevIndex = j;
                    }
                    weight++;
                }
            }
            cache[i] = weight;
            indexes[i] = prevIndex;
            if (weight > maxWeight) {
                maxWeight = weight;
                maxIndex = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        while (maxIndex != -1) {
            result.add(sequence[maxIndex]);
            maxIndex = indexes[maxIndex];
        }

        System.out.println(Arrays.toString(sequence));
        System.out.println(Arrays.toString(cache));
        System.out.println(Arrays.toString(indexes));
        System.out.println("Biggest sub sequence size is: " + maxWeight);

        Collections.reverse(result);
        System.out.println("Result: " + Arrays.toString(result.toArray()));

    }
}
