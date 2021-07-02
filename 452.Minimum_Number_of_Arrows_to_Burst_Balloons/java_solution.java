// Explanation: https://labuladong.gitbook.io/algo/mu-lu-ye-2/mu-lu-ye-3/tan-xin-suan-fa-zhi-qu-jian-tiao-du-wen-ti
public static class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> (a[1] - b[1]));
        int arrows = 1, lastEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > lastEnd) {
                arrows++;
                lastEnd = points[i][1];
            }
        }
        return arrows;
    }
}
