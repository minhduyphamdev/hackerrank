// problem: https://leetcode.com/problems/simplify-path/description/?envType=study-plan-v2&envId=top-interview-150

//solution:
// split by / , any sequence / will blank so we only need to push any other no-blank component into them , and must be stack because .. will pop -out its parent
// j

import java.util.Stack;

public class SimplifyPath {
  public String simplifyPath(String path) {
    Stack<String> stack = new Stack<>();
    String[] splitString = path.split("/");

    for(String component: splitString) {
      if( component.equals("..")) {
        if(stack.size() > 0) {
          stack.pop();
        }
      }
      else if(!component.isEmpty() && !component.equals(".") ) {
          stack.push(component);
        }
    }
  

    return "/" + String.join("/",stack);
  }
 

  public static void main(String[] args ) {
    String s = "/../";
    SimplifyPath simplifyPath = new SimplifyPath();
    System.out.println(simplifyPath.simplifyPath(s));
  }
}
