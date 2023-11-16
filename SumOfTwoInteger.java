import java.util.*;

public class SumOfTwoInteger {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    int n = nums.length;

    for(int i=0;i< n;i++ ){ 
      int remain = target - nums[i];

      if(map.containsKey(remain)) {
        return new int[] { map.get(remain), i};
      }

      map.put(nums[i],i);
    }

    throw new IllegalArgumentException("No sum available");
  }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int target = scanner.nextInt();

        SumOfTwoInteger solution = new SumOfTwoInteger();
        try {
            int[] result = solution.twoSum(nums, target);
            System.out.println(result[0]);
            System.out.println(result[1]);
        } catch (IllegalArgumentException e) {
            System.out.println("No two numbers add up to the target sum.");
        } finally {
            // Close the scanner to prevent resource leak
            scanner.close();
        }
    }
}



