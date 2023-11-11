// problem: https://leetcode.com/problems/simplify-path/description/?envType=study-plan-v2&envId=top-interview-150

public class SimplifyPath {
  public String deleteCharacter(String s, int index) {
    return s.substring(0, index) + s.substring(index+1, s.length());
  }
  public String simplifyPath(String modifyPath) {
    String path = modifyPath;
    for(int i=0 ; i< path.length(); i++) {
      char c = path.charAt(i); 
      if(c == '/' && path.charAt(i+1) == '/')  {
        path = deleteCharacter(path,i+1);
      } 
      else if(c=='.') {
        path = deleteCharacter(path, i);
      }
    }
    while(path.charAt(path.length()-1) == '/') {

      path = deleteCharacter(path, path.length()-1);
    }

    return path;
  }

  public static void main(String[] args ) {
    String s = "/home/";
    SimplifyPath simplifyPath = new SimplifyPath();
    System.out.println(simplifyPath.simplifyPath(s));
  }
}
