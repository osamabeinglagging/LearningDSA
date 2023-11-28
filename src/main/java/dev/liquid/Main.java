package dev.liquid;

import dev.liquid.heap.MinIntHeap;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
  public static void main(String[] args) {
    MinIntHeap heap = new MinIntHeap(10);
    int[] testData1 = {8, 4, 10, 2, 7, 5, 1, 9, 3, 6};
    for(int data: testData1){
      heap.add(data);
    }
    System.out.println(heap);
  }
}