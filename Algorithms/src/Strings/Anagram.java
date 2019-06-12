package Strings;


import java.util.*;
import java.util.stream.Collectors;

/**
 * Two words are anagrams of one another if their letters can be rearranged to form the other word.
 *
 * In this challenge, you will be given a string. You must split it into two contiguous substrings, then determine the minimum number of characters to change to make the two substrings into anagrams of one another.
 *
 * For example, given the string 'abccde', you would break it into two parts: 'abc' and 'cde'. Note that all letters have been used, the substrings are contiguous and their lengths are equal. Now you can change 'a' and 'b' in the first substring to 'd' and 'e' to have 'dec' and 'cde' which are anagrams. Two changes were necessary.
 *
 * See <a href="https://www.hackerrank.com/challenges/anagram">https://www.hackerrank.com/challenges/anagram</a>
 */
public class Anagram {

    public static void main(String[] args) {
        System.out.println(anagram("aaabbb")); // 3
        System.out.println(anagram("ab")); // 1
        System.out.println(anagram("abc")); // -1
        System.out.println(anagram("mnop")); // 2
        System.out.println(anagram("xyyx")); // 0
        System.out.println(anagram("xaxbbbxx")); // 1
        System.out.println(anagram("fdhlvosfpafhalll")); // 5
    }

    private static int anagram(String s) {

        if (s.length() % 2 != 0) return -1; // not possible if odd character string

        List<Character> left = s.substring(0, s.length() / 2).chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> right = s.substring(s.length() / 2).chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        int changes = 0;
        Iterator<Character> leftIterator = left.iterator();
        while (leftIterator.hasNext()) {
            Character l = leftIterator.next();
            boolean shouldChange = true;

            Iterator<Character> rightIterator = right.iterator();
            while (rightIterator.hasNext()) {
                Character r = rightIterator.next();
                if (l.equals(r)) {
                    leftIterator.remove();
                    rightIterator.remove();
                    shouldChange = false;
                    break;
                }
            }
            changes += shouldChange ? 1 : 0;
        }

        return changes;
    }
}
