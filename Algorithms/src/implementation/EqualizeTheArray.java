package implementation;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class EqualizeTheArray {

    public static void main(String[] args) {
        int[] test1 = new int[] {3, 3, 2, 1, 3};

        System.out.println(equalizeArray(test1));
    }

    static int equalizeArray(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int element : arr) {
            Integer current = map.get(element);
            if (current == null) {
                map.put(element, 1);
            } else {
                map.put(element, ++current);
            }
        }

        Map.Entry<Integer, Integer> maxEntry = new AbstractMap.SimpleEntry<>(0, 0);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }

        return arr.length - maxEntry.getValue();
    }

}
