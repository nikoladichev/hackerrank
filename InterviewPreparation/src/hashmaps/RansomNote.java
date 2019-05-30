package hashmaps;

import java.util.HashMap;
import java.util.Map;
public class RansomNote {

    public static void main(String[] args) {
        String[] m = new String[]{"give", "me", "one", "grand", "today", "night"};
        String[] n = new String[]{"give", "one", "grand", "today"};

        checkMagazine(m, n);

        m = new String[]{"two", "times", "three", "is", "not", "four"};
        n = new String[]{"two", "times", "two", "is", "four"};

        checkMagazine(m, n);
    }

    static void checkMagazine(String[] magazine, String[] note) {

        Map<String, Integer> magazineWordMap = new HashMap<>();
        for (String item : magazine) {
            if (magazineWordMap.containsKey(item)) {
                magazineWordMap.put(item, magazineWordMap.get(item) + 1);
            } else {
                magazineWordMap.put(item, 1);
            }
        }

        boolean isValid = true;
        for (String word: note) {
            if (magazineWordMap.containsKey(word)) {
                int occurences = magazineWordMap.get(word);
                if (occurences > 1) {
                    magazineWordMap.put(word, occurences - 1);
                } else {
                    magazineWordMap.remove(word);
                }
            } else {
                isValid = false;
                break;
            }
        }

        System.out.println(isValid ? "Yes" : "No");
    }
}
