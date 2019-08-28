class Solution {
    //Solution 1: maintaing 3 sqcquences
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        //maintain three secquences(actually only need one item for each)
        //The sequence is consisted by the 2,3,5 times of ugly secquence 
        int index2 = 0, index3 = 0, index5 = 0;
        int item2 = 2, item3 = 3, item5 = 5;
        ugly[0] = 1;
        for(int i = 1; i < n; i++){
            ugly[i] = Math.min(item2,Math.min(item3,item5));
            if(ugly[i]==item2){
                item2 = ugly[++index2] * 2;
            }
            if(ugly[i]==item3){
                item3 = ugly[++index3] * 3;
            }
            if(ugly[i]==item5){
                item5 = ugly[++index5] * 5;
            }
        }
        return ugly[n-1];
    }
    //Solution 2, using TreeSet, elegant but not fast
    public int nthUglyNumber(int n) {
        TreeSet<Long> set = new TreeSet<>();
        set.add(1L);
        long current = 1;
        for(int i = 0; i < n; i++){
            current = set.pollFirst();
            set.add(current*2);
            set.add(current*3);
            set.add(current*5);
        }
        return (int)current;
    }    
}
