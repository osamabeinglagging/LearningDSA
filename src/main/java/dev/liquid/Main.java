package dev.liquid;

import dev.liquid.heap.MinIntHeap;
import dev.liquid.sort.QuickSort;

import java.util.Arrays;
import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
  public static void main(String[] args) {
    MinIntHeap heap = new MinIntHeap(10);
    Integer[] testData1 = {8, 4, 10, 2, 7, 5, 1, 9, 3, 6};
    int[] arr = generateUnsortedArray(200);

    Integer[] integerArray = new Integer[arr.length];
    for (int i = 0; i < arr.length; i++) {
      integerArray[i] = arr[i];
    }
    QuickSort.sort(integerArray, Integer::compareTo);
    System.out.println(Arrays.toString(integerArray));
  }

  private static int[] generateUnsortedArray(int size) {
    int[] array = new int[size];
    Random random = new Random();

    for (int i = 0; i < size; i++) {
      array[i] = random.nextInt(1000); // Generates random integers between 0 and 999
    }

    return array;
  }
}