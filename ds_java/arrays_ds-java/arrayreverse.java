import java.util.Arrays;

public class arrayreverse {
    static void respri(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
            // start++;
            // end--;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = { 7, 8, 5, 6, 1, 2, 9, 8 };
        respri(arr);
    }
}