public class Cyberpunk203xPt5 {
    public static int[] matrix(int n, int m, int[][] matrix) {
        int[] finalMassive = new int[n * m];
        int min;
        if (n >= m) min = n;
        else min = m;

        int f = 0;
        int z = 0;

        for (int x = 0; x < min / 2; x++, z++) {
            if (up(matrix, finalMassive, z, m, n, f) < 0) return finalMassive;
            f = up(matrix, finalMassive, z, m, n, f);
        }
        return finalMassive;

    }

    public static int up(int[][] matrix, int[] finalMassive, int z, int m, int n, int f) {
        for (int i = z; i < n - z; i++, f++) {
            finalMassive[f] = matrix[z][i];
        }
        if (f == finalMassive.length) return -1;
        return right(matrix, finalMassive, z, m, n, f);
    }

    public static int right(int[][] matrix, int[] finalMassive, int z, int m, int n, int f) {
        for (int i = 1 + z; i < m - z; i++, f++) {
            finalMassive[f] = matrix[i][n - 1 - z];
        }
        if (f == finalMassive.length) return -1;
        return down(matrix, finalMassive, z, m, n, f);
    }

    public static int down(int[][] matrix, int[] finalMassive, int z, int m, int n, int f) {
        for (int i = n - 2 - z; i >= z; i--, f++) {
            finalMassive[f] = matrix[m - 1 - z][i];
        }
        if (f == finalMassive.length) return -1;
        return left(matrix, finalMassive, z, m, n, f);
    }

    public static int left(int[][] matrix, int[] finalMassive, int z, int m, int n, int f) {
        for (int i = m - 2 - z; i > 0; i--, f++) {
            finalMassive[f] = matrix[i][z];
        }
        if (f == finalMassive.length) return -1;
        return f;
    }
}

