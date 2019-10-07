// class Solution {
//     public int reverse(int x) {
//         long res = 0;
//         while(x!=0){
//             int dig = x%10;
//             res = res*10 + dig;
//             if(res>Integer.MAX_VALUE||res<Integer.MIN_VALUE) return 0;
//             x /= 10;
//         }
//         return (int)res;
//     }
// }

class Solution {
    public int reverse(int x) {
        int res = 0, pre = 0;
        while(x!=0){
            int dig = x%10;
            res = res*10 + dig;
            if((res - dig)/10!=pre) return 0;
            x /= 10;
            pre = res;
        }
        return res;
    }
}
