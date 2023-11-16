import java.util.*;

public class ZigZag {

    public static String encodeZigZag(String input,int numRows) {

      if(numRows == 1 || numRows >=input.length()) {
        return input;
      }

      StringBuilder[] builders = new StringBuilder[numRows];
      for(int i=0 ; i < builders.length; i++) {
        builders[i] = new StringBuilder();
      }
      boolean increase = false;
      int currentRow = 0;

      for(char c : input.toCharArray()) {
        builders[currentRow].append(c);

        if(currentRow == 0 || currentRow == numRows-1) {
          increase = !increase;
        }

        currentRow += increase ? 1: -1;
      }

      StringBuilder finalStringBuilder = new StringBuilder();
      for(int i=0 ;i<builders.length;i++) {
        finalStringBuilder.append(builders[i].toString());
      }

      return finalStringBuilder.toString();

    }
  
    static String[] slurpStdin() {
      Scanner scan = new Scanner(System.in);

      String input = scan.nextLine();
      int numRows = scan.nextInt(); 

      String[] stdin = new String[] {input, String.valueOf(numRows)};

      return stdin;
  }


  public static void main(String[] args) {
      String[] input = slurpStdin();
      String encodedZigZagString = encodeZigZag(input[0],Integer.valueOf(input[1]));
      System.out.println(encodedZigZagString);
  }
}