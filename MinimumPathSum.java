/*

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.

*/

class Solution {
    public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        int minSum[][] = new int[m][n];
        
        if(grid == null || m==0)
            return 0;
        
        minSum[0][0]=grid[0][0];
        
        for(int i=1; i<m; i++){
            minSum[i][0] = grid[i][0] + minSum[i-1][0];
        }
        
        for(int j=1; j<n; j++){
            minSum[0][j] = grid[0][j] + minSum[0][j-1];
        }
        
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                minSum[i][j] = grid[i][j] + Math.min(minSum[i-1][j], minSum[i][j-1]);
            }
        }
        
        return minSum[m-1][n-1];
            
    }
}
