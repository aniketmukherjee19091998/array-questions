import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HowManySmall {

    private static int[] findHowManySmaller(int[] nums) {
        int[] temp = nums.clone();
        Arrays.sort(temp);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < temp.length; i++) {
            map.putIfAbsent(nums[i], i);
        }
        for (int i = 0; i < temp.length; i++) {
            temp[i] = map.get(nums[i]);
        }
        return temp;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[random.nextInt(2, 500)];
        for (int i = 0; i < nums.length; i++)
            nums[i] = random.nextInt(0, 100);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(findHowManySmaller(nums)));
    }
}
