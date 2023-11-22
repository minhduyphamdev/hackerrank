import java.util.*;
//https://leetcode.com/problems/valid-anagram/description/?envType=study-plan-v2&envId=top-interview-150
public class IsAnagram {
  // public boolean isAnagram(String s, String t) {
  //   if(s.length() != t.length()) {
  //     return false;
  //   }

  //   int[] characters = new int[26];
  //   for(int i=0; i<s.length(); i++) {
  //     characters[s.charAt(i)-'a'] ++;
  //     characters[t.charAt(i)-'a'] --;
  //   }

  //   for(int character: characters) {
  //     if(character!=0) {
  //       return false;
  //     }
  //   }

  //   return true;
  // }

  //Solution 2:
  public boolean isAnagram(String s, String t) {
    char[] sChars = s.toCharArray();
    char[] tChars = t.toCharArray();

    Arrays.sort(sChars);
    Arrays.sort(tChars);

    return Arrays.equals(sChars, tChars);
  }


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String s = scanner.nextLine();
    String t = scanner.nextLine();
    scanner.close();

    IsAnagram isAnagram = new IsAnagram();
    System.out.println(isAnagram.isAnagram(s, t));
  }
}