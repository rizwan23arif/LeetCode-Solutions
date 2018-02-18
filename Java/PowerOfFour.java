/* Leetcode Problem 342.

Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?
*/

public class PowerOfFour {
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
