import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class FindTheMaxiumOcurringElement {
    private static int findMaxOcurringElement(int[] arr, int size) {
        // lets create a brute force approach first
        int cnt = 1;
        int element = -1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j)
                    continue;
                if (arr[i] == arr[j]) {
                    cnt++;
                }
            }
            if (cnt > size / 2)
                element = arr[i];
            cnt = 1;
        }
        return element;
    }

    // lets create a hashing approach, very impractical if the element space is vast
    private static int findMaxOcurringElement_2(int[] arr, int size) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
            if (map.get(num) > size / 2)
                return num;
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value != null && value > size / 2) {
                int ans = entry.getKey();
                return ans;
            }
        }
        return -1;
    }

    /*
     * But still the above two are that great! Perhaps, we can do better than O(Nlog
     * N) T.C and O(N) S.C
     * That's where the Moore's voting algorithm comes in.
     * Take two variables element and count, intialize them to -1 and 0
     * respectively.
     * Now while traversing the array if we encounter arr[0] count++ otherwise
     * count--;
     * IFF count == 0 THEN -> arr[0] cannot appear more than N/2 times. Change the
     * element = arr[i], count = 1 respectively!
     * Then traverse the array again. Repeat the process over again untill i is not
     * lesser than arr.length!;
     * Lastly you will have an arr[i] in element variable so count = 0 then traverse
     * the array if found element then you count++
     * if count > arr.length / 2 return element or else -1;
     */

    private static int mooreAlgorithmToFindMajorityElement(int[] arr, int n) {
        int element = -1;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                element = arr[i];
                count = 1;
            } else if (arr[i] == element) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element)
                count++;
        }
        return count > n / 2 ? element : -1;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int n = random.nextInt(1, 100000);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = random.nextInt(1, 100);
        // int[] arr = { 3, 1, 3, 3, 2 };
        // int n = 5;
        System.out.println("The maximum occuring element is(using brute force) : " + findMaxOcurringElement(arr, n));
        System.out.println("The maximum occuring element is(using hashmaps) : " + findMaxOcurringElement_2(arr, n));
        System.out.println("The maximum occuring element is(using Moore's algorithm) : "
                + mooreAlgorithmToFindMajorityElement(arr, n));
    }
}
