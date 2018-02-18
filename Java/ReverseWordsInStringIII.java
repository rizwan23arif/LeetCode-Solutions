/* Leetcode Problem 557.

Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial 
word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.
*/

public class ReverseWordsInStringIII {
    public String reverseWords(String s) {
        
        StringBuilder sb = new StringBuilder();
        int index=-1;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ' ' || i == s.length()-1){
                if(s.charAt(i) == ' ')
                    index = i-1;
                else
                    index = i;
                while(index != -1 && s.charAt(index) != ' '){
                    sb.append(s.charAt(index));
                    index--;
                }
            }
            if(s.charAt(i) == ' ')
                sb.append(' ');
        }
        return sb.toString();
    }
}
