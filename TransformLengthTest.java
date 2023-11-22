import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class TransformLengthTest {

    public static void main(String[] args) {
        generateAndPrintTestCase();
    }

    public static void generateAndPrintTestCase() {
        // Constraints
        int minWordLength = 1;
        int maxWordLength = 10;
        int minListLength = 1;
        int maxListLength = 10;

        // Generate random values for the test case
        Random random = new Random();

        // Generate random word lengths for beginWord and endWord
        int wordLength = random.nextInt(maxWordLength - minWordLength + 1) + minWordLength;

        // Generate random beginWord
        String beginWord = generateRandomWord(wordLength);

        // Generate random endWord
        String endWord = generateRandomWord(wordLength);

        // Generate random wordList length
        int listLength = random.nextInt(maxListLength - minListLength + 1) + minListLength;

        // Generate random wordList
        List<String> wordList = generateRandomWordList(beginWord, endWord, wordLength, listLength);

        // Ensure that every adjacent pair of words differs by a single letter
        

        // Print the generated test case
        System.out.println("Generated Test Case:");
        System.out.println("beginWord: " + beginWord);
        System.out.println("endWord: " + endWord);
        System.out.println("wordList: " + wordList);
    }

    private static String generateRandomWord(int length) {
        StringBuilder word = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char randomChar = (char) (random.nextInt(26) + 'a');
            word.append(randomChar);
        }
        return word.toString();
    }

    private static List<String> generateRandomWordList(String beginWord, String endWord, int wordLength, int listLength) {
      List<String> wordList = new ArrayList<>();
      wordList.add(endWord);
  
      for (int i = 0; i < listLength - 2; i++) {
          wordList.add(generateWordWithSingleDifference(beginWord, wordLength));
      }
  
      return wordList;
  }
  
  private static String generateWordWithSingleDifference(String word, int length) {
      Random random = new Random();
      char[] chars = word.toCharArray();
      
      // Randomly select a position to change
      int positionToChange = random.nextInt(length);
  
      // Randomly select a character different from the original at the chosen position
      char newChar;
      do {
          newChar = (char) (random.nextInt(26) + 'a');
      } while (newChar == chars[positionToChange]);
  
      chars[positionToChange] = newChar;
  
      return new String(chars);
  }

    private static boolean areAdjacentWordsDifferentByOneLetter(Set<String> words) {
        for (String word : words) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char originalChar = chars[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c != originalChar) {
                        chars[i] = c;
                        String modifiedWord = new String(chars);
                        if (words.contains(modifiedWord)) {
                            return true;
                        }
                    }
                }
                chars[i] = originalChar;
            }
        }
        return false;
    }
}
