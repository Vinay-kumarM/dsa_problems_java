import java.util.*;

/*A substring is a contiguous (non-empty) sequence of characters within a string.
A vowel substring is a substring that only consists of vowels ('a', 'e', 'i', 'o', and 'u') and has all five vowels present in it.
Given a string word, return the number of vowel substrings in word.
Example 1:
Input: word = "aeiouu"
Output: 2
Explanation: The vowel substrings of word are as follows (underlined):
- "aeiouu"
- "aeiouu"*/
public class vowel_substr_count {
    public static int countVowelSubstrings(String word) {
        String vow = "aeiou";
        int count = 0;
        for (int i = 0; i < word.length() - 4; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < word.length(); j++) {
                if (vow.indexOf(word.charAt(j)) > -1) {
                    set.add(word.charAt(j));
                    if (set.size() == 5) {
                        count++;
                    }
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s1 = "aeiouu";// 2
        String s2 = "unicornarihan";// 0
        String s3 = "cuaieuouac";// 7
        System.out.println(countVowelSubstrings(s1));
        System.out.println(countVowelSubstrings(s2));
        System.out.println(countVowelSubstrings(s3));
    }

}
