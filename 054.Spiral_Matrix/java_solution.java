class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0||matrix[0].length==0) return new ArrayList<Integer>();
        int top = 0, bottom = matrix.length-1
            , left = 0, right = matrix[0].length-1;
        List<Integer> res = new ArrayList<>();
        while(true){
            for(int i = left; i <= right; i++) res.add(matrix[top][i]);
            top++;
            if(top>bottom) break;
            
            for(int i = top; i <= bottom; i++) res.add(matrix[i][right]);
            right--;
            if(left>right) break;
            
            for(int i = right; i >= left; i--) res.add(matrix[bottom][i]);
            bottom--;
            if(top>bottom) break;
            
            for(int i = bottom; i >= top; i--) res.add(matrix[i][left]);
            left++;
            if(left>right) break;
        }
        return res;
    }
}

//Solution2: 100%
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0) return new ArrayList<Integer>();
        int m = matrix.length, n = matrix[0].length;
        int resSize = m*n;
        // Integer array, for following transfer to List of Integer
        Integer[] resArray= new Integer[m*n];
        int[][] move = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        int index = 0;
        //fill the first row
        for(int x = 0; x < n; x++) resArray[index++] = matrix[0][x];
        int i = 0, j = n-1; //start from top right
        int direction = 0;
        while(index < resSize){
            for(int x = 0; x < m-1; x++){
                i += move[direction][0];
                j += move[direction][1];
                resArray[index++] = matrix[i][j];                             
            }
            m--;
            //Swap m and m
            m ^= n;
            n ^= m;
            m ^= n;
            direction = (direction+1)%4;            
        }
        // ArrayList<Integer> al1 = Arrays.asList(arr);
        List<Integer> res = Arrays.asList(resArray);
        return res;
    }
}
