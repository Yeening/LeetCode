# 297. Serialize and Deserialize Binary Tree
## Notes
* Using of stringstream
  [C++整形、字符串互转](https://github.com/Eclear/Notes_Cpp/blob/master/String/convert_between_int_and_string.md)
* Recursive preorder traversal
* python 函数的嵌套：
```
    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        def doit(root):
            if root == None:
                vals.append("#")
            else:
                vals.append(str(root.val))
                doit(root.left)
                doit(root.right)
        vals = []
        doit(root)
        return ' '.join(vals)
  ```
* python iter：指向可迭代的集合，next（iter对象）表示从集合中取出下一个元素
```
    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        def doit():
            val = next(it)
            if val == "#":
                return None
            node = TreeNode(int(val))
            node.left = doit()
            node.right = doit()
            return node
        it = iter(data.split())
        return doit()
```
* python参数传递方式：
  python不允许程序员选择采用传值还是传引用。Python参数传递采用的肯定是“传对象引用”的方式。这种方式相当于传值和传引用的一种综合。如果函数收到的是一个可变对象（比如字典或者列表）的引用，就能修改对象的原始值－－相当于通过“传引用”来传递对象。如果函数收到的是一个不可变对象（比如数字、字符或者元组）的引用，就不能直接修改原始对象－－相当于通过“传值'来传递对象。
* Python join 方法：
  * Python join() 方法用于将序列中的元素以指定的字符连接生成一个新的字符串。
  * str.join(sequence)  
    * sequence -- 要连接的元素序列。  
  * 例：
  
```
  str = "-"
  seq = ("a", "b", "c")  # 字符串序列
  print str.join( seq )
```

* Python split 方法:
  * Python split()通过指定分隔符对字符串进行切片，如果参数num 有指定值，则仅分隔 num 个子字符串
  * str.split(str="", num=string.count(str))  
    * str -- 分隔符，默认为所有的空字符，包括空格、换行(\n)、制表符(\t)等。  
    * num -- 分割次数。  
  * 例：
  
```
  str = "Line1-abcdef \nLine2-abc \nLine4-abcd";
  print str.split( );               #['Line1-abcdef', 'Line2-abc', 'Line4-abcd']
  print str.split(' ', 1 );         #['Line1-abcdef', '\nLine2-abc \nLine4-abcd']
```
