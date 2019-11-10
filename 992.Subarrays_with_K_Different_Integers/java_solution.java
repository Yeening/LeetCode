class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        int distinct = 0, res = 0, pre_fix = 0;
        int[] map = new int[20001];
        for(int i = 0, j = 0; j<A.length; j++){
            //add right pointer to map
            map[A[j]]++;
            if(map[A[j]]==1) distinct++;
            if(distinct<K) continue;
            //eliminate extra distincts
            while(distinct>K){
                map[A[i]]--;
                if(map[A[i]]==0){
                    distinct--;
                    pre_fix = 0;
                } 
                i++;
            }
            //eliminate duplicate numbers in the left
            while(map[A[i]]>1){
                map[A[i]]--;
                i++;
                pre_fix++;
            }
            res+=(pre_fix+1);
            // if(distinct==K) res+=(pre_fix+1);            
        }
        return res;
    }
}
