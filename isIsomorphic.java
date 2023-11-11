import java.util.*;

public class isIsomorphic {
  public boolean isIsomorphic(String s, String t) {
    HashMap<Character,Character> map = new HashMap<>();
    int sLength = s.length();

    for(int i = 0; i< sLength ; i++) {
      char sChar = s.charAt(i);
      char tChar = t.charAt(i);
      if(!map.containsKey(sChar)) {
        if(map.containsValue(tChar)){
          return false;
        }
        map.put(sChar, tChar);
      }
      else {
        char value = map.get(sChar);
        if(value != tChar) {
          return false;
        }
      }
    }

    return true;
  }

//   public boolean isIsomorphic(String s, String t) {

//     int map1[]=new int[200];
//     int map2[]=new int[200];

//     if(s.length()!=t.length())
//         return false;


//     for(int i=0;i<s.length();i++)
//     {
//         if(map1[s.charAt(i)]!=map2[t.charAt(i)])
//             return false;

//         map1[s.charAt(i)]=i+1;
//         map2[t.charAt(i)]=i+1;
//     }
//     return true;
// }

  public static void main(String[] args) {
    String s = "badc";
    String t  ="baba";
    isIsomorphic isIsomorphic = new isIsomorphic();
    System.out.println(isIsomorphic.isIsomorphic(s, t));
  }
  
}
