/* LeetCode Question 242.

Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
*/ 

public class ValidAnagram {
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
