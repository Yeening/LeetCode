// Solution 1
public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length, n = matrix[0].length;
    int i = 0, j = n - 1;
    while (i < m && j >= 0) {
        if (matrix[i][j] == target) return true;
        else if (matrix[i][j] < target) {
            i++;
        } else if (matrix[i][j] > target) {
            j--;
        }
    }
    return false;
}

// Solution 2
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m*n - 1;
        while(left <= right) {
            int mid = left + (right - left >> 1);
            int i = mid / n, j = mid % n;
            if (matrix[i][j] < target) {
                left = mid + 1;
            } else if (matrix[i][j] > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
