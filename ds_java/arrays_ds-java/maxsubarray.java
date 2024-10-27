//solved using kaydens algorithm O(n) orelse it would need to check all posibilities o[n^2]
public class maxsubarray {
    public static int maxSubarraySum(int arr[]) {
        int n = arr.length;
        int maxi = Integer.MIN_VALUE;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(arr[i] + maxi, arr[i]);
            res = Math.max(res, maxi);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, -8, 7, -1, 2, 3 };
        System.out.println(maxSubarraySum(arr));
    }
}