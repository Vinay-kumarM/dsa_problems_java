
/*The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
Example 1:Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.*/
import java.util.Arrays;

public class nextgreaternum {
    static int[] funti(int[] nums1, int[] nums2) {
        // Stack<Integer> st=new Stack<>();
        int[] arr = new int[nums1.length];
        int idx = 0;

        for (int num : nums1) {
            int nextgreat = -1;
            int j = 0;
            while (j < nums2.length && nums2[j] != num) {
                j++;
            }
            for (int k = j + 1; k < nums2.length; k++) {
                if (nums2[k] > num) {
                    nextgreat = nums2[k];
                    break;
                }
            }
            arr[idx++] = nextgreat;
        }
        /*
         * int arr[]=new int[nums1.length];
         * for(int i=0;i<nums1.length;i++){
         * arr[i]=st.pop();
         * }
         */
        return arr;
    }

    public static void main(String[] args) {
        int nums1[] = { 4, 1, 2 };
        int nums2[] = { 1, 3, 4, 2 };
        System.out.println(Arrays.toString(funti(nums1, nums2)));
    }
}
