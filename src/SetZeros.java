import java.util.Arrays;
import java.util.Random;

public class SetZeros {
    // The most brute force approach
    private static void setZeros(int[][] mat, int n, int m) {
        // First traverse through the array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    for (int k = 0; k < m; k++) {
                        if (mat[i][k] != 0)
                            mat[i][k] = -1;
                    }
                    for (int k = 0; k < n; k++) {
                        if (mat[k][j] != 0)
                            mat[k][j] = -1;
                    }
                }
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (mat[j][i] == -1) {
                    mat[j][i] = 0;
                }
            }
        }
    }

    private static void setZeros_2(int[][] mat) {
        if (mat == null)
            return;
        int n = mat.length;
        int m = mat[0].length;
        int[] setRow = new int[n];
        int[] setCol = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    setRow[i] = 1;
                    setCol[j] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (setRow[i] == 1 || setCol[j] == 1) {
                    mat[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int m = random.nextInt(1, 11);
        int n = random.nextInt(1, 11);
        int[][] mat = new int[n][m];
        for (int[] arr : mat) {
            for (int i = 0; i < m; i++) {
                arr[i] = random.nextInt(0, 10);
            }
        }
        for (int[] arr : mat) {
            System.out.println(Arrays.toString(arr));
        }
        // setZeros(mat, n, m);
        setZeros_2(mat);
        System.out.println("\n++++++++++++++++++++++++++++++++++++\n");
        for (int[] arr : mat) {
            System.out.println(Arrays.toString(arr));
        }

    }
}
