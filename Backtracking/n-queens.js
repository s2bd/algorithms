// Algorithm: N-Queens
// Type: Backtracking
// Time: O(N!)
// Space: O(N^2)

function isSafe(board, row, col, n) {
    for (let i = 0; i < row; i++) {
        if (board[i][col] === 'Q') return false;
        if (col - (row - i) >= 0 && board[i][col - (row - i)] === 'Q') return false;
        if (col + (row - i) < n && board[i][col + (row - i)] === 'Q') return false;
    }
    return true;
}

function solve(board, row, n) {
    if (row === n) {
        console.log(board.map(r => r.join(' ')).join('\n'));
        console.log();
        return;
    }

    for (let col = 0; col < n; col++) {
        if (isSafe(board, row, col, n)) {
            board[row][col] = 'Q';
            solve(board, row + 1, n);
            board[row][col] = '.';
        }
    }
}

function nQueens(n) {
    const board = Array.from({ length: n }, () => Array(n).fill('.'));
    solve(board, 0, n);
}
