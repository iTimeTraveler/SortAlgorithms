package com.example;

import java.util.*;

/**
 * 排序算法测试类
 */
public class Test {
    private static Bench.Function<int[], int[]> algorithm =
        // Change to Bench.quickSort or Bench.mergeSort as appropriate.
        Bench.shellSort;

    private static boolean check(int[] array) {
        int[] reference = Arrays.copyOf(array, array.length);
        int[] result;
        Arrays.sort(reference);

        try {
            result = algorithm.apply(Arrays.copyOf(array, array.length));
        } catch (Exception|StackOverflowError e) {
            failed(array, reference);
            System.out.println("Threw exception:");
            e.printStackTrace(System.out);
            return false;
        }

        if (!Arrays.equals(result, reference)) {
            failed(array, reference);
            System.out.println("Actual answer: " + show(result));
            return false;
        }

        return true;
    }

    private static void failed(int[] array, int[] reference) {
        System.out.println("Failed!");
        System.out.println("Input array: " + show(array));
        System.out.println("Expected answer: " + show(reference));
    }

    private static String show(int[] array) {
        StringBuilder result = new StringBuilder();
        result.append("{");
        if (array.length > 0) result.append(array[0]);
        for (int i = 1; i < array.length; i++) {
            result.append(", ");
            result.append(array[i]);
        }
        result.append("}");
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        for (int size = 0; ; size++) {
            System.out.printf("Testing on arrays of size %d...\n", size);
            int[] sortedSample = Bench.generateSample(size, 0);
            int[] partiallySortedSample = Bench.generateSample(size, 5);
            int[] randomSample = Bench.generateSample(size, 100);

            if (!check(sortedSample)) return;
            if (!check(partiallySortedSample)) return;
            if (!check(randomSample)) return;
        }
    }
}
