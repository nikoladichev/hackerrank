package algocourse.sorting;

public class SelectionSort {

    private static final int[] arr = new int[] { 5, 2, 19, 299, 1, 404, 9, -3, 6, 18, 55 };

    public static void main(String[] args) {
        selectionSort();

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void selectionSort() {

        for (int i = 0; i < arr.length; i++) {

            int temp = arr[i];
            int pos = i;

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] < temp) {
                    pos = j;
                    temp = arr[j];
                }
            }

            if (pos != i) {
                swap(i, arr[i], pos, temp);
            }
        }
    }

    private static void swap (int origPos, int origVal, int newPos, int newVal) {
        arr[origPos] = newVal;
        arr[newPos] = origVal;
    }

}
