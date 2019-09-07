# N-Queens
## Backtracking-directly check every position
* Strategy
```
  if(this position can put){
    try to put;
    backtrack(next row);
    unput;
  }
```
## Use Flag arrays (Dynamic Programming)

* Use three flag arrays
```
  flag_col[y];
  flag_45[x+y];
  flag_135[n+x-y-1];
```
* Use one flag array   
  45 degree slashes index =n + x + y; 135 degree index = 4*n + x - y - 1
