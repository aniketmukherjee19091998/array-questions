import java.util.Random;

public class SubarraySum {
    private static int maxSubArrayWithSumK(int[] arr, int K) {
        // since the array this time only contains positives and zeros
        int sum = 0, len = 0, j = 0, i = 0;
        while (i++ < arr.length) {
            while (j < i && sum > K) {
                sum -= arr[j];
                j++;
            }
            if (sum == K)
                len = Math.max(len, i - j + 1);
            if (i < arr.length)
                sum += arr[i];
        }
        return len;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int K = random.nextInt(1, 10000);
        int N = random.nextInt(2, 10000);
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(0, 10000);
        }
        System.out.println(maxSubArrayWithSumK(arr, K));
    }
}
