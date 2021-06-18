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

// Pre-load solution
public class NestedIterator implements Iterator<Integer> {
    LinkedList<Integer> list;
    Iterator<Integer> it;
    public NestedIterator(List<NestedInteger> nestedList) {
        list = new LinkedList<>();
        for(int i = 0; i < nestedList.size(); i++) {
            visit(nestedList.get(i));
        }
        it = list.iterator();
    }
    
    private void visit(NestedInteger root) {
        if (root.isInteger()) {
            int i = root.getInteger();
            list.add(i);
        } else {
            for (NestedInteger child: root.getList()) {
                visit(child);
            }
        }
    }

    @Override
    public Integer next() {
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
