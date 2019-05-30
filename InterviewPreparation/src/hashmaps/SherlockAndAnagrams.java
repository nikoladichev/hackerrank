package hashmaps;

import java.util.*;

public class SherlockAndAnagrams {

    static class Pair {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return start == pair.start &&
                    end == pair.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }

    static int sherlockAndAnagrams(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        if (!s.equals(reverse)) return 0;

        Map<String, Pair> sMap = new HashMap<>();
        populateMap(s, sMap);

        Map<String, Pair> reverseMap = new HashMap<>();
        populateMap(reverse, reverseMap);

        Set<String> resultSet = sMap.keySet();
        resultSet.retainAll(reverseMap.keySet());

        int results = 0;
        for (String entry : resultSet) {
            if (sMap.get(entry).equals(reverseMap.get(entry))) results++;
        }

        return results;
    }

    private static void populateMap(String s, Map<String, Pair> substringSet) {
        for (int i = 0; i < (s.length() / 2); i++) {
            substringSet.put(s.substring(i, i), new Pair(i, i));
            for (int j = i + 1; j < s.length(); j++) {
                substringSet.put(s.substring(i, j), new Pair(i, j));
                System.out.println(s.substring(i, j));
            }
        }
    }

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(sherlockAndAnagrams(s));
    }
}
