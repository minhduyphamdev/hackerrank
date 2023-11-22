import java.util.*;

public class TransformLength {

      public int transformLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) {
            return 0;
        }

        int transformLength = 1;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        while(!queue.isEmpty()) {
            int currentLevelSize = queue.size(); // Store the size of the current level
            for (int k = 0; k < currentLevelSize; k++) { 
            String ele = queue.poll();
            for(int i = 0; i<ele.length();i++) {
                char[] charArr = ele.toCharArray();
                
                for(char c='a';c<='z';c++) {
                    charArr[i] = c;
                    String newString = new String(charArr);
                    if(wordList.contains(newString)){
                        if(newString.equals(endWord)) {
                            return transformLength+1;
                        }
                        wordList.remove(newString);
                        queue.add(newString);
                    }
                }
            }
        }
            transformLength++;

        }

        return 0;
        
    }
    

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();

    scanner.nextLine();

    List<String> wordList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        wordList.add(scanner.nextLine());
    }
    String beginWord = scanner.nextLine();
    String endWord=scanner.nextLine();
    TransformLength transformLength = new TransformLength();
    System.out.println(transformLength.transformLength(beginWord, endWord, wordList));
  } 

}
