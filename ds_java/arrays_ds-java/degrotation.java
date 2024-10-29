/*Given a square matrix mat[][], turn it by 90 degrees in an clockwise direction without using any extra space
Examples: Input: mat[][] = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}}
Output: {{7, 4, 1}, 
        {8, 5, 2}, 
        {9, 6, 3}}  */

import java.util.Arrays;

public class degrotation {
    static void funti(int[][] mat) {
        int n = mat.length;
        int[][] res = new int[n][n];

        int col = 2;// this is brute force
        for (int i = 0; i < n; i++) {
            int row = 0;
            for (int j = 0; j < n; j++) {
                res[row++][col] = mat[i][j];
            }
            col--;

        } /*
           * for (int i = 0; i < n; i++) {
           * for (int j = 0; j < n; j++) {
           * res[j][n - i - 1] = mat[i][j];
           * }
           * } clean way or smart way
           */
        System.out.println(Arrays.deepToString(res));
    }

    public static void main(String[] args) {
        int mat[][] = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        funti(mat);
    }

}
