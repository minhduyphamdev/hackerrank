public class MedianOfTwoSortedArraysDiffSize {
  public double findMedianOfTwoSortedArraysDiffSize(int[] nums1, int[] nums2) {

    int len1 = nums1.length;
    int len2 = nums2.length;

    // Handle the case when either nums1 or nums2 is empty
    if (len1 == 0) {
      if (len2 % 2 == 1) {
        return nums2[len2 / 2];
      } else {
        return (nums2[len2 / 2 - 1] + nums2[len2 / 2]) / 2.0;
      }
    } else if (len2 == 0) {
      if (len1 % 2 == 1) {
        return nums1[len1 / 2];
      } else {
        return (nums1[len1 / 2 - 1] + nums1[len1 / 2]) / 2.0;
      }
    }

    int middle = (len1 + len2) / 2;
    int i = 0;
    int j = 0;
    int m1 = -1;
    int m2 = -1;
    for (int count = 0; count <= middle; count++) {
      m1 = m2;
      if (i < len1 && j < len2) {
        m2 = nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++];

      } else if (i < len1) {
        m2 = nums1[i++];
      } else {
        m2 = nums2[j++];
      }
    }

    if (middle % 2 == 1) {
      return m2;
    } else {
      return (m1 + m2) / 2.0;
    }
  }

  public static void main(String[] args) {
    int[] nums1 = { 1, 3 };
    int[] nums2 = { 2 };
    MedianOfTwoSortedArraysDiffSize container = new MedianOfTwoSortedArraysDiffSize();
    System.out.println(container.findMedianOfTwoSortedArraysDiffSize(nums1, nums2));
  }
}
