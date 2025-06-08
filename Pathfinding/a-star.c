// Algorithm: A* Search
// Type: Graph, Pathfinding, Heuristic-based Search
// Time Complexity: O(E) or O(V log V) with priority queue
// Space Complexity: O(V)

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <limits.h>

#define N 5  // Grid size
#define INF 1000000

typedef struct {
    int x, y;
} Point;

typedef struct {
    int f, g, h;
    Point parent;
    int visited;
} Node;

int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

// Heuristic: Manhattan distance
int heuristic(Point a, Point b) {
    return abs(a.x - b.x) + abs(a.y - b.y);
}

// Check if position is inside grid and not blocked
int isValid(int grid[N][N], int x, int y) {
    return x >= 0 && x < N && y >= 0 && y < N && grid[x][y] == 0;
}

// A* algorithm on grid
void aStar(int grid[N][N], Point start, Point goal) {
    Node nodes[N][N];

    for (int i = 0; i < N; ++i)
        for (int j = 0; j < N; ++j) {
            nodes[i][j].f = INF;
            nodes[i][j].g = INF;
            nodes[i][j].h = 0;
            nodes[i][j].visited = 0;
            nodes[i][j].parent = (Point){-1, -1};
        }

    nodes[start.x][start.y].g = 0;
    nodes[start.x][start.y].h = heuristic(start, goal);
    nodes[start.x][start.y].f = nodes[start.x][start.y].h;

    while (1) {
        int minF = INF;
        Point current = {-1, -1};

        // Find node with lowest f
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < N; ++j)
                if (!nodes[i][j].visited && nodes[i][j].f < minF) {
                    minF = nodes[i][j].f;
                    current = (Point){i, j};
                }

        if (current.x == -1) {
            printf("No path found\n");
            return;
        }

        if (current.x == goal.x && current.y == goal.y) {
            // Reconstruct path
            printf("Path: ");
            Point p = goal;
            while (!(p.x == start.x && p.y == start.y)) {
                printf("(%d,%d) <- ", p.x, p.y);
                p = nodes[p.x][p.y].parent;
            }
            printf("(%d,%d)\n", start.x, start.y);
            return;
        }

        nodes[current.x][current.y].visited = 1;

        // Explore neighbors
        for (int d = 0; d < 4; ++d) {
            int nx = current.x + dx[d];
            int ny = current.y + dy[d];

            if (!isValid(grid, nx, ny) || nodes[nx][ny].visited) continue;

            int tentativeG = nodes[current.x][current.y].g + 1;

            if (tentativeG < nodes[nx][ny].g) {
                nodes[nx][ny].parent = current;
                nodes[nx][ny].g = tentativeG;
                nodes[nx][ny].h = heuristic((Point){nx, ny}, goal);
                nodes[nx][ny].f = tentativeG + nodes[nx][ny].h;
            }
        }
    }
}

// Example usage
int main() {
    int grid[N][N] = {
        {0, 1, 0, 0, 0},
        {0, 1, 0, 1, 0},
        {0, 0, 0, 1, 0},
        {1, 1, 0, 0, 0},
        {0, 0, 0, 1, 0}
    };

    Point start = {0, 0};
    Point goal = {4, 4};

    aStar(grid, start, goal);
    return 0;
}
