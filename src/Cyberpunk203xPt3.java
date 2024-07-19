import java.util.HashMap;

public class Cyberpunk203xPt3 {
    public static int massdriver (int[] activate) {
        HashMap <Integer, Integer> result = new HashMap<Integer, Integer>();
        HashMap <Integer, Integer> finalResult = new HashMap<Integer, Integer>();
        int z = -1;

        for (int i = 0; i < activate.length; i++) {
            int x = result.size();
            result.put(activate[i], i);
            if (result.size() != x) {
                finalResult.put(activate[i], i);
            }
            else if (finalResult.get(activate[i]) < z || z < 0) {
                z = finalResult.get(activate[i]);
            }
        }
        return z;
    }
    public static void main(String[] args) {
        int[] activate = new int[] {1, 2, 3, 4, 5, 6, 7};
        System.out.println(massdriver(activate));
    }
}