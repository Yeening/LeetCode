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
## Java length,size
```
List<Integer> a = new LinkedList<>();
a.size();
String s = new String("abc");
s.length();
int[] nums = [1, 2, 3]
nums.length;
```
