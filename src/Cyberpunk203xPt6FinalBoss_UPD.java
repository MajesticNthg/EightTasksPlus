import java.util.Arrays;

public class Cyberpunk203xPt6FinalBoss_UPD {
    public static String army_communication_matrix(int n, int[][] matrix) {
        int max_sum = 0;
        int sum = 0;
        int size = 2;
        int[] enter_parameters = new int[3];
        int[] correct_parameters = new int[3];
        int[][] subMatrix = new int[matrix.length + 1][matrix[0].length + 1];
        create_subMatrix(matrix, subMatrix);

        while (size < n) {
            calculation(n, max_sum, enter_parameters, correct_parameters, subMatrix, size, sum);
            size++;
        }

        return Arrays.toString(correct_parameters);
    }
    public static int[][] create_subMatrix (int[][] matrix, int[][] subMatrix) {
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[0].length; y++) {
                if (y == 0) {
                    subMatrix[x + 1][y + 1] = matrix[x][y] + subMatrix[x][y + 1];
                }
                else {
                    subMatrix[x + 1][y + 1] = matrix[x][y] + subMatrix[x + 1][y] + subMatrix[x][y + 1] - subMatrix[x][y];
                }
            }
        }

        return subMatrix;
    }
    public static int sum_subMatrix (int max_sum, int[] enter_parameters, int[] correct_parameters, int[][] subMatrix, int size, int x, int y, int sum) {
        enter_parameters[0] = x;
        enter_parameters[1] = y;
        enter_parameters[2] = size;
        sum += subMatrix[y][x] + subMatrix[y + size][x + size] - subMatrix[y + size][x] - subMatrix[y][x + size];
        if (sum >= max_sum) {
        max_sum = sum;
        System.arraycopy(enter_parameters, 0, correct_parameters, 0, 3);
    }
        return max_sum;
    }
    public static int[] calculation (int n, int max_sum, int[] enter_parameters, int[] correct_parameters, int[][] subMatrix, int size, int sum) {
        for (int x = 0; x + size <= n; x++) {
            for (int y = 0; y + size <= n; y++) {
                max_sum = sum_subMatrix(max_sum, enter_parameters, correct_parameters, subMatrix, size, x, y, sum);
            }
        }

        return correct_parameters;
    }
}
