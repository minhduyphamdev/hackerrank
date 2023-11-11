package hackerrank;

import java.util.*;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> lists = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        int length = nums.length;
        for(int i=0; i < length-3; i++) {
            for (int j=i+1; j<length-2;j++) {
                int left = j+1;
                int right = length-1;
                while(left<right) {
                    int current = nums[i] + nums[j] + nums[left] + nums[right];
                    if(current == target) {
                        lists.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        left ++;
                        right --;


                    }
                    else if (current < target) {
                        left++;

                    }
                    else {
                        right --;

                    }
                }
            }
        }

        return new ArrayList<>(lists);
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};
        int target = 8;
        FourSum fourSum = new FourSum();
        List<List<Integer>> lists = fourSum.fourSum(nums, target);
        for(List<Integer> list: lists) {
            for(int a: list) {
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }
}
