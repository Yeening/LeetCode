# 39 Combination
## Java
* [Java Scanner](http://www.runoob.com/java/java-scanner-class.html)
* [Java ArrayList VS C++ vector](https://blog.csdn.net/xiamentingtao/article/details/52748884)
* Java int to string/ string to int
  * int -> String  
    ```
    int i=12345;
    String s="";
    //First way
    s = i + ""
    //*Second way(faster)
    s=String.valueOf(i);
    ```
  * String -> int  
    ```
    //*First way 
    i = Integer.parseInt(s);
    //Second way
    i = Integer.valueOf(s).intValue();
    ```
* Java Array&ArrayList sort
  ```
  int[] candidates = {3, 2, 7, 6};
  Arrays.sort(candidates);
  //{2, 3, 6, 7}
  Arrays.sort(candidates，Collections.reverseOrder());
  //{7, 6, 3, 2}
  List<Integer> list = new ArrayList<Integer>();
  Collections.sort(list);
  ```
