import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FourSum {

    private static List<List<Integer>> fourSum_Optimized(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1])
                    continue;
                int k = j + 1;
                int l = n - 1;
                while (l > k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int remainder = target - sum;
                    if (remainder < nums[l]) {
                        l--;
                    } else if (remainder > nums[l]) {
                        k++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        l--;
                        k++;
                        while (k < l && nums[k] == nums[k - 1])
                            k++;
                        while (k < l && nums[l] == nums[l + 1])
                            l--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[random.nextInt(4, 200)];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(-100000, 100001);
        }
        int target = random.nextInt(-100000, 100001);
        System.out.println("Target : " + target);
        List<List<Integer>> result_2 = fourSum_Optimized(nums, target);
        for (List<Integer> temp : result_2) {
            System.out.println(temp);
        }
    }
}
