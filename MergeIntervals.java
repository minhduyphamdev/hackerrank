import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
  public static int[][] merge(int[][] intervals) {
    if(intervals == null || intervals.length < 1) {
      return intervals;
    }

    

    Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

    int[] currentInterval = intervals[0];
    List<int[]> mergedInterval = new ArrayList<>(); 

    for(int i=1; i< intervals.length;i++) {
      int[] nextInterval = intervals[i];

      if(currentInterval[1] >= nextInterval[0] ) {
        currentInterval[1] = Math.max(currentInterval[1],nextInterval[1]);
      } else {
        mergedInterval.add(currentInterval);
        currentInterval=nextInterval;
      }
    }

    mergedInterval.add(currentInterval);

    return mergedInterval.toArray(new int[mergedInterval.size()][]);
  }

  public static void main(String[] args) {
    int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    int[][] result = merge(intervals);

    // Print the result
    for (int[] interval : result) {
        System.out.println(Arrays.toString(interval));
    }
}
}
