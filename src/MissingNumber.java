import java.util.Arrays;
import java.util.Random;

public class MissingNumber {

    // hashing seems to be the better solution iff the elements are not distinct
    private static int missingNumber(int[] arr, int N) {
        int[] hash = new int[N + 1];
        for (int i : arr)
            hash[i]++;
        for (int j = 1; j < hash.length; j++) {
            if (hash[j] == 0)
                return j;
        }
        return -1;
    }

    // lets try a different approach subtract between (summation of First N natural
    // numbers) and (summation of all array elements)
    // the below function will only work if the numbers are all distinct i.e every
    // number appearing once only!
    private static int missingNumber(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return (arr.length * (arr.length + 1) / 2) - sum;
    }

    // Another good solution is to use bitwise xor, iff the numbers are all distinct
    private static int missing(int[] arr) {
        int xor_1 = 0;
        for (int i = 1; i <= arr.length; i++)
            xor_1 ^= i;
        int xor_2 = 0;
        for (int i = 0; i < arr.length; i++) {
            xor_2 ^= arr[i];
        }
        return xor_1 ^ xor_2;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int N = random.nextInt(1, 100);
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int num = random.nextInt(1, N);
            arr[i] = num;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("The missing number from the array is : " + missingNumber(arr, N));
        // System.out.println("The missing number from the array is : " +
        // missingNumber(arr));
        // System.out.println("The missing number from the array is : " + missing(arr));
    }
}
