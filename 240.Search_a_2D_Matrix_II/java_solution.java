class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return false;
        
        int i = 0, j = matrix[0].length-1, current;
        while(i<matrix.length&&j>=0){
            current = matrix[i][j];
            if(target > current) i++; //exclude current row
            else if(target < current) j--; //exlcude current column
            else return true; //target==true
                              //in most case, it will not be excuted, put in the last
        }
        
        return false;
    }
}
