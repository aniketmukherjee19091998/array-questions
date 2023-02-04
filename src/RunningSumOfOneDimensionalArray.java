import java.util.Random;
import java.util.Arrays;

public class RunningSumOfOneDimensionalArray {
    static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[random.nextInt(1, 1000)];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(-1000000, 1000000);
        }
        System.out.println("The running sum of the 1D array is : " + Arrays.toString(runningSum(nums)));
    }
}
