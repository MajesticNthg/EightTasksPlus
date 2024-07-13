import java.util.HashMap;

public class Main {
    public static boolean ECC_help (int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;

        HashMap<Integer, Integer> result1 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> result2 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> result3 = new HashMap<Integer, Integer>();

        for (int x = 0; x < arr1.length; x++) {
            result1.put(arr1[x], x);
            result3.put(arr2[x], x);
            result3.put(arr1[x], x);
            result2.put(arr2[x], x);
        }
        if (result1.size() != result3.size() || result2.size() != result3.size()) return false;

        return true;
    }
}

