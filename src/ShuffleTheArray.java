import java.util.*;

public class ShuffleTheArray {
    private static int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[2 * i] = nums[i];
            ans[2 * i + 1] = nums[n + i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int n = random.nextInt(1, 500);
        int[] nums = new int[2 * n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(1, 1000);
        }
        System.out.println("The original version is : " + Arrays.toString(nums));
        System.out.println("The shuffled version is : " + Arrays.toString(shuffle(nums, n)));
    }
}
