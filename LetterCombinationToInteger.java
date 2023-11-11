// problem: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
// 19/09

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationToInteger {
  public static Map<Character, String> digitToLetters = new HashMap<Character, String>();
  static {
    digitToLetters.put('2', "abc");
    digitToLetters.put('3', "def");
    digitToLetters.put('4', "ghi");
    digitToLetters.put('5', "jkl");
    digitToLetters.put('6', "mno");
    digitToLetters.put('7', "pqrs");
    digitToLetters.put('8', "tuv");
    digitToLetters.put('9', "wxyz");
  }

  public List<String> letterCombinations(String digits) {
    List<String> letters = new ArrayList<String>();
    if (digits.isEmpty()) {
      return letters;
    }
    combinePartitionLetter(letters, digits, 0, new StringBuilder());
    return letters;
  }

  public void combinePartitionLetter(List<String> letters, String digits, int pos, StringBuilder builder) {
    if (pos == digits.length()) {
      letters.add(builder.toString());
      return;
    }

    char digit = digits.charAt(pos);
    String letter = digitToLetters.get(digit);
    for (int i = 0; i < letter.length(); i++) {
      builder.append(letter.charAt(i));
      combinePartitionLetter(letters, digits, pos + 1, builder);
      builder.deleteCharAt(builder.length() - 1);
    }

  }

  public static void main(String[] args) {
    String digits = "23";
    LetterCombinationToInteger letterCombinationToInteger = new LetterCombinationToInteger();
    List<String> letters = letterCombinationToInteger.letterCombinations(digits);
    for (String letter : letters) {
      System.out.println(letter);
    }

  }

}
