// 10 /09
// https://www.hackerrank.com/challenges/java-negative-subarray/problem?isFullScreen=true
/*
 * 
 * y tuong la dem tat ca mang 1 phan tu negative truoc sau do dem toan bo nhung mang con lai 
 */

import java.util.Scanner;

public class CountNegativeSubArray {
  public static int countNegativeSubArray(int[] arr, int len) {
    int count = 0;
    int k = 0;
    int sum = 0;
    for (int i = 0; i < len; i++) {
      if (arr[i] < 0) {
        count++;
      }
    }

    for (int i = 0; i < len - 1; i++) {
      sum = arr[i];
      k = i + 1;
      while (k <= len - 1) {
        sum += arr[k];
        if (sum < 0) {
          count++;
        }
        k++;
      }
    }

    return count;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();
    int[] arr = new int[num];

    for (int i = 0; i < num; i++) {
      arr[i] = scanner.nextInt();
    }

    int ans = countNegativeSubArray(arr, num);
    System.out.println(ans);
  }
}