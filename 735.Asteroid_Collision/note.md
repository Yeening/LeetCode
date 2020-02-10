* For each positive number, add to stack.
* For negative numbers:
  * poll the positive numbers in the stack if they are smaller than current
  * destroy the current and peek number if the peek is the opposite number of current
  * add current to stack if there are not positive numbers in the peek
* Turn the stack to result.
* Java Stream to transfer LinkedList to array
```
LinkedList<Integer> l = new LinkedList<>();
int[] arr = l.stream().mapToInt(i->i).toArray();
```
