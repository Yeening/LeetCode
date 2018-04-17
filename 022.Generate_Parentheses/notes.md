# notes
## 解决括号问题的两种思路（递归）
1. 记录剩余的左括号数和需要添加的右括号数
```
    void adding(vector<string> &res, string s, int left_remain, int right_toadd){
        if(left_remain==0 && right_toadd ==0){
            res.push_back(s);
        }
        if(left_remain > 0){ adding(res, s+"(", left_remain-1, right_toadd+1);}
        if(right_toadd > 0){ adding(res, s+")", left_remain, right_toadd-1);}
    }
```
2. 记录剩余的左右括号数
```
    void adding(vector<string> &res, string s, int left, int right){
        if(left==0 && right ==0){
            res.push_back(s);
        }
        if(left > 0){ adding(res, s+"(", left-1, right);}
        if(right > left){ adding(res, s+")", left, right-1);}
    }
```
