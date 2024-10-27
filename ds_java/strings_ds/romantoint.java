
/*Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used*/
import java.util.*;

class romantoint {
    public static int funint(String s) {
        // creating hshmap to map all vallues
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && hm.get(s.charAt(i)) < hm.get(s.charAt(i + 1))) {
                num -= hm.get(s.charAt(i));
            } else {
                num += hm.get(s.charAt(i));
            }
        }
        return num;
    }

    public static void main(String[] args) {
        String testcase1 = "III";
        String testcase2 = "LVIII";
        String testcase3 = "MCMXCIV";
        // we can also solve this using switch to
        System.out.println(funint(testcase1));// 3
        System.out.println(funint(testcase2));// 58
        System.out.println(funint(testcase3));// 1994
    }
}