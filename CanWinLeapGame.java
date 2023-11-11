
// 10/09
// problem: https://www.hackerrank.com/challenges/java-1d-array/problem?isFullScreen=true
/*
 * idea is create stack and push all posible values into it. Everytime stack pop, make value as 
 * -1 to mark it has calc.
 */
import java.util.Scanner;
import java.util.Stack;

public class CanWinLeapGame {
  // C1
  // public static boolean canWin(int leap, int[] game) {
  // Stack<Integer> stack = new Stack<>();
  // int size = game.length;
  // stack.push(0);

  // while (!stack.isEmpty()) {
  // int pos = stack.pop();
  // game[pos] = -1;

  // if (pos + leap >= size || pos + 1 >= size) {
  // return true;
  // }
  // if (pos >= 1 && game[pos - 1] == 0) {
  // stack.push(pos - 1);
  // }
  // if (game[pos + 1] == 0) {
  // stack.push(pos + 1);
  // }
  // if (game[pos + leap] == 0) {
  // stack.push(pos + leap);
  // }
  // }
  // return false;
  // }

  // C2
  public static boolean canWin(int leap, int[] game) {
    return canWinFromPosition(0, leap, game);
  }

  public static boolean canWinFromPosition(int position, int leap, int[] game) {
    if (position < 0 || game[position] != 0) {
      return false;
    }

    if (position + leap >= game.length || position + 1 >= game.length) {
      return true;
    }

    game[position] = -1;

    return canWinFromPosition(position + leap, leap, game) ||
        canWinFromPosition(position + 1, leap, game) ||
        canWinFromPosition(position - 1, leap, game);
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int q = scan.nextInt();
    while (q-- > 0) {
      int n = scan.nextInt();
      int leap = scan.nextInt();

      int[] game = new int[n];
      for (int i = 0; i < n; i++) {
        game[i] = scan.nextInt();
      }

      System.out.println((canWin(leap, game)) ? "YES" : "NO");
    }
    scan.close();
  }
}
