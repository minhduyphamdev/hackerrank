public class LongestPalindromicSubString {
  public int findLenAroundElement(String s, int left, int right, int len) {
    while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    return right - left - 1;
  }

  public String longestPalindrome(String s) {
    if (s == null || s.length() <= 1) {
      return s;
    }
    int len = s.length();
    int start = 0;
    int end = 0;
    for (int i = 0; i < len; i++) {
      int len1 = findLenAroundElement(s, i, i, len); // odd
      int len2 = findLenAroundElement(s, i, i + 1, len);
      int tempLen = Math.max(len1, len2);

      if (tempLen > end - start) {
        start = i - (tempLen - 1) / 2;
        end = i + tempLen / 2;
      }
    }
    return s.substring(start, end + 1);
  }

  public static void main(String[] args) {
    String s = "bb";
    LongestPalindromicSubString longest = new LongestPalindromicSubString();
    System.out.println(longest.longestPalindrome(s));
  }
}
