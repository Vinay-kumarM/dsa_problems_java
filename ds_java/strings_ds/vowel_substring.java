public class vowel_substring {
    public static String funti(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int cur_s = 0;
        // int cur_end = k;
        int cur_vow = vow(s.substring(cur_s, k));
        int max_vow = cur_vow;
        // sliding window method current 5 letters then it moves to+1
        for (int i = k; i < s.length(); i++) {
            // checks if previous is vowel if it is it deducts s that we have an idea of max
            // vowels
            if (vow(String.valueOf(s.charAt(i - k))) > 0) {
                cur_vow--;

            }
            // if this new substring has vowel updates vowel count
            if (vow(String.valueOf(s.charAt(i))) > 0) {
                cur_vow++;
            }
            if (cur_vow > max_vow) {
                max_vow = cur_vow;
                cur_s = i - k + 1;
            }
        }
        return s.substring(cur_s, cur_s + k);
    }

    static int vow(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if ("aeiou".indexOf(s.charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s1 = "caberqiitefg";
        int k1 = 5;
        System.out.println(funti(s1, k1));
    }
}