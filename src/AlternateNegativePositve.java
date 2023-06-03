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

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[random.nextInt(2, 100)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(-10, 20);
        }
        System.out.println(Arrays.toString(arr));
        alternateNegativePositive(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
