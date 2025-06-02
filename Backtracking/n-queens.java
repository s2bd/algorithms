// Algorithm: N-Queens
// Type: Backtracking
// Time: O(N!)
// Space: O(N^2)

public class NQueens {
    static void solve(char[][] board, int row) {
        int n = board.length;
        if (row == n) {
            for (char[] r : board)
                System.out.println(new String(r));
            System.out.println();
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                solve(board, row + 1);
                board[row][col] = '.';
            }
        }
    }

    static boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q') return false;

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q') return false;

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (board[i][j] == 'Q') return false;

        return true;
    }

    public static void nQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board)
            java.util.Arrays.fill(row, '.');
        solve(board, 0);
    }
}
