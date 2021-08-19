// https://labuladong.gitbook.io/algo/mu-lu-ye-1/mu-lu-ye-3/tian-ji-sai-ma

class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int N = nums1.length;
        Arrays.sort(nums1);
        int small = 0, big = N - 1;
        int[] res = new int[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (nums2[b] - nums2[a]));
        for (int i = 0; i < N; i++) {
            pq.add(i);
        }
        while (!pq.isEmpty()) {
            int i = pq.poll();
            if (nums1[big] > nums2[i]) {
                res[i] = nums1[big--];
            } else {
                res[i] = nums1[small++];
            }
        }
        return res;
    }
}
