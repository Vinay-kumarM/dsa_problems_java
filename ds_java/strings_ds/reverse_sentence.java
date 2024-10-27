/*Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
Return a string of the words in reverse order concatenated by a single space.
Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.*/
public class reverse_sentence {
    public static String reverseWords(String s) {
        String arr[] = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i] + " ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s1 = "a good   example";// "blue is sky the"
        String s2 = "  hello world  ";// "world hello"
        String s3 = "a good   example";// "a good example"
        System.out.println(reverseWords(s1));
        System.out.println(reverseWords(s2));
        System.out.println(reverseWords(s3));

    }
}
