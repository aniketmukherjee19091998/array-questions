import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CountSubArraysWithGivenXor {
    private static int numberOfSubArraysWithGivenXor(int[] arr, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int xr = 0;
        map.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            xr ^= arr[i];
            int x = xr ^ k;
            if (map.containsKey(x)) {
                count += map.get(x);
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[random.nextInt(2, 1000)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1, 11);
        }
        int xor = random.nextInt(2, 11);
        // System.out.println(
        // "The number of subarrays with given xor : " + 6 + " is : "
        // + numberOfSubArraysWithGivenXor(new int[] { 4, 2, 2, 6, 4 }, 6));
        System.out.println(
                "The number of subarrays with given xor : " + xor + " is : "
                        + numberOfSubArraysWithGivenXor(arr, xor));
    }
}
