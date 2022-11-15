class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat[0].length * mat.length != r * c)
            return mat;

        int[][] returnMat = new int[r][c];

        int row = 0;
        int col = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                returnMat[i][j] = mat[row][col++];
                if (col == mat[0].length) {
                    col = 0;
                    row++;
                }
            }
        }

        return returnMat;
    }
}