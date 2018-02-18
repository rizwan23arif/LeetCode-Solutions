/* Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

public class WordSearch {
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
