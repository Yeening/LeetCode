class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int N = A.length;
        int[] res = new int[N];
        Set<Integer> seenA = new HashSet<>(), seenB = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int a = A[i], b = B[i];
            res[i] = i == 0? 0: res[i-1];
            if (a == b) {
                res[i]++;
            } else {
                if (seenA.contains(b)) res[i]++;
                if (seenB.contains(a)) res[i]++;
            }
            seenA.add(a);
            seenB.add(b);
        }
        return res;
    }
}
