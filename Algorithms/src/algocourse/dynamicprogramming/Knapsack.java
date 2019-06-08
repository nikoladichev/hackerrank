package algocourse.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Knapsack {
    public static void main(String[] args) {

        int capacity = 4;

        Item[] items = new Item[3];
        // items[0] = new Item("None", 0, 0);
        items[0] = new Item("Flashlight", 2, 3); // flashlight
        items[1] = new Item("Laptop", 2, 1); // laptop
        items[2] = new Item("Book", 1, 3); // book

        solveKnapsack(items, capacity);
    }

    public static void solveKnapsack(Item[] items, int maxCapacity) {

        int[][] prices = new int[items.length + 1][maxCapacity + 1];
        boolean[][] markedItems = new boolean[items.length + 1][maxCapacity + 1];

        for (int itemIndex = 0; itemIndex < items.length; itemIndex++) {

            Item item = items[itemIndex];
            int rowIndex = itemIndex + 1;

            for (int capacity = 0; capacity <= maxCapacity; capacity++) {

                if (item.weight > capacity) {
                    continue;
                }

                int excluding = prices[rowIndex - 1][capacity];
                int including = item.price + prices[rowIndex - 1][capacity - item.weight];

                if (including > excluding) {
                    prices[rowIndex][capacity] = including;
                    markedItems[rowIndex][capacity] = true;
                } else {
                    prices[rowIndex][capacity] = excluding;
                }
            }
        }

        System.out.println("Weight matrix: ");
        for (int i = 0; i < prices.length; i++) {
            System.out.println(Arrays.toString(prices[i]));
        }

        System.out.println();

        List<Item> itemList = new ArrayList<>();
        int capacity = markedItems[0].length - 1;
        for (int i = markedItems.length - 1; i > 0; i--) {
            for (int j = capacity; j >= 0; j--) {
                Item item = items[i - 1];

                if (markedItems[i][j] && (capacity - item.weight >= 0)) {
                    itemList.add(item);
                    capacity -= item.weight;
                    break;
                }
            }
        }

        System.out.println("Taken items: ");
        for (Item item : itemList) {
            System.out.println(item.toString());
        }
    }

    public static class Item {

        String name;
        int weight;
        int price;

        public Item(String name, int weight, int price) {
            this.name = name;
            this.weight = weight;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "name='" + name + '\'' +
                    ", weight=" + weight +
                    ", price=" + price +
                    '}';
        }
    }
}
