public class SearchInRotatedArray {
  public boolean search(int[] nums, int target) {
      int left = 0;
      int right = nums.length -1;
      while(left<right) {
        int mid = left + (right-left) / 2;
        if(nums[mid] == target) {
          return true;
        }
        else if( nums[mid] < nums[right]) {
          // right half is sorted
          if(target > nums[mid] && target <=nums[right] ) {
            left= mid +1;
          }
          else {
            right = mid -1;
          }
        }
        else if( nums[mid] > nums[right]) {
          //left half is sorted
          if(target <nums[mid] && target >= nums[0]){
            right = mid -1;
          }
          else {
            left++;
          }

        }
        else {
          right = mid;
        }
      }

      return false;
  }

  public static void main(String[] args) {
    int[] nums = {1,0,1,1,1};
    int target = 0;
    SearchInRotatedArray searchInRotatedArray = new SearchInRotatedArray();

    boolean result = searchInRotatedArray.search(nums, target);
    System.out.println(result); // Output: true
  }
  
}
