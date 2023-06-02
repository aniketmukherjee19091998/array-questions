import java.util.Arrays;
import java.util.Random;

public class FindRowWithMaxOnes {
    private static int rowWithMax1s(int[][] arr, int n, int m) {
        int row = 0, col = m - 1;
        int count = 0, max = 0, ans = -1;
        while (row < n && col >= 0) {
            if (arr[row][col] != 1) {
                col = m - 1;
                row++;
                count = 0;
            } else {
                col--;
                count++;
            }
            if (count > max)
                ans = row;
            max = Math.max(max, count);
        }
        return ans;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int n = random.nextInt(1, 1001);
        int m = random.nextInt(1, 1001);
        int[][] arr = new int[n][m];
        int ans = 0, max = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < m; j++) {
                arr[i][j] = random.nextInt(0, 2);
                if (arr[i][j] == 1)
                    count++;
            }
            if (count > max)
                ans = i;
            Arrays.sort(arr[i]);
        }
        // int[][] arr = {
        // { 0, 0, 0, 1, 1, 1, 1, 1, 1 },
        // { 0, 0, 0, 0, 1, 1, 1, 1, 1 },
        // { 0, 0, 0, 0, 1, 1, 1, 1, 1 }
        // };
        // for (int[] a : arr) {
        // System.out.println(Arrays.toString(a));
        // }
        // System.out.println(random.nextInt(0, 2));
        System.out.println("The row number with the max number of 1's is : " + rowWithMax1s(arr, n, m));
        System.out.println(ans);
    }
}
