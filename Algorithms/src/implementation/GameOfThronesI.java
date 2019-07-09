package implementation;

import java.util.HashMap;
import java.util.Map;

public class GameOfThronesI {

    public static void main(String[] args) {
        String s = "cdcdcdcdeeeef";
        System.out.println(gameOfThrones(s) ? "YES" : "NO"); // YES
        s = "cdefghmnopqrstuvw";
        System.out.println(gameOfThrones(s) ? "YES" : "NO"); // NO
    }

    private static boolean gameOfThrones(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (Character c: s.toCharArray()) {
            Integer count = map.get(c);
            if (count == null) {
                count = 1;
            } else {
                count++;
            }

            map.put(c, count);
        }

        int oddCharacters = 0;

        for (Integer count: map.values()) {

            if (count % 2 == 1) {
                oddCharacters++;
            }
        }

        return oddCharacters <= 1;

    }
}
