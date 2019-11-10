* Maintain a prefix variable.
* When the distinct numbers are larger than K, eliminate extra distince numbers in the left, set prefix to 0.
* When the distinct numbers equals to K, eliminate duplicate numbers in the left, add prefix.
* res += (1+pre_fix)
* [1, 2, 1, 2, 3], K = 3  =>  prefix = 2, add two times (2+1) 
