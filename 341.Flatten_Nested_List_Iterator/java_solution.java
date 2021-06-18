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

// Lazy-load solution
public class NestedIterator implements Iterator<Integer> {
    LinkedList<NestedInteger> nestedList;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = new LinkedList<>(nestedList);
    }

    @Override
    public Integer next() {
        return nestedList.removeFirst().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!nestedList.isEmpty() && !nestedList.getFirst().isInteger()) {
            List<NestedInteger> firstList = nestedList.pollFirst().getList();
            for (int i = firstList.size() - 1; i >= 0; i--) {
                NestedInteger cur = firstList.get(i);
                if (cur != null){
                    nestedList.addFirst(cur);
                }
            }
        }
        return !nestedList.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
