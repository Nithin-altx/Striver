class Solution {
    static final long MOD = 1000000007;
    long[][] matrixMultiply(long[][] a, long[][] b) {
        long[][] c = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    c[i][j] = (c[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }
        return c;
    }

    long[][] matrixExp(long[][] T, int exp) {
        if (exp == 0) {
            long[][] id = { {1, 0}, {0, 1} };
            return id;
        }
        long[][] half = matrixExp(T, exp / 2);
        long[][] res = matrixMultiply(half, half);
        if (exp % 2 == 1) {
            res = matrixMultiply(res, T);
        }
        return res;
    }

    public int nthFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long[][] T = { {1, 1}, {1, 0} };
        long[][] tn = matrixExp(T, n - 1);
        return (int)(tn[0][0] % MOD);
    }
}
