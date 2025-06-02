// Algorithm: N-Queens
// Type: Backtracking
// Time: O(N!)
// Space: O(N^2)

#include <stdio.h>
#include <stdbool.h>
#include <string.h>

#define MAX 10
char board[MAX][MAX];

bool isSafe(int row, int col, int n) {
    for (int i = 0; i < row; i++)
        if (board[i][col] == 'Q')
            return false;

    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
        if (board[i][j] == 'Q')
            return false;

    for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
        if (board[i][j] == 'Q')
            return false;

    return true;
}

void printBoard(int n) {
    for (int i = 0; i < n; i++)
        printf("%s\n", board[i]);
    printf("\n");
}

void solve(int row, int n) {
    if (row == n) {
        printBoard(n);
        return;
    }

    for (int col = 0; col < n; col++) {
        if (isSafe(row, col, n)) {
            board[row][col] = 'Q';
            solve(row + 1, n);
            board[row][col] = '.';
        }
    }
}

void nQueens(int n) {
    for (int i = 0; i < n; i++)
        memset(board[i], '.', n);
    solve(0, n);
}
