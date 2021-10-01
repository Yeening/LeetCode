// https://leetcode.com/problems/reaching-points/discuss/375429/Detailed-explanation.-or-full-through-process-or-Java-100-beat

class Solution {
    // time: O(log(max(tx,ty)))
    // space: O(1)  
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (sx < tx && sy < ty) { //3, 4
            if (tx < ty) {
                ty %= tx;
            } else {
                tx %= ty;
            }
        }

        return (tx == sx && sy <= ty && (ty - sy) % sx == 0) ||
            (ty == sy && sx <= tx && (tx - sx) % sy == 0);
    }
    
}
