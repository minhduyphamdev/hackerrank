import java.util.*;

public class WordPattern {
  public boolean wordPattern(String pattern, String s) {
    String[] patternArr = pattern.split("");
    String[] sArr = s.split(" ");

    if(patternArr.length != sArr.length) {
      return false;
    }

    HashMap<String,String> map = new HashMap<>();
    for(int i=0;i<patternArr.length;i++) {
      if(!map.containsKey(patternArr[i])) {
        if(!map.containsValue(sArr[i])){
          map.put(patternArr[i],sArr[i]);
        }
        else {
          return false;
        }
      }
      else {
        String value = map.get(patternArr[i]);
        if(!value.equals(sArr[i])) {
          return false;
        }
      }
    }

    return true;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String pattern = scanner.nextLine();
    String s = scanner.nextLine();
    scanner.close();
    WordPattern wordPattern = new WordPattern();
    System.out.println(wordPattern.wordPattern(pattern, s));
  }
  
}
