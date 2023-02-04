import java.util.*;

public class CreateAnArrayFromPermutation {
    static int[] func(int[] nums) {
        if (nums.length == 0)
            return null;
        if (nums.length == 1) {
            if (nums[0] != 0)
                return null;
            return new int[] { 0 };
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] nums = new int[rand.nextInt(1, 1000)];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rand.nextInt(0, nums.length - 1);
        }
        System.out.println("The permuatated array is : " + Arrays.toString(func(nums)));
    }
}
