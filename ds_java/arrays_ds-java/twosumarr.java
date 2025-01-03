/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1]. */

import java.util.Arrays;

public class twosumarr {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    result[0] = j;
                    result[1] = i;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 2, 4 };
        int k = 6;
        System.out.println(Arrays.toString(twoSum(arr, k)));//[2,1]
    }
}
