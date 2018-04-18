# notes
## C++ swap() 函数
```
template<class T>
void swap(T &a,T &b)
{
    T c(a);
    a=b;
    b=c;
}
```
eg:  
```
vector<int> a(10);
swap(a[0],a[1]);
```
