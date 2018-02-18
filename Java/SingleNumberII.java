/* Leetcode Problem 137.

Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for(int n : nums){
            if(map.containsKey(n)){
                int count = map.get(n);
                map.put(n,count+1);
            }
            else
                map.put(n,1);
        }
        for(int n : nums){
            if(map.get(n) == 1)
                return n;
        }
        return 0;
    }
}
