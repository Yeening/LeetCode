class Solution {
    /*
    size 2
    size 3: move the largest to the end -> size 2
    size 4: 
    N: arr.length
    invariant: 
    i 0, [0, N-1]
    i 1, [0, N-2]
    i + rangeBound = N - 1
    i: [0, N - 1):
        dest = N - 1 - i
        find the largest index j in [0, dest]
        if (j != dest):
            move(j, dest)
            
    
    // pre: i >= 0, i < N, dest < N
    move(arr, int i, int dest) {
        oldVal = arr[i]
        pancakeFlip(i+1) // [oldVal, ..., old[i+1], ..., old[N-1]]
        pancakeFlip(dest + 1) // arr[dest] = oldVal
        
    }
    // post: arr[dest] = old(arr[i])
    */
    List<Integer> kList;
    public List<Integer> pancakeSort(int[] arr) {
        int N = arr.length;
        kList = new ArrayList<>(N*2);
        for (int i = 0; i < N; i++) {
            int dest = N - 1 - i, largestIndex = 0;
            for (int j = 0; j < dest + 1; j++) {
                if (arr[j] >= arr[largestIndex]) {largestIndex = j;}
            }
            move(arr, largestIndex, dest);
        }
        return kList;
    }
    
    private void move(int[] arr, int from, int dest) {
        if (from == dest) {return;}
        int oldVal = arr[from];
        pancakeFlip(arr, from + 1);
        assert(arr[0] == oldVal);
        pancakeFlip(arr, dest + 1);
        assert(arr[dest] == oldVal);
    }
    
    
    private void pancakeFlip(int[] arr, int k) {
        int left = 0, right = k - 1;
        while (left < right) {
            swap(arr, left++, right--);
        }
        kList.add(k);
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
