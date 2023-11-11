import java.util.Arrays;

public class ThreeSumClosest {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int result = 0;
    int left = 0;
    int right = 0;
    int len = nums.length;
    int sum = 0;
    int diff = Integer.MAX_VALUE;
    for (int i = 0; i < len - 2; i++) {
      left = i + 1;
      right = len - 1;
      while (left < right) {
        sum = nums[i] + nums[left] + nums[right];
        if (Math.abs(sum - target) < diff) {
          result = sum;
          diff = Math.abs(sum - target);
        }

        if (sum < target) {
          left++;
        } else if (sum > target) {
          right--;
        } else {
          return sum;
        }

      }
    }

    return result;
  }

  public static void main(String[] args) {
    int[] nums = { 4, 0, 5, -5, 3, 3, 0, -4, -5 };
    int target = -1;
    ThreeSumClosest main = new ThreeSumClosest();
    System.out.println(main.threeSumClosest(nums, target));
  }

}