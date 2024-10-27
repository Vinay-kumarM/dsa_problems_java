import java.util.Arrays;

public class arrayrotation {
    /* rotate array to k number of elements to left of the array to right */
    public static void priarray(int arr[], int k) {
        int res[] = new int[arr.length];
        int n = arr.length;
        int idx = 0;
        for (int i = k; i < n; i++) { // adds elements from k to end to the start of new array leaving k elements
                                      // which are gonna add at last
            if (idx >= n) {
                break;
            }
            res[idx++] = arr[i];
        }
        for (int i = 0; i < k; i++) { // adds those remaining ie starting elements to end of res
            res[idx++] = arr[i];
        }
        System.out.println(Arrays.toString(res));
    }

    public static void main(String[] args) {
        int arr[] = { 5, 8, 6, 9, 1, 5, 8 };
        priarray(arr, 6);
    }
}