# Notes 
## 单链表使用头结点和头指针来保持代码一致性
   有时在单链表的第一个结点之前附设一个结点，称之为头结点。 
头结点的数据域可以不存储任何信息，也可以存储如线性表长度等类的附加信息，头结点的指针域存储指向第一个结点的指针（即第一个元素结点的存储位置）
## C++条件运算符
   `Condition ? X : Y`  
   如果 Condition 为真 ? 则值为 X : 否则值为 Y。
## Python条件运算符
   `value_when_true if condition else value_when_false`

## Python 类的实例的初始化，Python一切都是引用
```
   head_node = ListNode(0)
   head = head_node   #表示head成为head_node的引用
```
