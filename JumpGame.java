/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.

*/
class Solution {
    public boolean canJump(int[] nums) {
        
        // Greedy approach
        // time O(n) , space O(1)
        int n = nums.length;
        
        int can_reach = 0;
        
        for(int i=0; i<=can_reach; i++){
            if(i == n-1)
                return true;
            
            can_reach = Math.max(can_reach, i + nums[i]);
        }
        
        return false;
        
    }
}
