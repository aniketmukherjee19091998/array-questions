import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PrintMatrixInSpiralManner {
    private static List<Integer> spiralMatrix(int[][] mat, int n, int m) {
        List<Integer> result = new ArrayList<>();
        int top = 0, bottom = n - 1;
        int left = 0, right = m - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                result.add(mat[top][i]);
            }
            ++top;
            for (int i = top; i <= bottom; i++) {
                result.add(mat[i][right]);
            }
            --right;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(mat[bottom][i]);
                }
                --bottom;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(mat[i][left]);
                }
                ++left;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int n = random.nextInt(3, 11);
        int m = random.nextInt(3, 11);
        int[][] mat = new int[n][m];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = random.nextInt(1, 11);
            }
        }
        for (int[] is : mat) {
            System.out.println(Arrays.toString(is));
        }
        System.out.println();
        System.out.println();
        System.out.println(spiralMatrix(mat, n, m));
    }
}
