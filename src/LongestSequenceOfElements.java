import java.util.Random;
import java.util.Arrays;
import java.util.HashSet;

public class LongestSequenceOfElements {
    // T.C: O(N Log N)
    // S.C: O(1)
    private static int findLongestConsecutiveSequence(int[] nums, int n) {
        Arrays.sort(nums);
        int length = 1;
        int cnt = 0;
        int lastSmaller = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // the key here is to find the correct last smaller element in the array
            if (nums[i] == lastSmaller + 1) {
                cnt++;
                lastSmaller = nums[i];
            } else if (lastSmaller != nums[i]) {
                cnt = 1;
                lastSmaller = nums[i];
            }
            length = Math.max(length, cnt);
        }
        return length;
    }

    // T.C: O(N Log N)
    // S.C: O(1)
    private static int findLongestConsecutiveSequence(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 1;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int currNum = num;
                int cnt = 1;
                while (set.contains(currNum + 1)) {
                    cnt += 1;
                    currNum += 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int n = random.nextInt(1, 1000);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(0, 1000);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("The length of longest consecutive sequence in the array is : "
                + findLongestConsecutiveSequence(arr, n));
        System.out.println("The length of longest consecutive sequence in the array is : "
                + findLongestConsecutiveSequence(arr));
    }
}
