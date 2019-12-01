class Solution {
    public int subarraysDivByK(int[] A, int K) {
        // if [0, i]%K == [0,j]%K, then [i,j]%k ==0
        int[] map = new int[K];
        int res = 0, sum = 0;
        for(int a: A){
            sum = (sum + a)%K;
            // -1 % 5 = -1, we want 4
            if(sum < 0) sum += K;
            if(sum == 0) res++;
            res += (map[sum]++);
        }
        return res;
    }
}
