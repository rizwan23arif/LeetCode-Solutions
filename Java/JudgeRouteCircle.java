/* Leetcode Problem 657.

Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.

The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.

Example 1:
Input: "UD"
Output: true
Example 2:
Input: "LL"
Output: false
*/

class JudgeRouteCircle {
    public boolean judgeCircle(String moves) {
        
        int horizontal = 0;
        int vertical = 0;
        
        for(char c: moves.toCharArray()){
            if(c == 'U')
                vertical++;
            else if(c == 'D')
                vertical--;
            else if(c == 'R')
                horizontal++;
            else
                horizontal--;
        }
        
        return (horizontal == 0 && vertical == 0);
    }
}
