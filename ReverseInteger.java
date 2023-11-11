public class ReverseInteger {
  // public int reverse(int x){
  //   int reverseResult = 0;
  //   int remainder = 0;
  //   while(x!=0) {
  //       remainder = x % 10;
  //       reverseResult = reverseResult*10 + remainder;
  //       x/=10;
  //   }
  //   return reverseResult;
  // }

  public static String removeCharacter(String str, int r) {
    return str.substring(0,r) + str.substring(r+1);
  }

   public int reverse(int x){
    String s1 = String.valueOf(x);
    StringBuilder reverseResult = new StringBuilder();
    Character reminder = 'k';
    boolean isNegative = false;
    if(s1.charAt(0) == '-') {
      ReverseInteger.removeCharacter(s1, 0);
      reverseResult.insert(0, )
    }
    while(!s1.equals("")) {
        reminder = s1.charAt(s1.length()-1);
        reverseResult.append(reminder);
        s1 = s1.substring(0, s1.length()-1);
    }
    
    return Integer.valueOf(reverseResult.toString());
  }

  public static void main(String[] args){
    int x = 2123123;
    ReverseInteger reverseInteger = new ReverseInteger();
    System.out.println(reverseInteger.reverse(x));
  }
}

