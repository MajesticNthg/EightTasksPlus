import java.util.Arrays;

public class Cyberpunk203xPt4 {
    public static int[] TRC_sort(int[] trc) {
        int x = 0;

        for (int i = 0; i < trc.length; i++) {
            if (trc[i] > x) {
                x++;
            }
            if (trc[i] < x) {
                int z = trc[i - 1];
                trc[i - 1] = trc[i];
                trc[i] = z;
                TRC_sort(trc);
            }
        }

        return trc;

    }
}

