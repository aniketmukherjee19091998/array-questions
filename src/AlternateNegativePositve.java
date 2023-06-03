import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class AlternateNegativePositve {
    private static void alternateNegativePositive(int[] arr, int n) {
        /*
         * This is the most brute force solution I can come with as of now.
         * In the given question we are allowed to use extra space so
         * Just create two lists for negative and positive integers append them as well
         * then add those integers alternatively (+ve, -ve, +ve, -ve, .....)
         */
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        for (int num : arr) {
            if (num < 0)
                negative.add(num);
            else
                positive.add(num);
        }
        int i = 0, j = 0, k = 0;
        while (i < positive.size() && j < negative.size()) {
            arr[k++] = positive.get(i++);
            arr[k++] = negative.get(j++);
        }
        while (i < positive.size()) {
            arr[k++] = positive.get(i++);
        }
        while (j < negative.size()) {
            arr[k++] = negative.get(j++);
        }
    }

    /*
     * A little more optimized solution where we can use only one loop rather than 2
     * or 3 like before
     */
    private static int[] optimized_alternatePositiveAndNegative(int[] arr, int n) {
        int[] result = new int[n];
        int p = 0, neg = 1;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                result[neg] = arr[i];
                neg += 2;
            } else {
                result[p] = arr[i];
                p += 2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[random.nextInt(2, 100)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(-10, 20);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(optimized_alternatePositiveAndNegative(arr, arr.length)));
        alternateNegativePositive(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
