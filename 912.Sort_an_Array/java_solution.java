class Solution {
    int MIN_FOR_QUICK = 300;
    int MIN_FOR_MERGE = 50;
    public int[] sortArray(int[] nums) {
        if(nums.length>MIN_FOR_QUICK) quickSort(nums,0,nums.length-1);
        else if(nums.length>MIN_FOR_MERGE) mergeSort(nums,0,nums.length-1);
        else selectSort(nums);
        return nums;
    }
    //Quick Sort
    private void quickSort(int[] nums, int lo, int hi){
        if(lo>=hi) return;
        int pivot_pos = partition(nums, lo, hi);
        quickSort(nums, lo, pivot_pos-1);
        quickSort(nums, pivot_pos+1,hi);
    }
    private int partition(int[] nums, int lo, int hi){
        int pivot_pos = (int)(Math.random()*(hi-lo+1)) + lo;
        //Make pivot to the first pos
        swap(nums, pivot_pos, lo);
        int index = lo + 1;
        //Make items smaller than pivot from lo + 1 to index
        for(int i = lo + 1; i <= hi; i++){
            if(nums[i]<nums[lo]) swap(nums, i, index++);
        }
        swap(nums, lo, --index);
        return index;
    }
    //Select Sort
    private void selectSort(int[] nums){
        for(int i = 0; i < nums.length; i++){
            int min_pos = i;
            for(int j = i+1; j < nums.length; j++)  if(nums[j]<nums[min_pos]) min_pos = j;
            swap(nums, i, min_pos);
        }
    }
    private void mergeSort(int[] nums, int lo, int hi){
        if(lo>=hi) return;
        int mid = (lo+hi)>>1; //  (lo+hi)/2
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid+1, hi);
        merge(nums, lo, mid, hi);
    }
    private void merge(int[] nums, int lo, int mid, int hi){
        int[] newArray = new int[hi-lo+1];
        int index = 0, lo1 = lo, hi2 = hi;
        int lo2 = mid + 1;
        while(lo1<=mid && lo2<=hi2){
            if(nums[lo1]<nums[lo2]) newArray[index++] = nums[lo1++];
            else newArray[index++] = nums[lo2++];
        }
        while(lo1<=mid) newArray[index++] = nums[lo1++];
        while(lo2<=hi2) newArray[index++] = nums[lo2++];
        index = 0;
        while(lo<=hi) nums[lo++] = newArray[index++];
    }
    private void swap(int[] nums, int i, int j){
        if(i==j) return;
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}
