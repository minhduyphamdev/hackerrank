// 10/09
// problem: https://leetcode.com/problems/merge-strings-alternately/?envType=study-plan-v2&envId=leetcode-75
public class MergeStringAlternative {
  public String mergeAlternately(String word1, String word2) {
    int len1 = word1.length();
    int len2 = word2.length();
    StringBuilder builder = new StringBuilder();
    int minLen = Math.min(len1, len2);

    for (int i = 0; i < minLen; i++) {
      builder.append(word1.charAt(i));
      builder.append(word2.charAt(i));
    }

    if (len1 > len2) {
      builder.append(word1.substring(minLen));
    } else {
      builder.append(word2.substring(minLen));
    }

    return builder.toString();
  }
}
