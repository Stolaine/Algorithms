package SearchingAlgorithms;

public class ExponentialSearch {
    static int exponentialSearch(int[] arr, int num, int size){
        int index = -1;
        int arr_size = 1;
        while(arr_size<size && arr[arr_size]<num){
            arr_size = arr_size*2;
        }
        if(arr_size<size){
            int left = arr_size/2;
            int right = arr_size;
            int mid = (left+right)/2;
            while(left<=right){
                if(arr[mid]>num){
                    right = mid-1;
                }
                else if(arr[mid]<num){
                    left = mid+1;
                }
                else if(arr[mid] == num){
                    index = mid;
                    break;
                }
                mid = (left+right)/2;
            }
        }
        return index;
    }
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 5, 6, 7, 8};
        int size = 7;
        int num = 6;
        int index = exponentialSearch(arr, num, size);
        System.out.println(index);
        System.out.print("");
    }
}
