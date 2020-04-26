/*

Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.

*/

class Solution {
    public void moveZeroes(int[] nums) {
        
        int n = nums.length;
      /*  int index = -1;        
        
        for(int i=0; i<n-1; i++){
            if(nums[i] != 0)
                continue;
            
            int j=i+1;
            
            while(j<n-1 && nums[j]==0)
                j++;
            
            nums[i] = nums[j];
            nums[j] = 0;            
        }
        */
        
        int i = 0;
        for(int num : nums){
            if(num!=0){
                nums[i++] = num;
            }
        }
        
        while(i!=n){
            nums[i++] = 0;
        }
    }
}
