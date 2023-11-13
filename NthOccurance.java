public class NthOccurance {
  public int nthOccurance(String input, String subString, int nth) {
    if(nth<0) {
      throw new RuntimeException("Index out of bound");
    }
    if(nth == 1) {
      return input.indexOf(subString);
    }
    else {
      return input.indexOf(subString, nthOccurance(input, subString, nth-1) + subString.length());
    }
  }

  public static void main(String[] args) {
    String input = "a word, a word, a word";
    NthOccurance nthOccurance = new NthOccurance();
    System.out.println(nthOccurance.nthOccurance(input, "a", 2));
  }
}