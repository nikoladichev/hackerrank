package arrays;

public class LeftRotation {

    public static void main(String[] args) {
        int[] a = new int[]{33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60, 87, 97};
        int[] b = rotLeft(a, 13);

        for (int i : b) {
            System.out.print(i + " "); // final string should be "87 97 33 47 70 37 8 53 13 93 71 72 51 100 60"
        }
    }

    static int[] rotLeft(int[] a, int d) {

        int[] b = new int[a.length];

        int newIdx = 0;
        for (int i = a.length; i > 0; i--) {
            int idx = i - d;
            if (idx > 0) {
                b[newIdx++] = a[a.length - idx];
            } else {
                b[newIdx++] = a[Math.abs(idx)];
            }
        }
        return b;

    }
}
