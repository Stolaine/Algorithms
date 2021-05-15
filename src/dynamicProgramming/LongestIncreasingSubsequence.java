package dynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;

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

    public ArrayList<Integer> getLisList(int[] arr) {
        ArrayList<SortedList> sortedLists = new ArrayList<>();
        int size = arr.length;
        Collections.sort(sortedLists);
        for (int i=0; i<size; i++) { // n
            int curr = arr[i];
            boolean added = false;
            for (int j=sortedLists.size()-1; j>=0; j--) {
                int largestElement = sortedLists.get(j).elements.get(sortedLists.get(j).length-1);
                if (largestElement<curr) {
                    SortedList sortedList = new SortedList();
                    sortedList.elements = (ArrayList<Integer>) sortedLists.get(j).elements.clone();
                    sortedList.addElement(curr);
                    added = true;
                    for (int k=0; k<sortedLists.size(); k++) {
                        if (sortedLists.get(k).length == sortedList.length) {
                            sortedLists.remove(k);
                            break;
                        }
                    }
                    sortedLists.add(sortedList);
                    Collections.sort(sortedLists);
                    break;
                }
            }
            if (!added) {
                SortedList sortedList = new SortedList();
                sortedList.addElement(curr);
                for (int j=0; j<sortedLists.size(); j++) {
                    if (sortedLists.get(j).length == 1) {
                        sortedLists.remove(j);
                        break;
                    }
                }
                sortedLists.add(sortedList);
            }
            Collections.sort(sortedLists);
        }
        return sortedLists.get(sortedLists.size()-1).elements;
    }

    public ArrayList<Integer> getLisListApproachTwo(int[] arr) {
        int size = arr.length;
        ArrayList<Integer> elements = new ArrayList<>();
        for (int i=0; i<size; i++) { // n
            int curr = arr[i];
            int index = Collections.binarySearch(elements, curr); // log n
            if (index<0) {
                index = -(index+1);
                if (index<elements.size()) {
                    elements.remove(index);
                }
                elements.add(index, curr);
            }
        }
        return elements;
    }

}

class SortedList implements Comparable<SortedList>{
    int length;
    ArrayList<Integer> elements;

    public SortedList() {
        length = 0;
        elements = new ArrayList<>();
    }

    void addElement(int element) {
        elements.add(element);
        Collections.sort(elements);
        length = elements.size();
    }

    void updateLength() {
        length = elements.size();
    }

    @Override
    public int compareTo(SortedList list) {
        if (this.length < list.length) {
            return -1;
        } else if (this.length > list.length) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}
