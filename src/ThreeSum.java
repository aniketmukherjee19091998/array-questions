import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ThreeSum {

    static List<List<Integer>> threeSum_Optimized(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return result;
    }

    static List<List<Integer>> threeSum_BruteForce(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        sort(tmp);
                        if (!set.contains(tmp)) {
                            set.add(tmp);
                            result.add(tmp);
                        }
                    }
                }
            }
        }
        return result;
    }

    static List<List<Integer>> threeSum_Better(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> temp_set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int third = 0 - (nums[i] + nums[j]);
                if (temp_set.contains(third)) {
                    List<Integer> tmp_list = new ArrayList<>();
                    tmp_list.add(nums[i]);
                    tmp_list.add(nums[j]);
                    tmp_list.add(third);
                    sort(tmp_list);
                    set.add(tmp_list);
                }
                temp_set.add(nums[j]);
            }
        }
        for (List<Integer> tmp : set) {
            result.add(tmp);
        }
        return result;
    }

    static void sort(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                int tmp = list.get(i);
                int tmp_2 = list.get(i + 1);
                list.set(i, tmp_2);
                list.set(i + 1, tmp);
            }
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[random.nextInt(3, 1000)];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(-1000000, 1000001);
        }
        List<List<Integer>> result = threeSum_BruteForce(nums);
        for (List<Integer> tmp : result) {
            System.out.println(tmp);
        }
        System.out.println("\n_______________________________\n");
        List<List<Integer>> result_1 = threeSum_Better(nums);
        for (List<Integer> tmp : result_1) {
            System.out.println(tmp);
        }
        System.out.println("\n_______________________________\n");
        List<List<Integer>> result_2 = threeSum_Optimized(nums);
        for (List<Integer> tmp : result_2) {
            System.out.println(tmp);
        }
    }
}
