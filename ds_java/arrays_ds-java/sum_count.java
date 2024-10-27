public class sum_count {
    public static int respro(int arr[], int k) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // int[] arr = { 2, 3, -8, 7, -2, 2, 3 };
        // int arr[] = { 1, 1, 1 };// op=2
        int arr[] = { 1, 2, 3 };// op=2
        // System.out.println(respro(arr, 5));
        // System.out.println(respro(arr, 2));
        System.out.println(respro(arr, 3));
    }
}
