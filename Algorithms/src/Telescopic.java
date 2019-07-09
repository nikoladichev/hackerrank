import java.util.Arrays;

public class Telescopic {

    public static void main(String[] args) {
        System.out.println(isTelescopic(new int[] {1, 2, 2, 1}));
        System.out.println(isTelescopic(new int[] {1, 2, 2, 4}));
        System.out.println(isTelescopic(new int[] {1, 2, 3, 2, 1}));

    }

    static boolean isTelescopic(int[] a) {

        int middle = a.length % 2;
        int[] left = Arrays.copyOfRange(a, 0, a.length / 2);
        int[] right = Arrays.copyOfRange(a, (a.length / 2) +  middle, a.length);

        // reverse right
        int[] rightReverse = new int[right.length];
        int element = right.length;
        for (int i = 0; i < right.length; i++) {
            rightReverse[element - 1] = right[i];
            element = element - 1;
        }

        return Arrays.equals(left, rightReverse);
    }
}
