/*

Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)

*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n =nums.length;
        int[] left_prod = new int[n];
        int[] right_prod = new int[n];
        int[] output_arr = new int[n];
        
        left_prod[0] = 1;
        right_prod[n-1] = 1;
        
        for(int i=1; i<n; i++){
            left_prod[i] = nums[i-1] * left_prod[i-1];
        }
        
        for(int i=n-2; i>=0; i--){
            right_prod[i] = nums[i+1] * right_prod[i+1];
        }
        
        for(int i=0; i<n; i++){
            output_arr[i] = left_prod[i] * right_prod[i];
        }
        
        return output_arr;
    }
}

class Solution {
    public int[] productExceptSelf(int[] nums) {

        // The length of the input array 
        int length = nums.length;

        // Final answer array to be returned
        int[] answer = new int[length];

        // answer[i] contains the product of all the elements to the left
        // Note: for the element at index '0', there are no elements to the left,
        // so the answer[0] would be 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {

            // answer[i - 1] already contains the product of elements to the left of 'i - 1'
            // Simply multiplying it with nums[i - 1] would give the product of all 
            // elements to the left of index 'i'
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        // R contains the product of all the elements to the right
        // Note: for the element at index 'length - 1', there are no elements to the right,
        // so the R would be 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {

            // For the index 'i', R would contain the 
            // product of all elements to the right. We update R accordingly
            answer[i] = answer[i] * R;
            R *= nums[i];
        }

        return answer;
    }
}
