import java.util.*;

public class isomorphic_string {
    public static boolean funt(String str1, String str2) {
        // int arr[]=new int[256];//256 ascii values
        HashMap<Character, Character> hm = new HashMap<>();

        if (str1.length() != str2.length() || str1 == null || str2 == null) {
            return false;
        } else {
            for (int i = 0; i < str1.length(); i++) {
                char s1 = str1.charAt(i);
                char s2 = str2.charAt(i);
                if (hm.containsKey(s1)) {
                    if (hm.get(s1) != str2.charAt(i)) {
                        return false;
                    }
                } else {
                    if (hm.containsValue(s2)) {
                        return false;
                    }
                    hm.put(s1, s2);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "aac";
        String str2 = "xyy";
        System.out.println(funt(str1, str2));
    }

}
