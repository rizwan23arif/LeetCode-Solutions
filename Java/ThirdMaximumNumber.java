/* Leetcode Question 414.

Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.

Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.

Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.
*/

public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        int max = nums[0];
        for(int i=0; i<nums.length; i++){
            if(nums[i] >= max )
                max = nums[i];
        }
        float max2 = Float.NEGATIVE_INFINITY;
        for(int i=0; i<nums.length; i++){
            if(nums[i] > max2 && nums[i] != max)
                max2 = nums[i];
        }
        float max3 = Float.NEGATIVE_INFINITY;
        for(int i=0; i<nums.length; i++){
            if(nums[i] > max3 && nums[i] != max && nums[i] != max2)
                max3 = nums[i];
        }
        
        if(max3 == Float.NEGATIVE_INFINITY)
            return max;
        else
            return (int)max3;
            
        
    }
}
