import java.util.Arrays;

public class MergeSortedArray {

    private static void merge(int[] a, int m, int[] b, int n) {
        int end = m + n - 1;
        int end1 = m - 1;
        int end2 = n - 1;
        while (end2 >= 0) {
            if (end1 >= 0) {
                a[end--] = a[end1] > b[end2] ? a[end1--] : b[end2--];
            } else {
                a[end--] = b[end2--];
            }
        }
    }

    public static void main(String[] args) {
        int m = 3, n = 3;
        int[] a = { 1, 2, 3, 0, 0, 0 };
        int[] b = { 2, 6, 7 };
        System.out.println("Before: \n" + Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println("\nAfter : ");
        merge(a, m, b, n);
        System.out.println(Arrays.toString(a));
    }
}
