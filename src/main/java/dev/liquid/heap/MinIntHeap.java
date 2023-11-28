package dev.liquid.heap;

import java.util.Arrays;

// https://www.youtube.com/watch?v=t0Cq6tVNRBA
// https://www.youtube.com/watch?v=HqPJF2L5h9U
// Yes I know this implementation is completely identical but i do understand how it works
// This is the only way i understand the process so this is the way im implementing it

// Works - Verified by ChatGPT.
public class MinIntHeap {
  private int capacity;
  private int size = 0;
  private int[] items;

  public MinIntHeap(int capacity) {
    this.capacity = capacity;
    items = new int[this.capacity];
  }

  private int getLeftChildIndex(int parentIndex) {
    return 2 * parentIndex + 1;
  }

  private int getRightChildIndex(int parentIndex) {
    return 2 * parentIndex + 2;
  }

  private int getParentIndex(int childIndex) {
    return (childIndex - 1) / 2;
  }

  private boolean hasLeftChild(int parentIndex) {
    return this.getLeftChildIndex(parentIndex) < this.size;
  }

  private boolean hasRightChild(int parentIndex) {
    return this.getLeftChildIndex(parentIndex) < this.size;
  }

  private boolean hasParent(int childIndex) {
    return this.getParentIndex(childIndex) >= 0;
  }

  private int getLeftChild(int parentIndex) {
    return this.items[this.getLeftChildIndex(parentIndex)];
  }

  private int getRightChild(int parentIndex) {
    return this.items[this.getRightChildIndex(parentIndex)];
  }

  private int getParent(int childIndex) {
    return this.items[this.getParentIndex(childIndex)];
  }

  private void swap(int firstItemIndex, int secondItemIndex) {
    int temp = this.items[firstItemIndex];
    this.items[firstItemIndex] = this.items[secondItemIndex];
    this.items[secondItemIndex] = temp;
  }

  private void ensureCapacity() {
    if (size == capacity) {
      this.capacity *= 2;
      this.items = Arrays.copyOf(this.items, this.capacity); // Didnt know copyOf is a thing before today
    }
  }

  public int peek() {
    if (this.size == 0) throw new IllegalStateException();
    return this.items[0];
  }

  public int poll() {
    if (this.size == 0) throw new IllegalStateException();
    int item = this.items[0];
    this.items[0] = this.items[this.size - 1];
    this.size--;
    this.heapifyDown();
    return item;
  }

  public void add(int value) {
    this.ensureCapacity();

    this.items[this.size] = value;
    this.size++;
    this.heapifyUp();
  }


  private void heapifyUp() {
    int index = this.size - 1;
    while (this.hasParent(index) && this.getParent(index) > this.items[index]) {
      this.swap(this.getParentIndex(index), index);
      index = this.getParentIndex(index);
    }
  }

  private void heapifyDown() {
    int index = 0;
    while (this.hasLeftChild(index)) {
      int smallChildIndex = this.getLeftChildIndex(index);
      if (this.hasRightChild(index) && this.getLeftChild(index) > this.getRightChild(index)) {
        smallChildIndex = this.getRightChildIndex(index);
      }

      if (this.items[index] > this.items[smallChildIndex]) {
        swap(index, smallChildIndex);
        index = smallChildIndex;
      } else {
        break;
      }
    }
  }

  @Override
  public String toString() {
    StringBuilder string = new StringBuilder();
    string.append("[");
    for (int i : this.items) {
      string.append(String.valueOf(i) + ", ");
    }
    string.append("]");

    return string.toString();
  }
}
