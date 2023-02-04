import java.util.*;

public class NumberOfGoodPairs {
    static int numberOfGoodPairs(int[] nums) {
        int[] count = new int[102];
        for (int num : nums)
            count[num]++;
        int ans = 0;
        for (int frequency : count) {
            ans += ((frequency) * (frequency - 1)) / 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[random.nextInt(1, 100)];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(1, 100);
        }
        System.out.println("The number of good pairs are : " + numberOfGoodPairs(nums));
    }
}
