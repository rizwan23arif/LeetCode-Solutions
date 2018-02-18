/* Leetcode Problem 136.

Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

public class SingleNumber {
    public int singleNumber(int[] nums) {
        Map<Integer, Boolean> map = new HashMap();
        for(int n : nums){
            if(map.containsKey(n)){
                map.put(n,true);
            }
            else
                map.put(n,false);
        }
        for(int n : nums){
            if(map.get(n) == false)
                return n;
        }
        return 0;
    }
}
