class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int l = 0, r = points.length - 1;
        while(l<r){
            int mid = helper(points, l, r);
            if(mid==K) break;
            if(mid < K) l = mid+1;
            else r = mid-1;
        }
        
        int[][] res = new int[K][2];
        System.arraycopy(points, 0, res, 0, K);
        return res;
    }
    
    //helper1: no need of swap, 5ms
    private int helper(int[][] points, int l, int r){
        int[] pivot = points[l];
        while(l<r){
            while(l<r && compare(points[r], pivot)>=0) r--;
            points[l] = points[r];
            while(l<r && compare(points[l], pivot)<=0) l++;
            points[r] = points[l];
        }
        points[l] = pivot;
        return l;
    }
    
    //help2: with swap, 6ms
    // private int helper(int[][] points, int l, int r){
    //     int index = l;
    //     int[] pivot = points[r];
    //     for(int i = l; i <= r; i++){
    //         if(compare(points[i], pivot)<0){
    //             swap(points, index, i);
    //             index++;
    //         }
    //     }
    //     swap(points, index, r);
    //     return index;
    // }
    
    private void swap(int[][] points, int a, int b){
        int[] mid = points[a];
        points[a] = points[b];
        points[b] = mid;
    }
    
    private int compare(int[] pointA, int[] pointB){
        return pointA[0] * pointA[0] + pointA[1] * pointA[1] - 
            pointB[0] * pointB[0] - pointB[1] * pointB[1];
    }
}
