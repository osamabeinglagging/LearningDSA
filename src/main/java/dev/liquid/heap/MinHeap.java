package dev.liquid.heap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

// Starts from 1
public class MinHeap<T>{
    private T[] items;
    private int size;
    private int capacity;
    private final Comparator<T> comp;

    // Thank you 15yo stackoverflow post
    @SuppressWarnings("unchecked")
    public MinHeap(Class<T> clazz, Comparator<T> comp, int capacity){
        this.capacity = capacity;
        this.items = (T[]) Array.newInstance(clazz, capacity);
        this.comp = comp;
        this.size = 0;
    }

    public void add(T elem){
        if(this.size >= capacity){
            this.capacity *= 2;
            this.items = Arrays.copyOf(this.items, this.capacity);
        }
        this.items[++this.size] = elem;
        this.heapUp(this.size);
    }

    public void heapUp(int index){
        int parentIndex = index >>> 1;
        while(parentIndex > 0 && this.comp.compare(this.items[index], this.items[parentIndex]) < 0){
            swap(parentIndex, index);
            index = parentIndex;
            parentIndex = index >>> 1;
        }
    }

    public void heapDown(int index){
        int start = index;
        int smallChild = index << 1;
        while(smallChild <= this.size){
            if(this.comp.compare(this.items[smallChild], this.items[smallChild+1]) > 0){
                ++smallChild;
            }
            swap(smallChild, start);
        }
    }

    public void swap(int i1, int i2){
        T temp = this.items[i1];
        this.items[i1] = this.items[i2];
        this.items[i2] = temp;
    }

}
