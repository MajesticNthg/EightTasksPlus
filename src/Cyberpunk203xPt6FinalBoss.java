import java.util.Arrays;

public class Cyberpunk203xPt6FinalBoss {
    public static String army_communication_matrix(int n, int[][] matrix) {
        int max_sum = 0;
        int sum = 0;
        int size = 2;
        int[] enter_parameters = new int[3];
        int[] correct_parameters = new int[3];


        while (size < n) {
            calculation(n, max_sum, enter_parameters, correct_parameters, matrix, size, sum);
            size++;
        }

        return Arrays.toString(correct_parameters);
    }
    public static int[] calculation (int n, int max_sum, int[] enter_parameters, int[] correct_parameters, int[][] matrix, int size, int sum) {
        for (int x = 0; x + size <= n; x++) {
            for (int y = 0; y + size <= n; y++) {
                max_sum = sum_matrix(max_sum, enter_parameters, correct_parameters, matrix, size, x, y, sum);
            }
        }

        return correct_parameters;
    }

    public static int sum_matrix(int max_sum, int[] enter_parameters, int[] correct_parameters, int[][] matrix, int size, int x, int y, int sum) {
        for (int i = x; i < x + size; i++) {
            if (i == x) {
                enter_parameters[0] = i;
                enter_parameters[1] = y;
                enter_parameters[2] = size;
            }
            for (int z = y; z < y + size; z++) {
                sum += matrix[z][i];
            }
        }
        if (sum >= max_sum) {
            max_sum = sum;
            System.arraycopy(enter_parameters, 0, correct_parameters, 0, 3);
        }
        return max_sum;
    }
}