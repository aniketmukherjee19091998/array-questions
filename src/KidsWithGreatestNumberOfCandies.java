import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KidsWithGreatestNumberOfCandies {
    static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int candy : candies) {
            max = (candy > max) ? candy : max;
        }
        for (int candy : candies) {
            result.add(max <= candy + extraCandies);
        }
        return result;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] candies = new int[random.nextInt(2, 100)];
        for (int i = 0; i < candies.length; i++) {
            candies[i] = random.nextInt(1, 100);
        }
        int extraCandies = random.nextInt(1, 50);
        System.out.println(kidsWithCandies(candies, extraCandies));
    }
}
