import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PascalTriangle {

    /*
     * The formula for pascal's triangle is for any element in ith row and jth col
     * the element is :
     * (i-1)C(j-1)
     */

    private static void printRow(int n) {
        int ans = 1;
        System.out.print(ans + " ");
        for (int i = 1; i < n + 1; i++) {
            int numerator = n - i;
            int denominator = i;
            ans *= numerator;
            ans /= denominator;
            if (ans > 0)
                System.out.print(ans + " ");
        }
    }

    private static List<List<Integer>> returnWholeTriangle(int n) {
        List<List<Integer>> result = new ArrayList<>();
        for (int row = 1; row <= n; row++) {
            List<Integer> tmp = new ArrayList<>();
            int ans = 1;
            tmp.add(ans);
            for (int i = 1; i < row + 1; i++) {
                int numerator = row - i;
                int denominator = i;
                ans *= numerator;
                ans /= denominator;
                if (ans > 0)
                    tmp.add(ans);
            }
            result.add(tmp);
        }
        return result;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int n = random.nextInt(1, 10);
        // we have to print nth row of the pascal's triangle
        System.out.println("The " + n + "th row is : ");
        printRow(n);
        System.out.println();
        List<List<Integer>> result = returnWholeTriangle(n);
        for (List<Integer> tmp : result) {
            System.out.println(tmp);
        }
    }
}
