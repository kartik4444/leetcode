class Solution {

    // Trie node definition
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word; // non-null when a word ends here
    }

    private TrieNode root = new TrieNode();
    private List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        // 1. Build Trie
        for (String word : words) {
            insert(word);
        }

        // 2. DFS from each cell
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root);
            }
        }

        return result;
    }

    private void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.word = word; // mark end of word
    }

    private void dfs(char[][] board, int i, int j, TrieNode node) {

        // boundary / visited check
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return;

        char c = board[i][j];
        if (c == '#' || node.children[c - 'a'] == null)
            return;

        node = node.children[c - 'a'];

        // found a word
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // avoid duplicates
        }

        // mark visited
        board[i][j] = '#';

        // explore neighbors
        dfs(board, i + 1, j, node);
        dfs(board, i - 1, j, node);
        dfs(board, i, j + 1, node);
        dfs(board, i, j - 1, node);

        // backtrack
        board[i][j] = c;
    }
}
