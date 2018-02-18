/* Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

public class ValidParentheses {
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
