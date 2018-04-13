class Solution {
public:
    int numTrees(int n) {
        int * bsts = new int[n+1]();
        bsts[0] = 1;
        bsts[1] = 1;
        bsts[2] = 2;
        for(int i = 3; i <= n; i++){
            for(int left = 0; left < i; left++){
                bsts[i] = bsts[i] + bsts[left]*bsts[i-1-left];
            }
        }
        return bsts[n];
    }
};

//Simplified
class Solution {
public:
    int numTrees(int n) {
        int * bsts = new int[n+1]();
        bsts[0] = 1;
        for(int i = 1; i <= n; i++){
            for(int left = 0; left < i; left++){
                bsts[i] += bsts[left]*bsts[i-1-left];
            }
        }
        return bsts[n];
    }
};
