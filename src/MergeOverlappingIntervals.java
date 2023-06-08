import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals {
    private static int[][] mergeIntervals(int[][] intervals) {
        // we need to first club the intervals together so we get the
        // overlapping intervals almost together
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int a = intervals[i][0];
            int b = intervals[i][1];
            if (!list.isEmpty() && b <= list.get(list.size() - 1).get(1)) {
                continue;
            }
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[j][0] <= b) {
                    b = Math.max(b, intervals[j][1]);
                } else {
                    break;
                }
            }
            list.add(Arrays.asList(a, b));
        }
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i][0] = list.get(i).get(0);
            result[i][1] = list.get(i).get(1);
        }
        return result;
    }

    private static List<List<Integer>> mergeIntervals_Optimized(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int a = intervals[i][0];
            int b = intervals[i][1];
            if (result.isEmpty() || result.get(result.size() - 1).get(1) < a) {
                result.add(Arrays.asList(a, b));
            } else {
                b = Math.max(result.get(result.size() - 1).get(1), b);
                result.get(result.size() - 1).set(1, b);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 9 }, { 9, 11 }, { 8, 10 }, { 2, 4 }, { 15, 18 }, { 16, 17 } };
        System.out.println("The merged intervals are : ");
        int[][] ans = mergeIntervals(intervals);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
        System.out.println("\n_____________________________\n");
        List<List<Integer>> result = mergeIntervals_Optimized(new int[][] { { 1, 4 }, { 0, 4 } });
        for (List<Integer> temp : result) {
            System.out.println(temp);
        }
    }
}
