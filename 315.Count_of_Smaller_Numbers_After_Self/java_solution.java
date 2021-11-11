class Solution {
    /*
    5,2,6,1
    6,5,2,1
    */
    class Num {
        int index;
        int val;
        Num(int val, int index) {
            this.index = index;
            this.val = val;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Num[] newNums = new Num[n];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = new Num(nums[i], i);
        }
        mergeSort(newNums, res, 0, n - 1);
        return Arrays.stream(res).boxed()
            .collect(Collectors.toCollection(ArrayList::new));
    }
    
    // [start, end]
    private void mergeSort(Num[] nums, int[] res, 
                           int start, int end) {
        if (start >= end) {return;}
        int mid = start + (end - start >> 1);
        mergeSort(nums, res, start, mid);
        mergeSort(nums, res, mid + 1, end);
        // merge
        List<Num> temp = new ArrayList<>(end - start + 1);
        int left = start, right = mid + 1, rightSmaller = 0;
        while (temp.size() < end - start + 1) {
            if (right == end + 1 
                || (left <= mid && nums[left].val <= nums[right].val)) {
                res[nums[left].index] += rightSmaller;
                temp.add(nums[left++]);
            } else {
                rightSmaller++;
                temp.add(nums[right++]);
            }
        }
        // copy back
        for (int i = 0; i < temp.size(); i++) {
            nums[i + start] = temp.get(i);
        }
    }
}
