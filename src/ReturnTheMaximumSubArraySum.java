import java.util.Random;

public class ReturnTheMaximumSubArraySum {
    private static long func(int[] arr, int n) {
        // A brute force solution would be
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            long sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                max = Math.max(max, sum);
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    // we can do better than that! Perhaps in linear time complexity
    /*
     * Kadane's algorithm:-> At first initialize two variables sum and max to 0 and
     * arr[0] respectively
     * Then traverse the array update sum += arr[i] if(max < sum) then update max to
     * sum, IF sum is lesser than
     * zero then update sum as zero. The main intuition is to not accept a sum that
     * is lesser than zero.
     */
    private static long maxSubArraySum(int[] arr, int n) {
        int sum = 0, max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            max = Math.max(max, sum);
            if (sum < 0)
                sum = 0;
        }
        return max;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[rand.nextInt(1, 1000)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(-10000, 10001);
        }
        System.out.println("The maximum subarray sum is : " + func(arr, arr.length));
        System.out.println("The maximum subarray sum is : " + maxSubArraySum(arr, arr.length));
    }
}
