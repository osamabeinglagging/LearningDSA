package dev.liquid.sort;

public class QuickSort {
    public static void sort(int[] arr){
        quickSort(arr, 0, arr.length-1);
    }

    static void quickSort(int[] arr, int j, int pivot){
        if(j > pivot) return;
        int i = j-1;
        int start = j;

        for(; j < pivot; j++){
            if(arr[j] < arr[pivot]){
                swap(arr, ++i, j);
            }
        }
        swap(arr, ++i, pivot);
        quickSort(arr, start, i-1);
        quickSort(arr, i+1, pivot);
    }

//    stackoverflow is actually goated - who figured this shit out
//    0001 -> 1 = i
//    0010 -> 2 = j
//    -------------
//    0011 -> 3 = i
//
//    0011 -> i
//    0010 -> j
//    -------------
//    0001 -> 1 = j
//
//    0011
//    0001
//    --------------
//    0010 -> 2 -> i
    static void swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
