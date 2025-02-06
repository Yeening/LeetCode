class Solution {
    public int[] findBuildings(int[] heights) {
        int blockerHeight = -1;
        List<Integer> viewBuildings = new ArrayList<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > blockerHeight) {
                viewBuildings.add(i);
                blockerHeight = heights[i];
            }
        }

        int count = viewBuildings.size();
        int[] res = new int[count];
        for (int i = 0; i < count; i++) {
            res[i] = viewBuildings.get(count - 1 - i);
        }
        return res;
    }
}
