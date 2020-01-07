/*
Task

Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n veritcal lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

Example:

Input: [1, 8, 6, 2 ,5, 4, 8, 3, 7]
Output: 49
*/

class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxArea = -1;
        int area;
        int h, w, a, b;
        while (i < j){
                a = height[i];
                b = height[j];
                h = (a < b) ? a : b;
                w = j - (i - 1) - 1;
                area = h * w;
                maxArea = (area > maxArea) ? area : maxArea;
                if (h == a)
                    i++;
                else
                    j--;
        }
        return maxArea;
    }
}
