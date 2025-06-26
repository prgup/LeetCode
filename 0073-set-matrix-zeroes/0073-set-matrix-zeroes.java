class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagR = false, flagC=false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0)
                        flagR = true;
                    if (j==0)
                    flagC=true;
                    matrix[i][0] =0 ;
                    matrix[0][j] =  0;
                }
            }
        }
        // System.out.println(flagC+" "+flagR);
        // System.out.println(Arrays.deepToString(matrix));
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0 ) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        //  System.out.println(Arrays.deepToString(matrix));
        for (int i=1; i<n; i++){
            if (matrix[0][i] == 0  ) {
                for (int j = 1; j < m; j++) {
                    matrix[j][i] = 0;
                }

            }
            if (flagR )
            matrix[0][i]=0;
        }
        //  System.out.println(Arrays.deepToString(matrix));

        for (int i=0; i<m; i++){
            if (flagC)
            matrix[i][0]=0;

        }
        //  System.out.println(Arrays.deepToString(matrix));

        return;

    }
}