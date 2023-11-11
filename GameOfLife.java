//problem
// https://leetcode.com/problems/game-of-life/?envType=study-plan-v2&envId=top-interview-150
public class GameOfLife {
  public int countLiveCell(int[][] board, int m, int n, int row, int col, int[][] directions) {
    int count = 0;
    for (int[] rowOfDirections : directions) {
      int newRow = row + rowOfDirections[0];
      int newCol = col + rowOfDirections[1];
      if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && board[newRow][newCol] == 1) {
        count++;
      }
    }
    return count;
  }

  public void gameOfLife(int[][] board) {
    int m = board.length;
    int n = board[0].length;
    int[][] newBoard = new int[m][n];
    int[][] directions = new int[][] {
        { -1, -1 }, { -1, 0 }, { -1, 1 },
        { 0, -1 }, { 0, 1 },
        { 1, -1 }, { 1, 0 }, { 1, 1 }
    };
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int totalLive = countLiveCell(board, m, n, i, j, directions);
        if (board[i][j] == 1) {
          if (totalLive < 2 || totalLive > 3) {
            newBoard[i][j] = 0;
          } else {
            newBoard[i][j] = 1;
          }
        } else {
          if (totalLive == 3) {
            newBoard[i][j] = 1;
          } else {
            newBoard[i][j] = 0;
          }
        }
      }
    }
    for (int i = 0; i < m; i++) {
      System.arraycopy(newBoard[i], 0, board[i], 0, n);
    }
  }

  public static void main(String[] args) {
    int[][] board = new int[][] {
        { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 }
    };
    GameOfLife game = new GameOfLife();
    game.gameOfLife(board);
    for (int[] rows : board) {
      for (int cell : rows) {
        System.out.print(cell + " ");
      }
      System.out.println();
    }
  }
}