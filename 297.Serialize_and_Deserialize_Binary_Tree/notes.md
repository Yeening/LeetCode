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
  
