import java.util.Random;

public class RichestCustomerWealth {
    private static int richestWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[0].length; j++) {
                sum += accounts[i][j];
            }
            max = (max < sum) ? sum : max;
        }
        return max;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int m = random.nextInt(1, 50);
        int n = random.nextInt(1, 50);
        int[][] accounts = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                accounts[i][j] = random.nextInt(1, 100);
            }
        }
        System.out.println("The richest wealth is : " + richestWealth(accounts));
    }
}
