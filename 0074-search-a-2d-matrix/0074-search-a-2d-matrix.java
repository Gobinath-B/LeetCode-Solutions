class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            int i = mid / cols; // Determine row index
            int j = mid % cols; // Determine column index
            
            if (matrix[i][j] == target) {
                return true; // Target found
            } 
            else if (matrix[i][j] < target) {
                left = mid + 1; // Move to the right half
            } 
            else {
                right = mid - 1; // Move to the left half
            }
        }
        
        return false; // Target not found
    }
}