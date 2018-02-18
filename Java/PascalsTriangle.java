/* Leetcode Problem 118.

Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

public class PascalsTriangle {
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
