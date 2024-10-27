
//find next possiible permutation which is next greater posiible in array
/*algorith;-
 *     find right most element which is smaller than next ele(pivot)
 *     fint right most element ehich greater than pivot
 *     swap
 *     reverse all ele after pivot
 */
import java.util.Arrays;

public class nextpermutation {
    public static void respri(int arr[]) {
        int n = arr.length;
        int pivot = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                pivot = i;
                break;
            }
        }
        if (pivot == -1) {
            reverse(arr, 0, n - 1);
        } else {
            for (int i = n - 1; i >= 0; i--) {
                if (arr[pivot] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[pivot];
                    arr[pivot] = temp;
                    break;
                }
            }
            reverse(arr, pivot + 1, n - 1);
        }
        System.out.println(Arrays.toString(arr));

    }

    public static void reverse(int arr[], int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
            // start++;
            // end--;
        }
    }

    public static void main(String[] args) {
        // int[] arr = { 6, 5, 8, 9, 1, 2, 7 };// next possible perm will be 6589172
        int[] arr = { 5, 4, 3, 2, 1 };// reverse edge case
        respri(arr);
    }
}
