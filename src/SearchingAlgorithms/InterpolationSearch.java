package SearchingAlgorithms;

public class InterpolationSearch {
    static int interpolationSearch(int[] arr, int num, int size){
        int index = -1;
        int lo = 0;
        int hi = size-1;
        int pos = lo + (int)(((float)(num-arr[lo])*(hi-lo))/(arr[hi]-arr[lo]));
        while(pos<size){
            if(arr[pos]==num){
                index = pos;
                break;
            }
            else if(arr[pos]>num){
                hi = pos-1;
            }
            else if(arr[pos]<num){
                lo = pos+1;
            }
            pos = lo + (((num-arr[lo])*(hi-lo))/(arr[hi-arr[lo]]));
        }
        return index;
    }
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 5, 6, 7, 8};
        int size = 7;
        int num = 8;
        int index = interpolationSearch(arr, num, size);
        System.out.println(index);
        System.out.print("");
    }
}
