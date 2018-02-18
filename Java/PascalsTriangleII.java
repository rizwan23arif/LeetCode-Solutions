/* Leetcode Problem 119.

Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
*/

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
    
        List<Integer> inner = new ArrayList<>();
            
        inner.add(1);
        
        if(rowIndex == 0)
            return inner;
        
        List<Integer> prev = inner;
        
        for(int i=1; i<=rowIndex; i++){
            
            inner = new ArrayList<>();
            inner.add(1);
            
            for(int j=0; j<i-1; j++)
                inner.add(prev.get(j) + prev.get(j+1));
            
            inner.add(1);
            prev = inner;
            
        }
        return inner;
    }
}
