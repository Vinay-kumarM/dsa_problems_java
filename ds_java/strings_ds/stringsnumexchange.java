
/*Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
Return the sorted string. If there are multiple answers, return any of them.
Example 1:
Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.*/
import java.util.*;
import java.util.stream.*;

public class stringsnumexchange {
    static String func(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        // directly we cannot sort hash elements so we store all elements in linked list
        // sort them and then append
        // List<Map.Entry<Character, Integer>> li = new LinkedList<Map.Entry<Character,
        // Integer>>(hm.entrySet());
        List<Map.Entry<Character, Integer>> li = hm.entrySet().stream().collect(Collectors.toList());
        Collections.sort(li, (i1, i2) -> i2.getValue().compareTo(i1.getValue()));
        StringBuilder ss = new StringBuilder();
        for (Map.Entry<Character, Integer> hi : li) {
            char key = hi.getKey();
            int freq = hi.getValue();
            for (int i = freq; i > 0; i--) {
                ss.append(key);
            }

        }
        return ss.toString();
    }

    public static void main(String[] args) {
        String s = "tree";
        System.out.println(func(s));
    }
}
