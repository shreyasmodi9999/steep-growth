package com.shreyas.growth;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] input = new int[]{2, 1, 5, 6, 2, 3};
        if (10 == LargestRectangleInHistogram.largestRectangleArea(input)) {
            System.out.println("Pass");
        } else {
            System.out.println("Retry");
        }
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() &&
                    heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                right[i] = heights.length - 1;
            } else {
                right[i] = stack.peek() - 1;
            }
            stack.push(i);

        }
        for (int i = 0; i < heights.length; i++) {
            System.out.print(right[i] + ",");
        }
        stack.clear();
        System.out.println();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() &&
                    heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                left[i] = 0;
            } else {
                left[i] = stack.peek() + 1;
            }
            stack.push(i);
            System.out.print(left[i] + ",");
        }

        int max = heights[0];
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, heights[i] * (right[i] - left[i] + 1));
        }
        return max;

    }
}

