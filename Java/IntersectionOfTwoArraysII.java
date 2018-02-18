/* Leetcode Problem 350.

Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.

Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
*/

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i: nums1){
            if(map.containsKey(i)){
                int count = map.get(i);
                map.put(i,count+1);
            }
            else
                map.put(i,1);
        }
        
        for(int i: nums2){
            if(map.containsKey(i)){
                int count = map.get(i);
                if(count > 0)
                    list.add(i);
                map.put(i,count-1);
            }
        }
        
        int[] array = new int[list.size()];
        int j=0;
        for(int i: list)
            array[j++] = i;
            
        return array;
    }
}
