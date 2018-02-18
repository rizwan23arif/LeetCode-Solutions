/* Leetcode Problem 345.

Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".
*/

public class ReverseVowelsOfaString {
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
