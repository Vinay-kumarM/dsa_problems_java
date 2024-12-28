
/*encrot the sentence such way that sentence contains words and each word than inverse word than vowels
 * will be repalced with next vowel a->e,e->i....u->a, case sensitivity should be
 * followed and first letter should be added to last
 */
package all_interview;

public class encryption {
    public static String encr(String s) {
        StringBuilder sb = new StringBuilder();
        // char[] ae = { 'a', 'e', 'i', 'o', 'u' };
        String[] words = s.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            StringBuilder sv = new StringBuilder(words[i]).reverse();
            for (int j = 0; j < sv.length(); j++) {
                char ch = sv.charAt(j);
                sv.setCharAt(j, replacevow(ch));
            }
            char first = sv.charAt(0);
            sv.deleteCharAt(0);
            sv.append(first);
            sb.append(sv.toString()).append(" ");
        }
        return sb.toString().trim();

    }

    public static char replacevow(char ch) {
        switch (ch) {
            case 'a':
                return 'e';
            case 'e':
                return 'i';
            case 'i':
                return 'o';
            case 'o':
                return 'u';
            case 'u':
                return 'a';
            case 'A':
                return 'E';
            case 'E':
                return 'I';
            case 'I':
                return 'O';
            case 'O':
                return 'U';
            case 'U':
                return 'A';
            default:
                return ch;

        }
    }

    public static void main(String[] args) {
        String s = "hello this is encrypted";
        System.out.println(encr(s));
    }
}
