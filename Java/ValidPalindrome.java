/* LeetCode Question 125.

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.
For the purpose of this problem, we define empty string as valid palindrome.
*/

public class ValidPalindrome {
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
