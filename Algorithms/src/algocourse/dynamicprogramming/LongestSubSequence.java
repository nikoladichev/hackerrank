package algocourse.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestSubSequence {

    public static void main(String[] args) {
        Character[] s1 = {'G', 'C', 'C', 'C', 'T', 'A', 'G', 'C', 'G'};
        Character[] s2 = {'G', 'C', 'G', 'C', 'A', 'A', 'T', 'G'};

        solve(s2, s1);
    }

    private static void solve(Character[] s1, Character[] s2) {

        int[][] matchMap = new int[s1.length + 1][s2.length + 1];

        List<Character> subset = new ArrayList<>();

        int[] count = new int[matchMap[0].length];
        int startColIndex = 1;
        for (int row = 1; row < matchMap.length; row++) {

            char rowCharacter = s1[row - 1];

            for (int col = startColIndex; col < matchMap[0].length; col++) {

                char colCharacter = s2[col - 1];

                if (rowCharacter == colCharacter) {

                    subset.add(rowCharacter);
                    startColIndex = col + 1;
                    Arrays.fill(count, col, count.length, ++count[col]);
                    break;
                }
            }

            matchMap[row] = Arrays.copyOf(count, count.length);
        }

        System.out.println("     " + Arrays.toString(s2));
        int countA = 0;
        for (int[] row: matchMap) {
            char c = countA == 0 ? ' ' : s1[countA - 1];
            System.out.println(c + " " + Arrays.toString(row));
            countA++;
        }

        System.out.println();
        System.out.println(Arrays.toString(subset.toArray()));
    }
}
