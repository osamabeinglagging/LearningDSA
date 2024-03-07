package dev.liquid.sort;

import java.util.Comparator;

public class QuickSort {
    public static <T> void sort(T[] arr, Comparator<T> comp) {
        quickSort(arr, 0, arr.length - 1, comp);
    }

    static <T> void quickSort(T[] arr, int j, int pivot, Comparator<T> comp) {
        if (j > pivot) return;
        int i = j - 1;
        int start = j;

        for (; j < pivot; j++) {
            if (comp.compare(arr[j], arr[pivot]) < 0) {
                swap(arr, ++i, j);
            }
        }
        swap(arr, ++i, pivot);
        quickSort(arr, start, i - 1, comp);
        quickSort(arr, i + 1, pivot, comp);
    }

    static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
//    static void swap(int[] arr, int i, int j){
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];
//    }

}
