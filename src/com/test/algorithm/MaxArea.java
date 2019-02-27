package com.test.algorithm;

public class MaxArea {
    public static void main(String[] args) {
        int[] height = {3, 4, 5, 6, 8, 9, 1, 10, 25, 6, 7, 18};
        System.out.println(new MaxArea().maxArea(height));
        System.out.println(new MaxArea().maxAreaNew1(height));

    }

    public int maxArea(int[] height) {
        /**
         * We could see this problem in a DP view and with some tricks we could do it in a greedy way which is O(n) time complexity.
         * Let's define S(i...j) to be the max volume from index i to j and v(i, j) be the volume of the container with boundary i and j . So we just need to figure out S(0...n) (0 and n are the leftmost and rightmost index of the array).
         * It is easy to derive that S(0..n) = max{v(0, n), S(1...n), S(0...n-1)}, and the time complexity is O(n^2). But we can optimize it. WLOG(without loss of generality), we assume height(0) > height(n), then we can simplify S(0..n) as S(0...n) = max{v(0, n), S(0...n-1)} and the complexity is O(n). Below is the proof :
         * 1, if v(0, n) is the largest volume, sicne we have figured out the result, the simplifier is all right.
         * 2, if not, we could find out that n can't be the boundry of the container. If n is the right boundry, becaues of height(0) > height(n) , the max volumn must be height(n) * (n - 0) = v(0, n), which arrives at a contradiction. So S(1...n) can be simplified as S(1...n-1) which is included in S(0...n-1).
         * The code is from the forum and mainly from https://discuss.leetcode.com/topic/16754/simple-and-fast-c-c-with-explanation/5
         * The relationship can be represented as :
         *
         *            / max{v(i, j), S(i...j-1)};  height(i) >= height(j)
         * S(i..j) = |
         *            \ max{v(i, j), S(i+1...j)};  height(i) < height(j)
         */
        if (height == null || height.length < 2) {
            return 0;
        }
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int w = right - left;
            max = Math.max(max, Math.min(height[left], height[right]) * w);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public int maxAreaNew1(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int max = Math.min(height[left], height[right]) * (right - left);
        while (left < right) {
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
        }
        return max;
    }

    /**
     * https://github.com/PengFTang/Algorithms-in-Java/commit/479a42fdbbf4303d89beef8df9e270a29580110d
     * 优化处理，当左侧遍历发现其值小于lowMax，直接忽略掉
     * @param height
     * @return
     */
    public int maxAreaOptimize(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int low = 0;
        int high = height.length - 1;
        int max = 0;
        while (low < high) {
            int lowMax = height[low];
            int highMax = height[high];
            int tmp = Math.min(height[low], height[high]) * (high - low);
            max = Math.max(tmp, max);
            if (height[low] < height[high]) {
                while (low < high && height[low] <= lowMax) {
                    low++;
                }
            } else {
                while (low < high && height[high] <= highMax) {
                    high--;
                }
            }
        }
        return max;
    }
}
