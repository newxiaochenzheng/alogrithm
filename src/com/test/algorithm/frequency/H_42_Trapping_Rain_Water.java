package com.test.algorithm.frequency;

public class H_42_Trapping_Rain_Water {
    public static void main(String[] args) {
        int[] array = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new H_42_Trapping_Rain_Water().trap(array));
    }

    /**
     * For instance, at the very beginning, if leftMax = 2, rightMax = 5, then we move left pointer from index 0 to index 1 since left bar is smaller. For index 1, left bar is 2, we can conclude that the area in position 1 is 2. Let us analysis two possible conditions:
     * Condition 1: there exists another bar with height h, as 2 < h < 5, then position 1 can fill water with 2 units, even though water will be blocked by the middle bar
     * Condition 2: there exists another bar with height h, as 2 > h, then position 1 still can fill water with 2 units (in other words, if there does not exist any bars greater than 2, then water will fill out every position until reach the right most bar with height 5)
     * So anything in the middle of leftMax bar and rightMax bar will not influence how much water can current position trap
     * Overall, similar to problem 11, we only need to track whether leftMax is smaller than rightMax or not (shorter bar will determine volume of water 木桶原理)
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        int low = 0;
        int high = height.length - 1;
        int lowMax = height[low];
        int highMax = height[high];
        int sum = 0;
        while (low <= high) {
            lowMax = Math.max(lowMax, height[low]);
            highMax = Math.max(highMax, height[high]);
            if (lowMax < highMax) {
                sum += lowMax - height[low];
                low++;
            } else {
                sum += highMax - height[high];
                high--;
            }
        }
        return sum;
    }

}
