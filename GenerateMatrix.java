public class GenerateMatrix {
  public int[][] generateMatrix(int n) {
    int[][] matrix = new int[n][n];
    int leftPos = 0;
    int topPos = 0;
    int rightPos = n-1;
    int bottomPos = n-1;
    int k = 0;
    int i = 1;
    while(i<=n*n){
      k = leftPos;
      while(k<=rightPos) {
        matrix[topPos][k++] = i++;
      }

      topPos++;
      k=topPos;
      while(k<=bottomPos) {
        matrix[k++][rightPos] = i++;
      }

      rightPos--;
      k=rightPos;
      while(k>=leftPos) {
        matrix[bottomPos][k--] = i++;
      }

      bottomPos--;
      k=bottomPos;
      while(k>=topPos) {
        matrix[k--][leftPos] = i++;
      }
      leftPos++;

    }
    return matrix;

  }

  public static void printMatrix(int[][] matrix) {
    for (int[] row : matrix) {
        for (int num : row) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

public static void main(String[] args) {
    int n = 3; // Change this to your desired size
    GenerateMatrix generateMatrix = new GenerateMatrix();
    int[][] result = generateMatrix.generateMatrix(n);
    printMatrix(result);
}
  
}
