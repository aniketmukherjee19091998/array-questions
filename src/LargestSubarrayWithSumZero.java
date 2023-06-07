import java.util.HashMap;
import java.util.Random;

public class LargestSubarrayWithSumZero {
    private static int largestSubarray(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, length = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                length = i + 1;
            } else {
                if (!map.containsKey(sum)) {
                    map.put(sum, i);
                } else {
                    length = Math.max(length, i - map.get(sum));
                }
            }
        }
        return length;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[random.nextInt(2, 10000)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(-10000, 10000);
        }
        System.out.println("The length of the largest subarray with target sum as 0 is : " + largestSubarray(arr));
    }
}
