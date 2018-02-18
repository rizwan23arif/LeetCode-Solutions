/* Leetcode Problem 169.

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/

public class MajorityElement {
    public int majorityElement(int[] nums) {
        
        int major = nums[0]; 
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i : nums){
            int count = map.getOrDefault(i, 0);
            map.put(i, count+1);
            
            if(map.get(i) > nums.length/2){
                major = i;
            }
        }
        return major;
    }
}
