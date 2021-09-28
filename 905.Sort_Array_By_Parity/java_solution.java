// solution 1: 2 pointer
public int[] sortArrayByParity(int[] nums) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
        while(left < right && nums[left] % 2 == 0) left++;
        while(left < right && nums[right] % 2 == 1) right--;
        if (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }
    return nums;
}
// Follow-up: stable
public int[] sortArrayByParity(int[] nums) {
    int evenIndex = 0;
    Queue<Integer> oddQueue = new LinkedList<>();
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] % 2 == 0) {
            if (nums[evenIndex] % 2 == 1) {
                oddQueue.offer(nums[evenIndex]);
            }
            nums[evenIndex++] = nums[i];
        }
    }
    int oddStart = evenIndex;
    for (int i = evenIndex; i < nums.length && !oddQueue.isEmpty(); i++) {
        if (nums[i] % 2 == 1) {
            oddQueue.offer(nums[i]);
        }
        nums[i] = oddQueue.poll();
    }
    return nums;
}
// Follow-up: stable and inplace
// Using merge-sort and leetcode 189 skill, reverse to reotate
public int[] sortArrayByParity(int[] nums) {
    sortArrayByParity(nums, 0, nums.length - 1);
    return nums;
}

private void sortArrayByParity(int[] nums, int left, int right) {
    if (left == right) return;
    if (left == right - 1) {
        if (nums[left] % 2 == 1 && nums[right] % 2 == 0) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return;
    }
    int mid = left + (right - left >> 1);
    sortArrayByParity(nums, left, mid);
    sortArrayByParity(nums, mid + 1, right);
    merge(nums, left, mid, right);
}

private void merge(int[] nums, int left, int mid, int right) {
    int leftFirstOdd = left, rightFirstOdd = mid + 1;
    while (leftFirstOdd < mid && nums[leftFirstOdd] % 2 == 0) {
        leftFirstOdd++;
    }
    while (rightFirstOdd <= right && nums[rightFirstOdd] % 2 == 0) {
        rightFirstOdd++;
    }
    int rightEvenCount = rightFirstOdd - mid - 1;
    if (nums[leftFirstOdd] % 2 == 1) {
        reverse(nums, leftFirstOdd, rightFirstOdd - 1);
        reverse(nums, leftFirstOdd, leftFirstOdd + rightEvenCount - 1);
        reverse(nums, leftFirstOdd + rightEvenCount, rightFirstOdd - 1);
    }
}

private void reverse(int[] nums, int start, int end) {
    while (start < end) {
        int temp = nums[start];
        nums[start++] = nums[end];
        nums[end--] = temp;
    }
}
