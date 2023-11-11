public class RansomNote {
  public boolean canConstruct(String ransomNote, String magazine) {
    int[] letterAlphabets = new int[26];
    int ransomNoteLength = ransomNote.length();

    for(int i=0;i<ransomNoteLength;i++) {
      char c = magazine.charAt(i);
      letterAlphabets[c-'a'] ++;
      c = ransomNote.charAt(i);
      letterAlphabets[c-'a'] --;
    }

    for(int i=ransomNoteLength;i<magazine.length();i++) {
      char c = magazine.charAt(i);
      letterAlphabets[c-'a'] ++;
    }

    for(int i=0 ; i<letterAlphabets.length;i++) {
      if(letterAlphabets[i] < 0 ) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    String ransomNoteStr = "a";
    String magazine = "b";
    RansomNote ransomNote = new RansomNote();
    System.out.println(ransomNote.canConstruct(ransomNoteStr, magazine));
  } 
  
}
