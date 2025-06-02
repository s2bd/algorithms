# Algorithm: N-Queens
# Type: Backtracking
# Time: O(N!)
# Space: O(N^2)

def is_safe(board, row, col, n):
    for i in range(row):
        if board[i][col] == 'Q':
            return False
        if col - (row - i) >= 0 and board[i][col - (row - i)] == 'Q':
            return False
        if col + (row - i) < n and board[i][col + (row - i)] == 'Q':
            return False
    return True

def solve(board, row, n):
    if row == n:
        for r in board:
            print(" ".join(r))
        print()
        return

    for col in range(n):
        if is_safe(board, row, col, n):
            board[row][col] = 'Q'
            solve(board, row + 1, n)
            board[row][col] = '.'

def n_queens(n):
    board = [['.' for _ in range(n)] for _ in range(n)]
    solve(board, 0, n)
