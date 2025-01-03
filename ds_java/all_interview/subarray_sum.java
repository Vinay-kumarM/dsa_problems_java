package all_interview;

import java.util.HashMap;
import java.util.Map;

public class subarray_sum {
    public static int countSubarrays(int arr[], int k) {
        // code here
        int res = 0;
        int sum = 0;/*
                     * brute force
                     * for(int i=0;i<arr.length;i++){
                     * long subsum=0;
                     * for(int j=i;j<arr.length;j++){
                     * subsum+=arr[j];
                     * if(subsum==k) res++;
                     * }
                     * }
                     * return res;
                     */
        // using prefix sum which is storing sum of array till that index and
        // subtracting previous
        // so we get its value math formula sum=prevsum[j]-prevsum[i-1] gives sum of
        // subarray(i,j)
        // as we need k so it will k=prevsum[j]-prevsum[i-1] then we count usinf sliding
        // window ie single
        // for loop we get all index that are valid by formula
        // if hashmap contains k-prevsum[j] then we have a sub array count++;
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1); // Initialize the hashmap with sum 0 occurring once
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (hm.containsKey(sum - k)) {
                res += hm.get(sum - k);

            }
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 2, 0, -2, -20, 10 };
        int k = -10;// [10, 2, -2, -20, 10], k = -10 ot=3;
        System.out.println(countSubarrays(arr, k));
    }
}
