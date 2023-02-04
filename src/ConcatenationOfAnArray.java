import java.util.*;

public class ConcatenationOfAnArray {
    static int[] concatenateTheArray(int[] nums) {
        int[] ans = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
            ans[i + nums.length] = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[random.nextInt(1, 1000)];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(1, 1000);
        }
        System.out.println(Arrays.toString(concatenateTheArray(nums)));
    }
}
