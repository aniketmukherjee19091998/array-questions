import java.util.*;

public class NextPermutation {
    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    /*
     * Worst case: O(N log N)
     */
    private static int[] nextPermutation(int[] nums, int n) {
        // first find the breakpoint
        int ind = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1])
                ind = i;
        }
        // if no breakpoint is found then it means its already is the largest possible
        // permutation just return the sorted version
        if (ind == -1) {
            Arrays.sort(nums);
            return nums;
        }
        // if breakpoint is found
        for (int i = n - 1; i > ind; i--) {
            if (nums[i] > nums[ind]) {
                swap(nums, i, ind);
                break;
            }
        }
        // now reverse the sorted order except the swapped index
        reverse(nums, ind + 1);
        return nums;
    }

    public static void swap(int[] nums, int i, int ind) {
        int temp = nums[i];
        nums[i] = nums[ind];
        nums[ind] = temp;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int n = random.nextInt(1, 10);
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(0, 10);
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nextPermutation(nums, n)));
    }
}
