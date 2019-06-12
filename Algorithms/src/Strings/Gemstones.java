package Strings;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * John has collected various rocks. Each rock has various minerals embeded in it. Each type of mineral is designated by a lowercase letter in the range . There may be multiple occurrences of a mineral in a rock. A mineral is called a gemstone if it occurs at least once in each of the rocks in John's collection.
 * <p>
 * Given a list of minerals embedded in each of John's rocks, display the number of types of gemstones he has in his collection.
 * <p>
 * For example, the array of mineral composition strings . The minerals  and  appear in each composite, so there are  gemstones.
 * <p>
 * See <a href="https://www.hackerrank.com/challenges/gem-stones">https://www.hackerrank.com/challenges/gem-stones</a>
 */
public class Gemstones {

    public static void main(String[] args) {
        System.out.println(gemstones(new String[]{"abcdde", "baccd", "eeabg"})); // 2
    }

    static int gemstones(String[] arr) {

        Map<Integer, Set<Character>> rockCompositionMap = new HashMap<>();


        for (int i = 0; i < arr.length; i++) {


            Set<Character> compositionSet = new HashSet<>();

            for (Character c : arr[i].toCharArray()) {
                compositionSet.add(c);
            }

            rockCompositionMap.put(i, compositionSet);
        }


        int count = 0;
        for (Character c : rockCompositionMap.get(0)) {
            boolean isGemstone = true;

            for (Set<Character> chars : rockCompositionMap.values()) {
                if (!chars.contains(c)) {
                    isGemstone = false;
                    break;
                }
            }

            count += isGemstone ? 1 : 0;
        }

        return count;
    }

}
