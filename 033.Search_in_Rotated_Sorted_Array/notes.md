# Binary Search
## 伪代码
循环实现：
```
Iterative-Binary-Search(seq, v, low, high)
    while low <= high
        mid = (low + high) / 2
        if v == seq[mid]
            return mid
        elseif v > seq[mid]
            low = mid + 1
        else
            high = mid - 1
    return NIL
 ```
 递归实现：
 ```
 Recursive-Binary-Search(seq, v, low, high)
    if low > high
        return NIL
    mid = (low + high) / 2
    if v == seq[mid]
        return mid
    elseif v > seq[mid]
        return Recursive-Binary-Search(seq,v,mid+1,high)
    else
        return Recursive-Binary-Search(seq,v,low,mid-1)
 ```
