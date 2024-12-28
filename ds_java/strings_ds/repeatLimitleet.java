
/*You are given a string s and an integer repeatLimit. Construct a new string repeatLimitedString using the characters of s such that no letter appears more than repeatLimit times in a row. You do not have to use all characters from s.
 * Input: s = "cczazcc", repeatLimit = 3
Output: "zzcccac"
 */
package strings_ds;

import java.util.*;

public class repeatLimitleet {
    public static String repeatLimitedString(String s, int repeatLimit) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> Character.compare(b, a));// lexographically arranged
        for (char ch : hm.keySet()) {
            pq.offer(ch);
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            char ch = pq.poll();
            int val = hm.get(ch);
            int use = Math.min(val, repeatLimit);
            for (int i = 0; i < use; i++) {
                sb.append(ch);
            }
            hm.put(ch, hm.get(ch) - use);
            if (hm.get(ch) > 0 && !pq.isEmpty()) {
                char nextchar = pq.poll();
                sb.append(nextchar);
                hm.put(nextchar, hm.get(nextchar) - 1);
                if (hm.get(nextchar) > 0) {
                    pq.offer(nextchar);
                }
                pq.offer(ch);
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "cczazcc";// zzcccac"
        int repeatLimit = 3;
        System.out.println(repeatLimitedString(s, repeatLimit));
    }
}
