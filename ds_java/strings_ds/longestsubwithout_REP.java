import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;

public class longestsubwithout_REP {
    public static void funti(String s) {
        int arr[] = new int[256];
        /*//correct and efficent 0(n);
         *  int length=0;
       int left=0;
       HashSet<Character> hm=new HashSet<>();
       for(int right=0;right<s.length();right++){
           char c=s.charAt(right);
           while(hm.contains(c)){
               hm.remove(s.charAt(left));
               left++;
           }
           hm.add(s.charAt(right));
           length=Math.max(length,right-left+1);
       }
       return length;
         * }
         * }
         */
        int res = 0;
        Arrays.fill(arr, 0);
        for (int i = 0; i < s.length(); i++) {
            int len = 0;
            for (int j = i; j < s.length(); j++) {
                if (arr[s.charAt(j)] == 1) {
                    break;
                }
                len = j - i + 1;
                arr[s.charAt(j)]++;
            }
            res = Math.max(res, len);
             Arrays.fill(arr, 0);
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        String s1 = "abcabcdefga";
        funti(s1);
    }
}
