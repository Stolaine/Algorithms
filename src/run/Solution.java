package run;

import dynamicProgramming.LongestIncreasingSubsequence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\shesh\\IdeaProjects\\Algorithms\\src\\interaction\\input.txt"));
        System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\shesh\\IdeaProjects\\Algorithms\\src\\interaction\\output.txt")));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int length = lis.getLIS(arr);
        System.out.println(length);

        ArrayList<Integer> elements = lis.getLisList(arr);
        System.out.println(elements.size());
        for (int element : elements) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
