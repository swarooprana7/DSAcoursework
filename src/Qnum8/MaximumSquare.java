//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Qnum8;

import java.util.Stack;

public class MaximumSquare {
    public MaximumSquare() {
    }

    public static int findMaximumSquare(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea = 0;
        int[] heights = new int[n];

        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    heights[j] = 0;
                } else {
                    int var10002 = heights[j]++;
                }
            }

            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    private static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack();
        int maxArea = 0;

        for(int i = 0; i <= heights.length; ++i) {
            int h = i == heights.length ? 0 : heights[i];
            if (!stack.isEmpty() && h < heights[(Integer)stack.peek()]) {
                int tp = (Integer)stack.pop();
                maxArea = Math.max(maxArea, heights[tp] * (stack.isEmpty() ? i : i - 1 - (Integer)stack.peek()));
                --i;
            } else {
                stack.push(i);
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 0, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 1}, {0, 0, 0, 1, 1}, {0, 1, 0, 1, 1}};
        System.out.println(findMaximumSquare(matrix));
    }
}
