package datastructures.stacks;

import java.util.*;

public class MaximumElement {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        Integer max = null;
        boolean maxCleared = false;
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String[] elements = s.split(" ");

            switch (elements[0]) {
                case "1":
                    Integer e = Integer.parseInt(elements[1]);
                    stack.push(e);
                    if (max == null || e > max) {
                        max = e;
                        maxCleared = false;
                    }
                    break;
                case "2":
                    Integer el = stack.peek();
                    stack.pop();
                    if (el == max) {
                        maxCleared = true;
                    }
                    break;
                case "3": {
                    if (max == null || maxCleared) {
                        max = null;
                        for (Integer element : stack) {
                            if (max == null) {
                                max = element;
                            } else if (max < element) {
                                max = element;
                            }
                        }
                    }
                    System.out.println(max);
                    break;
                }
            }
        }

        scanner.close();
    }
}