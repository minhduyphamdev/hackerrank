import java.util.*;

// 10/09 
// bai toan: https://www.hackerrank.com/challenges/java-stack/problem
// cach giai: 
/*
 * neu la cac ki tu mo thi them vao stack
 * nguoc lai neu la ki tu con lai thi check neu (), {}, [] theo cap thi pop nguoc lai thi tra ve false 
 */
public class BalanceParentheses {

  public static boolean checkBalance(String text) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);
      if (c == '(' || c == '{' || c == '[') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) {
          return false;
        }

        switch (c) {
          case ')':
            if (stack.pop() != '(') {
              return false;
            }
            break;
          case '}':
            if (stack.pop() != '{') {
              return false;
            }
            break;
          case ']':
            if (stack.pop() != '[') {
              return false;
            }
            break;
        }
      }
    }

    return stack.isEmpty();
  }

  public static void main(String[] argh) {
    Scanner sc = new Scanner(System.in);

    while (sc.hasNext()) {
      String input = sc.next();
      // Complete the code
      System.out.println(checkBalance(input));
    }

    sc.close();
  }
}
