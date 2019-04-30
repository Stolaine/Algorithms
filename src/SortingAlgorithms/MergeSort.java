package SortingAlgorithms;

public class MergeSort {
    static void merge(int[] arr, int l, int m, int r){
        int n1 = m-l+1; // since 0-based index is used.
        int n2 = r-m;
        int[] left_arr = new int[n1];
        int[] right_arr = new int[n2];
        for(int i=0; i<n1; i++){
            left_arr[i] = arr[l+i];
        }
        for(int i=0; i<n2; i++){
            right_arr[i] = arr[m+1+i];
        }
        int left = 0;
        int right = 0;
        int original = l;
        while(left<n1 && right<n2){
            if(left_arr[left]<=right_arr[right]){
                arr[original++] = left_arr[left++];
            }
            else if(left_arr[left]>right_arr[right]){
                arr[original++] = right_arr[right++];
            }
        }
        for(int i=left; i<n1; i++){
            arr[original++] = left_arr[i];
        }
        for(int i=right; i<n2; i++){
            arr[original++] = right_arr[i];
        }
    }
    static void mergeSort(int[] arr, int l, int r){
        if(r>l){
            int mid = (l+r)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);
            merge(arr, l, mid, r);
        }
    }
    public static void main(String[] args){
        int[] arr = {3, 6, 4, 2, 1, 9, 8};
        mergeSort(arr, 0, arr.length-1);
        for(int i=0; i<7; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
