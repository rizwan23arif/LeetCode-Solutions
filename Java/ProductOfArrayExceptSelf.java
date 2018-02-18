/* Leetcode Problem 238.

Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of 
nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space 
complexity analysis.)
*/

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        
        int[] a = new int[nums.length];
        int[] b = new int[nums.length];
        
        a[0] = 1;
        b[nums.length-1] = 1;
        
        for(int i=1; i<nums.length; i++)
            a[i] = nums[i-1] * a[i-1];
            
        for(int i=nums.length-2; i>=0; i--)
            b[i] = nums[i+1] * b[i+1];
            
        for(int i=0; i<nums.length; i++)    
            nums[i] = a[i] * b[i];
            
        return nums;
    }
}
