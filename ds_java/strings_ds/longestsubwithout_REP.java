import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;

public class longestsubwithout_REP {
    public static void funti(String s) {
        int arr[] = new int[256];
        /*
         * HashSet<Character> hs=new HashSet<>();
         * int l=0,r=0;
         * int res=0,temp=0;
         * while(r<s.length()&&l<s.length()){
         * if(hs.contains(s.charAt(r))){
         * 
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
