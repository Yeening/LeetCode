class Solution {
    /*
    
    arr.length - 1 - rightMost + 1 = k
    rightMost = arr.length - k
    rightBound = arr.length - k + 1
    search range: [0, n - k + 1)

    */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k, start = -1, mid = 0;
        // invariant: the start shoud in [left, right)
        while (left < right) {
            mid = left + (right - left >> 1);
            // k range: [mid, mid + k - 1]
            if (arr[mid + k] - x < x - arr[mid]) { 
                // we can get better by moving rightward by 1 step
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return Arrays.stream(arr)
            .skip(left)
            .limit(k).boxed()
            .collect(Collectors.toList());
    }
}
