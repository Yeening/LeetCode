# notes
## C++ sort的使用
头文件：<algorithm>
1. sort函数可以三个参数也可以两个参数，必须的头文件#include < algorithm>和using namespace std; 
2. 它使用的排序方法是类似于快排的方法，时间复杂度为n*log2(n)

3. Sort函数有三个参数：（第三个参数可不写）

   (1)第一个是要排序的数组的起始地址。

   (2)第二个是结束的地址（最后一位要排序的地址）

   (3)第三个参数是排序的方法，可以是从大到小也可是从小到大，还可以不写第三个参数，此时默认的排序方法是从小到大排序。
4. 可以对数组、向量、字符串等顺序存储排序
### 两个参数用法
```
#include <iostream>
#include <algorithm>
int main()
{
 int a[20]={2,4,1,23,5,76,0,43,24,65},i;
 sort(a,a+20);
 for(i=0;i<20;i++)
 cout<<a[i]<<endl;
 return 0;
}
```
### 三个参数
```
bool myfunction (int i,int j) { return (i<j); }//升序排列
bool myfunction2 (int i,int j) { return (i>j); }//降序排列
```
