/*

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4

*/

class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int row = matrix.length, col = row > 0 ? matrix[0].length : 0;
                
        int dp[] = new int[col+1];
        int prev = 0;
        int maxSq = 0;
        
        for(int i=1; i<=row; i++){
            for(int j=1; j<=col; j++){
                int temp = dp[j];
                
                if(matrix[i-1][j-1] == '1'){
                    dp[j] = Math.min(Math.min(dp[j-1], prev), dp[j]) + 1;
                    maxSq = Math.max(maxSq, dp[j]);
                }else{
                    dp[j]=0;
                }
                prev = temp;                
            }
        }
        
        return maxSq * maxSq;
    }
}


public class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxsqlen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }
