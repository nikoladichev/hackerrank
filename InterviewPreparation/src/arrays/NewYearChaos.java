package arrays;

public class NewYearChaos {

    public static void main(String[] args) {
        int test1[] = new int[]{2, 1, 5, 3, 4};
        int test2[] = new int[]{2, 5, 1, 3, 4};

        minimumBribes(test1); // 3
        minimumBribes(test2); // Too chaotic
    }

    static void minimumBribes(int[] arr) {

        int minimumBribes = 0;

        for (int i = arr.length - 1; i >= 0; i--) {

            if (arr[i] - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }

            for (int j = Math.max(0, (arr[i] - 2)); j < i; j++) {
                if (arr[j] > arr[i]) minimumBribes++;
            }

        }

        System.out.println(minimumBribes);
    }


}
