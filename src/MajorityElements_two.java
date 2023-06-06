import java.util.*;

public class MajorityElements_two {
    static List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i : nums) {
            if (!count.containsKey(i)) {
                count.put(i, 1);
            } else {
                count.put(i, count.get(i) + 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value > nums.length / 3) {
                result.add(key);
            }
        }
        return result;
    }

    static List<Integer> majorityElement_space_optimized(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int count_1 = 0, count_2 = 0;
        int ele_1 = Integer.MIN_VALUE, ele_2 = Integer.MIN_VALUE;
        for (int i : nums) {
            if (count_1 == 0 && i != ele_2) {
                count_1 = 1;
                ele_1 = i;
            } else if (count_2 == 0 && i != ele_1) {
                count_2 = 1;
                ele_2 = i;
            } else if (ele_1 == i) {
                count_1++;
            } else if (ele_2 == i) {
                count_2++;
            } else {
                count_1--;
                count_2--;
            }
        }
        count_1 = 0;
        count_2 = 0;
        for (int num : nums) {
            if (num == ele_1)
                count_1++;
            if (num == ele_2)
                count_2++;
        }
        int q = nums.length / 3 + 1;
        if (count_1 >= q) {
            result.add(ele_1);
        }
        if (count_2 >= q) {
            result.add(ele_2);
        }
        return result;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[random.nextInt(1, 100000)];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(1, 10 + 1);
        }
        System.out.println("The majority elements are : " + majorityElement(nums));
        System.out.println("The majority elements are : " + majorityElement_space_optimized(nums));
    }
}
