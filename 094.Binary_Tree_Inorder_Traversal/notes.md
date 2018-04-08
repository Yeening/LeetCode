# notes
## C++ vector的拼接（使用insert方法）
```
right.insert(right.begin(),left.begin(),left.end());  //将left拼到right的前面
left.insert(left.end(),right.begin(),right.end());    //right连接到left后面
```
