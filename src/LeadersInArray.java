import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class LeadersInArray {
    private static ArrayList<Integer> findLeaders(int[] arr, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (max < arr[i]) {
                max = arr[i];
            }
            if (arr[i] >= max) {
                result.add(arr[i]);
            }
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int n = random.nextInt(1, 10000000);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(0, 10000000);
        }
        System.out.println(findLeaders(arr, n));
    }
}
