# 206.Reverse_Linked_List
* 单链表反转需要使用三个指针，使用第二个指针作为判断条件
* 引入一个指针/引用（根据语言而定）来记录索引指针的next地址
* 考虑head的next问题，先设为NULL
* 可以使用递归算法

## Java 的赋值与参数传递
> https://blog.csdn.net/yz930618/article/details/76278997/   
* 基本类型的赋值，是将值拷贝
### 对象的赋值
```
Solution s1 = new Solution(); //create an object and create a reference that points to the new object
Solution s2 = s1; //create a new reference that points to the object
s2.val = 3;  //change the val of object
s1.val; //3
s2 = new Solution();
s2.val = 5;
s1.val; //3
```
### Parameters passing
* Java has only one way of passing parameters, that is: passing by value
* The situation is the same like assignment
