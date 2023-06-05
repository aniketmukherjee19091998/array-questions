import java.util.Arrays;
import java.util.Random;

public class RotateMatrixByClockwise {
    // brute force
    private static int[][] rotateByNinetyDegressClockwise(int[][] mat, int n) {
        int[][] res = new int[n][n];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res.length; j++) {
                res[j][n - i - 1] = mat[i][j];
            }
        }
        return res;
    }

    /*
     * The more optimized version would be:
     * we are going to ditch the extra space first
     * then transpose that and then reverse the rows of the transposed matrix
     */
    private static void optimized_rotateMatrixByNinetyDegreessClockwise(int[][] mat, int n) {
        // transpose : [i][j] => [j][i] when (i != j)
        for (int i = 0; i < mat.length - 1; i++) {
            for (int j = i + 1; j < mat.length; j++) {
                swap(mat, i, j);
            }
        }

        // then reverse the row
        for (int i = 0; i < mat.length; i++) {
            reverse(mat[i]);
        }
    }

    static void swap(int[][] mat, int i, int j) {
        int temp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = temp;
    }

    static void reverse(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i++ <= j--) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int n = random.nextInt(2, 10);
        int[][] mat = new int[n][n];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                mat[i][j] = random.nextInt(1, 101);
            }
        }
        for (int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
        System.out.println();
        System.out.println();
        int[][] res = rotateByNinetyDegressClockwise(mat, n);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
        System.out.println();
        System.out.println();
        optimized_rotateMatrixByNinetyDegreessClockwise(mat, n);
        for (int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
    }
}
