package algocourse.recursion;


import java.util.Map;
import java.util.TreeMap;

public class Fibonacci {

    private static final Map<Integer, Integer> cache = new TreeMap<>();

    public static void main(String[] args) {
        fibonacci(30);
        for (Integer key : cache.keySet()) {
            System.out.println(cache.get(key) + " ");
        }

    }



    private static int fibonacci(int n) {

        if (cache.get(n) != null) {
            return cache.get(n);
        } else if (n == 1 || n == 2) {
            cache.put(n, 1);
            return  1;
        }

        int result = fibonacci(n - 1) + fibonacci( n - 2);
        cache.put(n, result);

        return result;
    }
}
