# Note of Java

## Different Type of Size
```Java
// Array
String[] s = new String[5];
s.length;
// String
String str = new String("Abc");
str.length();
// List
List<Integer> l = new ArrayList<>();
l.size();
```

## ArrayList and LinkedList
* Construct form other collection
```Java
// ArrayList
ArrayList<Integer> al = new ArrayList<>(collection);
ArrayList<Integer> al1 = Arrays.asList(arr);
// LinkedList
LinkedList<Integer> ll = new LinkedList<>();
ll.addAll(Arrays.asList(arr));
```
## == vs. String.equals()
== compares the adress in memory while String.equals() compares the String value
```Java
s.equals("ABC");
```
## Split() String
### String [ ] split ( String regex, int limit )
```Java
/* limit > 0 : If this is the case then the pattern will be
             applied at most limit-1 times, the resulting 
             array’s length will not be more than n, and 
             the resulting array’s last entry will contain
             all input beyond the last matched pattern.
 limit < 0 : In this case, the pattern will be applied as
             many times as possible, and the resulting 
             array can be of any size.
 limit = 0 : In this case, the pattern will be applied as 
             many times as possible, the resulting array can 
             be of any size, and trailing empty strings will
             be discarded.*/
String[] arrOfStr = str.split("@", 2);
```
### public String[] split(String regex)
[Reference](https://blog.csdn.net/shenzhennba/article/details/8086110)
```Java
String str = "GeeksforGeeks:A Computer Science Portal"; 
String[] arrOfStr = str.split(":"); 
```
## Converting between String, Int, and char[]
```Java
//String to int
String number = "10";
int result = Integer.parseInt(number);
//String to Integer
String number = "10";
Integer result = Integer.valueOf(number);	
//Int to String
String s = String.valueOf(5);
//String to char[]
char[] gfg = s.toCharArray();
//char[] to String
char[] ca = new char[]{'a','b'};
//Method1: use String constructor
String s1 = new String(ca)
//Method2: use String.valueOf()
String s2 = String.valueOf(ca);
```
## Hash data sets
* [HashSet](https://docs.oracle.com/javase/7/docs/api/java/util/HashSet.html)
* [HashMap](https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html)
* [HashTable](https://docs.oracle.com/javase/8/docs/api/java/util/Hashtable.html)
* [Difference between HashMap and HashTable](https://www.geeksforgeeks.org/differences-between-hashmap-and-hashtable-in-java/)

## System.arraycopy()
* [TutorialsPoint](https://www.tutorialspoint.com/java/lang/system_arraycopy.html)
```
//Source: arr1, Source From:0, Target: arr2, Target from: 0, length: 1
System.arraycopy(arr1, 0, arr2, 0, 1);
```

## Arrays.copyOfRange(arr, i, i+k)
* Arrays.copyOfRange(arr, i, i+k), return a copied array

## Arrays.copyOf(arr, i)
* Arrays.copyOfRange(arr, i), return a copied array from 0 to i [0,i)

## Array of List
```
//initializing array of list
List<Integer>[] buckets = new List[nums.length+1];
```

## Java Stream to transfer LinkedList to array
```
LinkedList<Integer> l = new LinkedList<>();
int[] arr = l.stream().mapToInt(i->i).toArray();
```
## Map.Entry
```
for(Map.Entry<String, Integer> entry: map.entrySet()){
    min_heap.offer(entry);
    if(min_heap.size()>k) min_heap.poll();
}
List<String> res = new LinkedList<>();
while(!min_heap.isEmpty()){
    res.add(0, min_heap.poll().getKey());
}
```

## Random
```
import Java.util.Random

Random random = new Random();
int randInt = random.nextInt();
int randInt1 = random.nextInt(100); //Random int between 0 and 99
```
