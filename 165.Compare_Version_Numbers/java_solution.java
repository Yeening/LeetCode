class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1A = version1.split("\\.");  //need to escape . and escape /
        String[] v2A = version2.split("\\.");
        int N1 = v1A.length, N2 = v2A.length;
        for(int i = 0; i < Math.min(N1, N2); i++){
            int tmp1 = Integer.valueOf(v1A[i]), tmp2 = Integer.parseInt(v2A[i]);
            if(tmp1 > tmp2) return 1;
            if(tmp1 < tmp2) return -1;
        }
        if(N1 > N2){
            for(int i = N2; i < N1; i++){
                int tmp = Integer.valueOf(v1A[i]);
                if(tmp != 0) return 1;
            }
        }
        if(N1 < N2){
            for(int i = N1; i < N2; i++){
                int tmp = Integer.valueOf(v2A[i]);
                if(tmp != 0) return -1;
            }
        }
        return 0;
    }
}
