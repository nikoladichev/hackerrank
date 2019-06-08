package algocourse.dynamicprogramming;

import java.util.*;

public class SubsetSum {

    public static void main(String[] args) {

        int[] numbers = { 3, 5, 1, 6, 4 };
        int targetSum = 9;

        subsetSumNoRepeat (numbers, targetSum);
    }

    private static void subsetSumNoRepeat(int[] numbers, int targetSum) {

        Map<List<Integer>, Integer> sumMap = new HashMap<>();

        List<Integer> initialArrayList = new ArrayList<>();
        initialArrayList.add(0);
        sumMap.put(initialArrayList, 0);

        for (int number: numbers) {

            Map<List<Integer>, Integer> subsetSumMap = new HashMap<>();

            for (Map.Entry<List<Integer>, Integer> entry: sumMap.entrySet()) {

                List<Integer> key = new ArrayList<>(entry.getKey());
                key.add(number);
                Integer value = entry.getValue() + number;

                subsetSumMap.put(key, value);
            }

            sumMap.putAll(subsetSumMap);
        }

        for (Map.Entry<List<Integer>, Integer> entry: sumMap.entrySet()) {

            List<Integer> key = entry.getKey();
            Integer value = entry.getValue();

            if (value == targetSum) {
                System.out.println(Arrays.toString(key.toArray()));
            }
        }
    }


//    private static void subsetSumWithRepeat(int[] numbers, int targetSum) {
//
//        Map<List<Integer>, Integer> sumMap = new HashMap<>();
//
//        List<Integer> initialArrayList = new ArrayList<>();
//        initialArrayList.add(0);
//        sumMap.put(initialArrayList, 0);
//
//        for (int number: numbers) {
//
//            Map<List<Integer>, Integer> subsetSumMap = new HashMap<>();
//
//            int sum = 0;
//            while (sum <= targetSum) {
//
//            }
//
//            for (Map.Entry<List<Integer>, Integer> entry: sumMap.entrySet()) {
//
//                List<Integer> key = new ArrayList<>(entry.getKey());
//                key.add(number);
//                Integer value = entry.getValue() + number;
//
//                subsetSumMap.put(key, value);
//            }
//
//            sumMap.putAll(subsetSumMap);
//        }
//
//        for (Map.Entry<List<Integer>, Integer> entry: sumMap.entrySet()) {
//
//            List<Integer> key = entry.getKey();
//            Integer value = entry.getValue();
//
//            if (value == targetSum) {
//                System.out.println(Arrays.toString(key.toArray()));
//            }
//        }
//    }
}
