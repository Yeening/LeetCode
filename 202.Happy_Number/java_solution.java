class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int remain, sSum;
        //record sum numbers in a hashset
        while(set.add(n)){
            remain = 0;
            sSum = 0;
            while(n > 0){
                remain = n%10;
                sSum += remain*remain;
                n /= 10;
            }
            if(sSum == 1) return true;
            n = sSum;
        }
        return false;
    }
}
