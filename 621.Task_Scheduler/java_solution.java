/* Solution: two conditions: the most frequent tasks are frequent enough to force some idle, or not.
If there is not idle time, the total time will be the length of tasks.
If there is, then there are (maxF-1) groups of (n+1) times plus maxNum-1 */
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] fre = new int[26];
        for(char c: tasks) {
            fre[c-'A']++;
        }
        int maxNum = 0, maxF = 0;
        for(int f: fre) {
            maxF = Math.max(maxF, f);
        }
        for(int f: fre) {
            if(f == maxF) {
                maxNum++;
            }
        }
        return Math.max((n + 1) * (maxF - 1) + maxNum, tasks.length);
    }
}
