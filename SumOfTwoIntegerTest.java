// Sum of two integers
// Cho một mảng bao gồm các số nguyên (có thể âm) bất kì và một số target. Biết rằng trong mảng tồn tại duy nhất một cặp số 
// Input
// Dòng đầu tiên chứa số n - số phần tử của mảng
// n dòng tiếp theo: mỗi dòng gồm một phần tử của mảng
// dòng cuối cùng : số target
// Constraints
// 1≤nums.length≤100
// −100≤nums[i]≤100
// −100≤target≤100
// Output
// 2 chỉ số của hai phần tử thỏa mãn cách nhau bởi khoảng trắng.

// help me generate code to provide test case based on in java code

import java.util.Random;

public class TestCaseGenerator {

    public static void main(String[] args) {
        generateTestCase();
    }

    public static void generateTestCase() {
        // Input: number of elements in the array
        Random random = new Random();
        int n = random.nextInt(10) + 1; // You can adjust the range based on your requirements

        // Input: array of integers
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = random.nextInt(201) - 100; // Values between -100 and 100
        }

        // Input: target sum
        // int target = random.nextInt(201) - 100; // Values between -100 and 100

        // // Ensure there exists a unique pair that sums up to the target
        // int index1 = random.nextInt(n);
        // int index2 = random.nextInt(n);
        // while (index1 == index2 || nums[index1] + nums[index2] != target) {
        //     index2 = random.nextInt(n);
        // }

        // Output: indices of the two elements
        System.out.println(n);
        for (int i = 0; i < n; i++) {
            System.out.println(nums[i]);
        }
        // System.out.println(target);
        // System.out.println((index1 + 1) + " " + (index2 + 1)); // Adding 1 to indices for 1-based indexing
    }
}