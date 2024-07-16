import java.util.HashMap;

public class Cyberpunk203xPt2 {
    public static int artificial_muscle_fibers(int[] arr) {
        HashMap <Integer, Integer> result = new HashMap<Integer, Integer>();
        HashMap <Integer, Integer> finalResult = new HashMap<Integer, Integer>();

        for (int x = 0; x < arr.length; x++) {
            int i = result.size();
            result.put(arr[x], arr[x]);
            if (result.size() == i) {
                finalResult.put(arr[x], arr[x]);
            }
        }
        return finalResult.size();
    }
}

