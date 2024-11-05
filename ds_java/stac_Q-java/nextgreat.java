
/*Example 1:
Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number. 
The second 1's next greater number needs to search circularly, which is also 2. */
import java.util.Arrays;
import java.util.Stack;

public class nextgreat {
    public static int[] nextGreaterElements(int[] nums) {
        int[] arr = new int[nums.length];
        /*
         * for(int i=0;i<nums.length;i++){
         * int j=i+1;
         * int great=-1;
         * while(j!=i){
         * if(j==nums.length){
         * j=0;
         * }
         * if(nums[i]<nums[j]){
         * great=nums[j];
         * break;
         * }
         * j++;
         * 
         * 
         * }
         */ // logically correct but with O(n^2) wont work for large data
        Arrays.fill(arr, -1);
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        for (int i = 0; i < n * 2; i++) {// i%2 for circular check
            int num = nums[i % n];
            while (!st.isEmpty() && nums[i % n] > nums[st.peek()]) {
                // The while loop continues to pop elements from the stack as long as the
                // condition nums[i % n] > nums[st.peek()] is true.
                arr[st.pop()] = nums[i % n];
            }
            st.push(i % n);
        }
        return arr;
    }

    public static void main(String[] args) {
        int nums1[] = { 5, 4, 3, 2, 1 };// [-1,5,5,5,5]
        int nums2[] = { 1, 2, 3, 4, 3 };// [2,3,4,-1,4]
        System.out.println(Arrays.toString(nextGreaterElements(nums1)));
        System.out.println(Arrays.toString(nextGreaterElements(nums2)));
    }
}
