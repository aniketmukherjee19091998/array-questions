import java.util.Arrays;
import java.util.Random;

public class CreateTargetArrayInGivenOrder {
    private static int[] createTargetArray(int[] nums, int[] index) {
        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            result[index[i]] = nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[random.nextInt(1, 100)];
        int[] index = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(0, 100);
        }
        for (int i = 0; i < index.length; i++) {
            index[i] = random.nextInt(0, i);
        }
        System.out.println(Arrays.toString(createTargetArray(nums, index)));
    }
}