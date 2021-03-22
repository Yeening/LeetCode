//Solutin 1
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] remainTime = new int[60];
        int res = 0;
        for (int t: time) {
            int remain = t % 60;
            if (remain == 0) {
                res += remainTime[0];
            } else {
                res += remainTime[60 - remain];
            }
            remainTime[remain]++;
        }
        return res;
    }
}

//Solutin 2

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] remainTime = new int[60];
        int res = 0;
        for (int t: time) {
            int remain = (600 - t) % 60;
            res += remainTime[remain];
            remainTime[t % 60]++;
        }
        return res;
    }
}
