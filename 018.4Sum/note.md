## 4Sum & kSum
# Basic method:
  reduce kSum to 2 Sum, use two pointers to solute
# Note
* Arrays.asList() return to a fixed length List, do not suppport add and remove   
  [Java从入门到放弃：慎用 Arrays.asList(T... a)](https://www.imooc.com/article/24186)   
  1. 该方法适用于对象型数据的数组（String、Integer...）
  2. 该方法不建议使用于基本数据类型的数组（byte,short,int,long,float,double,boolean）
  3. 该方法将数组与List列表链接起来：当更新其一个时，另一个自动更新
  4. 不支持add()、remove()、clear()等方法
* java static member and function   
  [java static member and function](https://www.cnblogs.com/sunada2005/p/10882158.html)
* ListObj.addAll(AnotherListObj) can add AnotherListObj at the end of a ListObj
