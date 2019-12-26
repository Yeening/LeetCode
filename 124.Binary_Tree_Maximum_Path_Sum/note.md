* for each node, it can be: 
  1. on a branch that goes down. 
  2. a root that has two branches goes down.
* update the maxValue with current.val + left + right
* return the value that the current node acts as a branch, current.val + max(left, right)
