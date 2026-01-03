/*
Iterate through every cell in the board and treat each as a possible starting point
Start DFS only when the current cell matches the first character of the word
Use DFS to explore the word character by character
If index == word.length(), all characters are matched → return true
Return false when indices go out of bounds or characters don’t match
Mark a cell as visited by temporarily replacing its value (e.g. '#')
Explore all four directions: up, down, left, and right
If any recursive call returns true, the word exists in the board
After exploring, restore the original character (backtracking)
Backtracking allows reuse of cells for other search paths
Time complexity: O(m × n × 4^L) where L is word length
Space complexity: O(L) due to recursion stack
*/
class Solution {
    public boolean exist(char[][] board, String word) {
        // Step 1: Iterate through every cell as a potential starting point
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // Step 2: Start DFS if the first character matches
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, 0, board, word)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int index, char[][] board, String word) {
        // Base Case: All characters in 'word' have been found
        if (index == word.length()) return true;

        // Boundary checks and character matching
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length 
            || board[i][j] != word.charAt(index)) {
            return false;
        }

        // Step 3: Mark current cell as visited (temporarily)
        char temp = board[i][j];
        board[i][j] = '#'; // Use a special character to mark as visited

        // Step 4: Explore all 4 directions (Up, Down, Left, Right)
        boolean found = dfs(i + 1, j, index + 1, board, word) ||
                        dfs(i - 1, j, index + 1, board, word) ||
                        dfs(i, j + 1, index + 1, board, word) ||
                        dfs(i, j - 1, index + 1, board, word);

        // Step 5: Backtrack - restore the cell's original value
        board[i][j] = temp;

        return found;
    }
}
