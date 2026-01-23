class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return binarySearch(matrix, target);
    }

    private boolean binarySearch(int[][] matrix, int target) {
        int low = 0;
        int cols = matrix[0].length;
        int high = (matrix.length * matrix[0].length) - 1;

        //since per row of 2d matrix is sorted we can treat it as an 1D array of length from 0 till row*col-1
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Convert 1D index to 2D coordinates
            int row = mid / cols;
            int col = mid % cols;
            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;
        // TC - 0(log(n*m)) 
        // SC - O(1)
    }
}
