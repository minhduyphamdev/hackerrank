import java.util.*;

public class MinimumPathSum {
  private static List<List<Integer>> scanListInput() {
    List<List<Integer>> result = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    int numRows = scanner.nextInt();

    for (int i = 0; i < numRows; i++) {
        List<Integer> innerList = new ArrayList<>();
        for(int j=0;j<=i;j++) {
            innerList.add(scanner.nextInt());
        }
        result.add(innerList);
    }

    return result;
  }
  public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    for(int i=n-2;i>=0;i--) {
        for(int j=0;j<=i;j++) {
        triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1)));
      }
    }

    return triangle.get(0).get(0);
  }

  public static void main(String[] args) {
    List<List<Integer>> list = scanListInput();
    MinimumPathSum minimumPathSum = new MinimumPathSum();
    System.out.println(minimumPathSum.minimumTotal(list));
  }
}
