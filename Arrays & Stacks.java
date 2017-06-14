1. *** 79. WORD SEARCH ***

public class Solution {
    public boolean exist(char[][] board, String word) {
        
        char[] w = word.toCharArray();
        
        for(int y=0; y<board.length; y++){
            for(int x=0; x<board[y].length; x++){
                if(helper(board, w, y, x, 0))
                    return true;
            }
        }
        return false;
    }
    
    public boolean helper(char[][] board, char[] word, int y, int x, int i){
        
        if(i == word.length)
            return true;
            
        if(y<0 || x<0 || y==board.length || x==board[y].length)
            return false;
            
        if(board[y][x] != word[i])
            return false;
            
        board[y][x] = 0;
            
        boolean result = helper(board, word, y+1, x, i+1) ||
                         helper(board, word, y-1, x, i+1) ||
                         helper(board, word, y, x+1, i+1) ||
                         helper(board, word, y, x-1, i+1);
            
        board[y][x] = word[i];
        return result;
        
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
2. *** 20. Valid Parentheses ***
EXPLANATION: Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid

public class Solution {
    public boolean isValid(String s) {
        
        if (s.length() == 0)
            return true;
            
        Stack<Character> stack = new Stack<>();
            
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == '(')
                stack.push(')');
            else if (s.charAt(i) == '{')
                stack.push('}');
            else if (s.charAt(i) == '[')
                stack.push(']');
            else if (!stack.empty() && s.charAt(i) == stack.peek())
                stack.pop();
            else
                return false;
        }
        
        return stack.empty();
        
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
3. *** 125. Valid Palindrome ***

public class Solution {
    public boolean isPalindrome(String s) {
        
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        
        if(s.isEmpty())
            return true;
        
        for(int i=0; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i)) || Character.isLetter(s.charAt(i)))
                sb.append(s.charAt(i));
        }
        
        int i=0;
        int j=sb.length()-1;
        
        while(i<j){
            if(sb.charAt(i) != sb.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}

4. *** 242. Valid Anagram ***
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
public class Solution {
    public boolean isAnagram(String s, String t) {
        
        Map<Character, Integer> map = new HashMap<>();
        
        if(s.length() != t.length())
            return false;
        if(s.length() == 0 && t.length() == 0)
            return true;
        
        for(char c: s.toCharArray()){
            if(map.containsKey(c)){
                int count = map.get(c);
                map.put(c, count+1);
            }
            else
                map.put(c, 1);
            
        }
        
        for(char c: t.toCharArray()){
            if(map.containsKey(c)){
                int count = map.get(c);
                if(count == 0)
                    return false;
                map.put(c, count-1);
            }
            else
                return false;
        }
        return true;
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
5. *** 1. Two Sum ***

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map <Integer, Integer> map = new HashMap();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                result[0] = map.get(target - nums[i]);
                result[1] = i;
            }
            else
                map.put(nums[i],i);
        }
        return result;
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
6. *** 414. Third Maximum Number ***

public class Solution {
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
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
7. *** 136. Single Number ***
EXPLANATION: Given an array of integers, every element appears twice except for one. Find that single one.

public class Solution {
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
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
8. *** 137. Single Number II ***
EXPLANATION: Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

public class Solution {
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
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
9. *** 35. Search Insert Position ***
EXPLANATION: Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int i=0;
        while(i<nums.length && nums[i] <= target){
            if(target == nums[i])
                return i;
            i++;
        }
        return i;
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
10. *** 48. Rotate Image ***
EXPLANATION: Transpose the Matrix by 90 clockwise

public class Solution {
    public void rotate(int[][] matrix) {
        
        for(int i=0; i<matrix.length/2; i++){
            for(int j=0; j<matrix.length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length-i-1][j];
                matrix[matrix.length-i-1][j] = temp;
            }
        }
        
        for(int i=0; i<matrix.length; i++){
            for(int j=i; j<matrix.length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
11. *** 189. Rotate Array ***
EXPLANATION: Rotate an array of n elements to the right by k steps.
             For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
			 
public class Solution {
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
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
12. *** 345. Reverse Vowels of a String ***

public class Solution {
    public String reverseVowels(String s) {
        StringBuilder vowel = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = Character.toLowerCase(s.charAt(i));
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
                vowel.append(s.charAt(i));
        }
        int v = vowel.length();
        for(int i=0; i<s.length(); i++){
            char c = Character.toLowerCase(s.charAt(i));
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
                result.append(vowel.charAt(v-1));
                v--;
            }
            else
                result.append(s.charAt(i));
        }
        return result.toString();
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
13. *** 27. Remove Element ***
EXPLANATION: Given an array and a value, remove all instances of that value in place and return the new length.

public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0)
            return 0;
        int j=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != val)
                nums[j++] = nums[i];
        }
        return j;
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
14. *** 26. Remove Duplicates from Sorted Array ***

public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0)
            return 0;
        int length = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] == nums[i-1])
                continue;
            else{
                 nums[length]=nums[i];
                 length++;
            }
        }
        return length;
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
15. *** 383. Ransom Note ***
EXPLANATION: Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the             ransom note can be constructed from the magazines ; otherwise, it will return false.

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        int[] array = new int[256];
        
        for(int i=0; i<magazine.length(); i++)
            array[magazine.charAt(i)]++;
        
        for(int i=0; i<ransomNote.length(); i++){
            array[ransomNote.charAt(i)]--;
            
            if(array[ransomNote.charAt(i)] < 0)
                return false;
        }
        return true;
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
16. *** 342. Power of Four ***

public class Solution {
    public boolean isPowerOfFour(int num) {
        if(num == 1)
            return true;
        while(num >= 4 && num % 4 == 0){
            if(num / 4 == 1)
                return true;
            num = num / 4;
        }
        return false;
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
17. *** 118. Pascal's Triangle ***

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        
        if(numRows == 0)
            return list;
            
        inner.add(1);
        list.add(inner);
        
        for(int i=1; i<numRows; i++){
            
            inner = new ArrayList<>();
            inner.add(1);
            List<Integer> prev = new ArrayList<>();
            prev = list.get(i-1);
            
            for(int j=0; j<i-1; j++)
                inner.add(prev.get(j) + prev.get(j+1));
                
            inner.add(1);
            list.add(inner);
        }
        return list;
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
18. *** 119. Pascal's Triangle II ***
EXPLANATION: Given an index k, return the kth row of the Pascal's triangle.

public class Solution {
    public List<Integer> getRow(int rowIndex) {
    
        List<Integer> inner = new ArrayList<>();
            
        inner.add(1);
        
        if(rowIndex == 0)
            return inner;
        
        List<Integer> prev = inner;
        
        for(int i=1; i<=rowIndex; i++){
            
            inner = new ArrayList<>();
            inner.add(1);
            
            for(int j=0; j<i-1; j++)
                inner.add(prev.get(j) + prev.get(j+1));
            
            inner.add(1);
            prev = inner;
            
        }
        return inner;
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
19. *** 496. Next Greater Element I ***
EXPLANATION: You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for             nums1's elements in the corresponding places of nums2.
             The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.

public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        if(findNums.length == 0)
            return findNums;
        
        for(int i=0; i<nums.length; i++){
            if(i==0 || nums[i] < nums[i-1]){
                stack.push(nums[i]);
            }
            else {
                while(!stack.isEmpty() && stack.peek() < nums[i]){
                    map.put(stack.pop(),nums[i]);
                }
                stack.push(nums[i]);
            }
        }
        
        for(int i=0; i<findNums.length; i++){
            if(map.containsKey(findNums[i]))
                findNums[i] = map.get(findNums[i]);
            else
                findNums[i] = -1;
        }
        return findNums;
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
20. *** 283. Move Zeroes ***
EXPLANATION: Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

public class Solution {
    public void moveZeroes(int[] nums) {
        int j=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0)
                nums[j++] = nums[i];
        }
        for(; j<nums.length; j++) 
            nums[j] = 0;
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
21. *** 485. Max Consecutive Ones ***
EXPLANATION: Given a binary array, find the maximum number of consecutive 1s in this array.

public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1)
                count++;
            else{
                if(count > maxCount)
                    maxCount = count;
                count = 0;
            }
            if(count > maxCount)
                maxCount = count;
        }
        return maxCount;
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
22. *** 205. Isomorphic Strings ***
EXPLANATION: Two strings are isomorphic if the characters in s can be replaced to get t.

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            if(map1.containsKey(s.charAt(i))){
                if(map1.get(s.charAt(i)) != t.charAt(i))
                    return false;
            }
            else
                map1.put(s.charAt(i), t.charAt(i));
           
            if(map2.containsKey(t.charAt(i))){
                if(map2.get(t.charAt(i)) != s.charAt(i))
                    return false;
            }
            else
                map2.put(t.charAt(i), s.charAt(i));
            
        }
        return true;
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
23. *** 350. Intersection of Two Arrays II ***
EXPLANATION: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

public class Solution {
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
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
24. *** 461. Hamming Distance ***

public class Solution {
    public int hammingDistance(int x, int y) {
        int greatest = Math.max(x,y);
        int distance = 0;
        while(greatest != 0){
            if(x%2 != y%2)
                distance++;
            x = x/2;
            y= y/2;
            greatest = Math.max(x,y);
        }
        return distance;
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
25. *** 448. Find All Numbers Disappeared in an Array ***
EXPLANATION: Find all the elements of [1, n] inclusive that do not appear in this array.

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++)
            set.add(nums[i]);
            
        for(int i=0; i<nums.length; i++){
            if(!set.contains(i+1))
                list.add(i+1);
        }
        return list;
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
26. *** 11. Container With Most Water ***
EXPLANATION: Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two             endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the             most water.

public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea =  0;
        while(left < right){
            int area = Math.min(height[left], height[right]) * (right - left);
            if(height[left] < height[right])
                left++;
            else
                right--;
            if(area > maxArea)
                maxArea = area;
        }
        return maxArea;
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
