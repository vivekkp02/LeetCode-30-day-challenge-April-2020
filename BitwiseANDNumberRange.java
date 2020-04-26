/*

  Bitwise AND of Numbers Range
Solution
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

Example 1:

Input: [5,7]
Output: 4
Example 2:

Input: [0,1]
Output: 0

*/

class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        
        int answer=0;
        
        for(int bit=30; bit>=0; bit--){
            
            if((m & (1 << bit)) != (n & (1 << bit))){
                break;
            }else{
                answer |= (m & (1 << bit));
            }
        }
        
        return answer;
    }
}
