package Strings;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Sherlock {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(isValid("aabbccddeefghi")); // NO
        System.out.println(isValid("abcdefghhgfedecba")); // YES
        System.out.println(isValid("aaaabbcc")); // NO
        System.out.println(isValid("aaaaabc")); // NO
        File f = new File (Objects.requireNonNull(Sherlock.class.getClassLoader().getResource("sherlock.txt")).getFile()); // YES
        Scanner scanner = new Scanner(f);

        String s = scanner.nextLine();
        System.out.println(isValid(s));
    }

    static String isValid(String s) {

        Map<Character, Integer> occurenceMap = new HashMap<>();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            Integer count = occurenceMap.get(c);
            if (count == null || count.equals(0)) {
                occurenceMap.put(c, 1);
            } else {
                occurenceMap.put(c, ++count);
            }
        }

        Set<Integer> set = new TreeSet<>(occurenceMap.values());
        if (set.size() == 1) {
            return "YES";
        } else if (set.size() > 2) {
            return "NO";
        } else {
            int first = set.iterator().next();

            List<Integer> firstList = new ArrayList<>();
            List<Integer> secondList = new ArrayList<>();
            for (int value : occurenceMap.values()) {
                if (value == first) {
                    firstList.add(value);
                } else {
                    secondList.add(value);
                }
            }

            boolean isValueValid = (firstList.get(0) + 1 == secondList.get(0) || secondList.get(0) + 1 == firstList.get(0))
                    || (firstList.get(0) == 1 && firstList.size() == 1 || secondList.get(0) == 1 && secondList.size() == 1);
            if (isValueValid && (firstList.size() == 1 || secondList.size() == 1)) {
                return "YES";
            }
            return "NO";
        }
    }
}
