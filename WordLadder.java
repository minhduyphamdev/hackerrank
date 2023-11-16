import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

      public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        
        if (!wordSet.contains(endWord)) {
            // If the endWord is not in the wordList, transformation is not possible.
            return 0;
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        
        int ladderLength = 1;  // Initialize to 1 since beginWord is included.
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            for (int i = 0; i < levelSize; i++) {
                String currentWord = queue.poll();
                
                // Generate all possible next words by changing one letter at a time.
                for (int j = 0; j < currentWord.length(); j++) {
                    char[] wordArray = currentWord.toCharArray();
                    
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordArray[j] = c;
                        String nextWord = new String(wordArray);
                        
                        if (wordSet.contains(nextWord)) {
                            if (nextWord.equals(endWord)) {
                                return ladderLength + 1;  // Transformation is complete.
                            }
                            
                            // Mark the word as visited and add it to the queue for the next level.
                            wordSet.remove(nextWord);
                            queue.offer(nextWord);
                        }
                    }
                }
            }
            
            ladderLength++;  // Move to the next level in the transformation sequence.
        }
        
        // No transformation sequence found.
        return 0;
    }


  public static void main(String[] args) {
    String beginWord = "hit";
    String endWord = "cog";
    List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
    WordLadder wordLadder = new WordLadder();
    System.out.println(wordLadder.ladderLength(beginWord, endWord, wordList));
  } 
}
