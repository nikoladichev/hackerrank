package stuff;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AnagramCharacters {

    public static void main(String[] args) {
        System.out.println(makingAnagrams("cde", "abc"));
    }

    static int makingAnagrams(String s1, String s2) {

        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();
        fillMap(s1, s1Map);
        fillMap(s2, s2Map);

        int deletions = 0;

        for(Iterator<Map.Entry<Character, Integer>> it = s1Map.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<Character, Integer> entry = it.next();
            if (s2Map.containsKey(entry.getKey())) {
                deletions += Math.abs(s2Map.get(entry.getKey()) - s1Map.get(entry.getKey()));
                s2Map.remove(entry.getKey());
            } else {
                deletions += s1Map.get(entry.getKey());
            }
            it.remove();
        }
        for (Character c: s1Map.keySet()) {
            if (s2Map.containsKey(c)) {
                deletions += Math.abs(s2Map.remove(c) - s1Map.remove(c));
            } else {
                deletions += s1Map.get(c);
            }
        }


        for (Character c: s2Map.keySet()) {
            deletions += s2Map.get(c);
        }

        return deletions;
    }

    private static void fillMap(String s, Map<Character, Integer> map) {

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            map.merge(aChar, 1, Integer::sum);
        }

    }
}
