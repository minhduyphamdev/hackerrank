public class MedianOfTwoSortedArraysSameSize {
  public double findMedianOfTwoSortedArraysSameSize(int[] nums1, int[] nums2, int n) {
    int i = 0;
    int j = 0;
    int m1 = -1;
    int m2 = -1;
    int count = 0;
    while (count <= n) {
      if (i == n) {
        m1 = m2;
        m2 = nums2[0];
        break;
      }

      if (nums1[i] <= nums2[j]) {
        m1 = m2;
        m2 = nums1[i];
        i++;
      } else {
        m1 = m2;
        m2 = nums2[j];
        j++;
      }
      count++;
    }
    return (m1 + m2) / 2.0;
  }

  public static void main(String[] args) {
    int[] nums1 = { 1, 3 };
    int[] nums2 = { 5, 6 };
    MedianOfTwoSortedArraysSameSize container = new MedianOfTwoSortedArraysSameSize();
    System.out.println(container.findMedianOfTwoSortedArraysSameSize(nums1, nums2, nums1.length));
  }
}
