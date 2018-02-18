/* Leetcode Problem 347.

Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for(int i : nums){
            int count = map.getOrDefault(i, 0);
            map.put(i, count+1);
        }
        
        TreeMap<Integer, List<Integer>> tree = new TreeMap<>();
        for(int i : map.keySet()){
            int index = map.get(i);
            List<Integer> list = tree.get(index);
            if(list == null)
                list = new ArrayList<>();
            list.add(i);
            tree.put(index, list);
        }
        
        int i=0;
        while(i<k){
            int highestCount = tree.lastKey();
            List<Integer> retrieve = tree.get(highestCount);
            for(int j : retrieve){
                result.add(j);
                i++;
            }
            tree.remove(highestCount);
        }
        return result;
    }
}
