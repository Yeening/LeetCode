# 136 Single Number
## 1. Bit Manipulation -- XOR
### Concept

* If we take XOR of zero and some bit, it will return that bit  
  * a⊕0=a  
* If we take XOR of two same bits, it will return 0
  * a⊕a=0  
* a⊕b⊕a=(a⊕a)⊕b=0⊕b=b  
So we can XOR all bits together to find the unique number.  
* XOR in C/C++
 ```
 int res;
 res ^= nums[i];
 ```
## 2. Math
### Concept
* 2∗(a+b+c)−(a+a+b+b+c)=c
* [C++ sum of STL](Notes_Cpp/STL/algorithm.md)
