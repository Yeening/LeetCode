# Notes
* 使用vector或字典来保存每个字符上一次出现的位置
* Python字典的使用
```
  pos = {}
  if s[i] in pos and start < pos[s[i]]:
                start = pos[s[i]]
            pos[s[i]] = i
```
* Python字符串求长度len(s)
