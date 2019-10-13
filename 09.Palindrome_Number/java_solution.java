// class Solution {
//     public boolean isPalindrome(int x) {
//         String s = String.valueOf(x);
//         int lo = 0, hi = s.length()-1;
//         while(lo<hi){
//             if(s.charAt(lo++)!=s.charAt(hi--)) return false;
//         }
//         return true;
//     }
// }

class Solution {
    public boolean isPalindrome(int x) {
        if(x<0||(x%10==0&&x!=0)) return false;
        int rev = 0;
        while(x > rev){
            rev = rev * 10 + x%10;
            x /= 10;
        }
        return (x==rev||x==rev/10);
    }
}
