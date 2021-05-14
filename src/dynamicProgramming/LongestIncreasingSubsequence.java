package dynamicProgramming;

import java.util.ArrayList;

public class LongestIncreasingSubsequence {
    public int getLIS(int[] arr) { // O(N^2)
        int max = Integer.MIN_VALUE;
        int size = arr.length;
        int[] l = new int[arr.length];
        l[0] = 1;
        for (int i=1; i<size; i++) { // O(N)
            int tempMax = Integer.MIN_VALUE;
            for (int j=0; j<i; j++) { // O(N)
                if (arr[j]<arr[i]) {
                    if (tempMax<l[j]) {
                        tempMax = l[j];
                    }
                }
            }
            if (tempMax != Integer.MIN_VALUE) {
                l[i] = 1+tempMax;
            } else {
                l[i] = 1;
            }
        }
        for (int i=0; i<size; i++) { // O(N)
            if (max<l[i]) {
                max = l[i];
            }
        }
        return max;
    }
}
