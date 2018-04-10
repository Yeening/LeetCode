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
## Python sorted() 函数
sorted() 函数对所有可迭代的对象进行排序操作。

sort 与 sorted 区别：

sort 是应用在 list 上的方法，sorted 可以对所有可迭代的对象进行排序操作。

list 的 sort 方法返回的是对已经存在的列表进行操作，而内建函数 sorted 方法返回的是一个新的 list，而不是在原来的基础上进行的操作。
```
>>>a = [5,7,6,3,4,1,2]
>>> b = sorted(a)       # 保留原列表
>>> a 
[5, 7, 6, 3, 4, 1, 2]
>>> b
[1, 2, 3, 4, 5, 6, 7]
 
>>> L=[('b',2),('a',1),('c',3),('d',4)]
>>> sorted(L, cmp=lambda x,y:cmp(x[1],y[1]))   # 利用cmp函数
[('a', 1), ('b', 2), ('c', 3), ('d', 4)]
>>> sorted(L, key=lambda x:x[1])               # 利用key
[('a', 1), ('b', 2), ('c', 3), ('d', 4)]
 
 
>>> students = [('john', 'A', 15), ('jane', 'B', 12), ('dave', 'B', 10)]
>>> sorted(students, key=lambda s: s[2])            # 按年龄排序
[('dave', 'B', 10), ('jane', 'B', 12), ('john', 'A', 15)]
 
>>> sorted(students, key=lambda s: s[2], reverse=True)       # 按降序
[('john', 'A', 15), ('jane', 'B', 12), ('dave', 'B', 10)]
```
## [Python 字典](http://www.runoob.com/python/python-dictionary.html)
* [get方法](http://www.runoob.com/python/att-dictionary-get.html)  
     Python 字典(Dictionary) get() 函数返回指定键的值，如果值不在字典中返回默认值。
   ```
   dict = {'Name': 'Zara', 'Age': 27}
   print "Value : %s" %  dict.get('Age')
   >>> Value: 27
   print "Value : %s" %  dict.get('Sex', "Never")
   >>> Value: Never
   ```
* 值可以取任何数据类型，但键必须是不可变的，如字符串，数字或元组(tuple)。
