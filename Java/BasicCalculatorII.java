/* Leetcode Problem 227.

Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
Note: Do not use the eval built-in library function.
*/

public class BasicCalculatorII {
    public int calculate(String s) {
        
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Character> list2 = new LinkedList<>();
        
        int firstNum = 0;
        int secondNum = 0;
        int result = 0;
        
        for(int i=0; i<s.length(); i++){
            
            if(s.charAt(i) == ' ')
                continue;
            
            if(Character.isDigit(s.charAt(i))){
                firstNum = firstNum * 10 + Character.getNumericValue(s.charAt(i));
                continue;
            }
            
            if(s.charAt(i) == '+' || s.charAt(i) == '-'){
                list1.add(firstNum);
                list2.add(s.charAt(i));
                firstNum = 0;
            }
            
            if(s.charAt(i) == '*' || s.charAt(i) == '/'){
                char operator = s.charAt(i);
                i++;
                
                while(!Character.isDigit(s.charAt(i)))
                    i++;
                    
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    secondNum = secondNum * 10 + Character.getNumericValue(s.charAt(i));
                    i++;
                }
                i--;
                
                if(operator == '*')
                    firstNum = firstNum * secondNum;
                else
                    firstNum = firstNum / secondNum;
                secondNum = 0;
            }
            
        }
        list1.add(firstNum);

        if(list2.size() == 0)
            return list1.poll();
        
        result = list1.poll();
        
        while(list2.size() != 0){
            
            int first = list1.poll();
            char operator = list2.poll();
            
            if(operator == '+')
                result = result + first;
            else
                result = result - first;
        }
        
    return result;
    
    }
}
