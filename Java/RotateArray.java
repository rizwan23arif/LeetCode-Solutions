/* Leetcode Problem 189.

Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

Related problem: Reverse Words in a String II
*/

public class RotateArray {
    public void rotate(int[] nums, int k) {
            
        nums = reverse(nums, 0, nums.length-1);
        nums = reverse(nums, 0, k%nums.length-1);
        nums = reverse(nums, k%nums.length, nums.length-1);
    
    }
    public int[] reverse(int[] array, int start, int end){
        
        if(array.length == 0)
            return array;
            
        int first = start;
        int last = end;
        
        while(first < last){
            
            int temp = array[first];
            array[first] = array[last];
            array[last] = temp;
            
            first++;
            last--;
        }
        
        return array;
    }
}
