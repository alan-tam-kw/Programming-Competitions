/*
Task: 
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of
the three integers. You may assume that each input would have exactly one solution.

Example:
Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/


class Solution {
  public int threeSumClosest(int[] nums, int target) {
        int sum = Integer.MAX_VALUE;
        int currentSum;
        int difference = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                currentSum = nums[i] + nums[j] + nums[k];
                
                if (currentSum == target)
                    return target;
              
                int d = Math.abs(target - currentSum);
                if (d < difference) {
                    difference = d;
                    sum = currentSum;
                }
                
                if (currentSum < target)
                    j++;
                else
                    k--;
            }
        }
        return sum;  
    }
}
