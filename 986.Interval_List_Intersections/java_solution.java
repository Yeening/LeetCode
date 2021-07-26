class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0) return new int[][]{};
        int i = 0, j = 0;
        ArrayList<int[]> intersects = new ArrayList<>();
        int[] lastInterval = compare(firstList[0], secondList[0]) < 0 ? firstList[i++] : secondList[j++];
        int[] cur = null;
        while (i < firstList.length || j < secondList.length) {
            if (i == firstList.length) {
                cur = secondList[j++];
            }
            else if (j == secondList.length) {
                cur = firstList[i++];
            }
            else if (compare(firstList[i], secondList[j]) < 0) {
                cur = firstList[i++];
            } else {
                cur = secondList[j++];
            }
            if (cur[0] <= lastInterval[1]) {
                intersects.add(new int[]{cur[0], Math.min(cur[1], lastInterval[1])});
            }
            if (cur[1] > lastInterval[1]) {
                lastInterval = cur;
            }
        }
        return intersects.toArray(new int[][]{});
    }

    private int compare(int[] a, int[] b) {
        if (a[0] == b[0]) {
            return b[1] - a[1];
        } else {
            return a[0] - b[0];
        }
    }
}
