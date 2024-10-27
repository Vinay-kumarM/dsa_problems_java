/*Given a 0-indexed string s, permute s to get a new string t such that:
All consonants remain in their original places. More formally, if there is an index i with 0 <= i < s.length such that s[i] is a consonant, then t[i] = s[i].
The vowels must be sorted in the nondecreasing order of their ASCII values. More formally, for pairs of indices i, j with 0 <= i < j < s.length such that s[i] and s[j] are vowels, then t[i] must not have a higher ASCII value than t[j].
Return the resulting string.
The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in lowercase or uppercase. Consonants comprise all letters that are not vowels.
Example 1:
Input: s = "lEetcOde"
Output: "lEOtcede"
Explanation: 'E', 'O', and 'e' are the vowels in s; 'l', 't', 'c', and 'd' are all consonants. The vowels are sorted according to their ASCII values, and the consonants remain in the same places. */

import java.util.Arrays;

public class sorting_vowel_string {
    public static String sortVowels(String s) {
        char[] arr = new char[s.length()];
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            if ("aeiouAEIOU".indexOf(s.charAt(i)) != -1) {
                arr[idx++] = s.charAt(i);
            }
        }
        Arrays.sort(arr, 0, idx);// sort only vowels cose while sorting all the null values comes so we are
                                 // sorting only values where chars are present
        int vow = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ("aeiouAEIOU".indexOf(s.charAt(i)) != -1) {
                // sb.replace(sb.chartAt(i),arr[vow++]);
                // sb.replace(index, index + 1, String.valueOf(newChar)); //correct way of doing
                sb.append(arr[vow++]);
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "lEetcOde";// lEOtcede
        String s2 = "lYmpH";// "lYmpH"

        System.out.println(sortVowels(s1));
        System.out.println(sortVowels(s2));
    }

}
