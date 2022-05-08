/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    
    List<Integer> all;
    int cur = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        all = getAllIntegers(nestedList);
    }

    @Override
    public Integer next() {
        Integer res = null;
        if (cur < all.size()) {
            res = all.get(cur);
            cur++;
        }
        return res;
    }

    @Override
    public boolean hasNext() {
        if (cur >= all.size()) {
            return false;
        }
        return true;
    }
    
    private List<Integer> getAllIntegers(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return new LinkedList<>();
        }
        
        List<Integer> res = new LinkedList<>();
        
        for (NestedInteger i : nestedList) {
            if (i.isInteger()) {
                res.add(i.getInteger());
            } else {
                res.addAll(getAllIntegers(i.getList()));
            }
        }
        
        return res;
    } 
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */