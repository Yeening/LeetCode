# Two ways to solve Valid Parentheses Problem
* use stack to find unvalid parentheses, calculate the longest substring
* use dp
  l[i] stands for the longest valid parentheses that ends at i   
  l[i] is:
  1. 0 when s[i] == '('
  2. 2 + l[i-1] when s[i-1] is '('
  3. l[i-1] + 2 + l[i - l[i-1] - 2] for example:   
  for string s: "()(())", l[5] is l[4](which is 2) + 2 + l[1](which is 2), that is 2 + 2 + 2 =6   

In this case, dp is much faster than stack
