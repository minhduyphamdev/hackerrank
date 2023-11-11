import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
  // O(nLog(n))
  public static int longestConsecutive(int[] nums) {
    Arrays.sort(nums);
    int max = 0;
    int len = nums.length;
    if (len == 1) {
      return 1;
    }
    for (int i = 0; i < len - 1;) {
      int count = 1;
      int j = i + 1;
      while (j < len) {
        if (nums[j] == nums[j - 1] + 1) {
          j++;
          count++;
        } else if (nums[j] == nums[j - 1]) {
          j++;
          continue;
        } else {
          break;
        }
      }
      i = j;
      max = Math.max(max, count);
    }

    return max;
  }

  // O(N)
  public static int longestConsecutive2(int[] nums) {
    // consequence
    int maxLen = 0;
    HashSet<Integer> set = new HashSet<Integer>();
    for (int num : nums) {
      set.add(num);
    }

    for (int num : nums) {
      // check if num is start of consecutive integer
      if (!set.contains(num - 1)) {
        int currentNum = num;
        maxLen = 1;
        while (set.contains(currentNum + 1)) {
          maxLen++;
          currentNum++;
        }
        maxLen = Math.max(maxLen, currentNum);
      }
    }
    return maxLen;
  }

  public static void main(String[] args) {
    int[] nums = new int[] { 9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6 };
    int max = LongestConsecutiveSequence.longestConsecutive(nums);
    System.out.println(max);
  }
}
