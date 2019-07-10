package hashmaps;

import java.util.*;

public class SherlockAndAnagrams {

    static int sherlockAndAnagrams(String s) {

        char[] c = s.toCharArray();
        Set<Integer> weights = new HashSet<>();

        int count = 0 ;
        for (int i = 0; i < c.length; i++) {

            int weight = 0;
            for (int j = i; j < c.length; j++) {

                weight += c[j];

                if (weights.contains(weight)) {
                    count++;
                } else {
                    weights.add(weight);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("abba")); // 4
        System.out.println(sherlockAndAnagrams("ifailuhkqq")); // 3
        System.out.println(sherlockAndAnagrams("kkkk")); // 10
        System.out.println(sherlockAndAnagrams("cdcd")); // 5
    }
}
