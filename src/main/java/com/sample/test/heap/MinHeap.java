package com.sample.test.heap;

public class MinHeap {
    int[]heap;
    int size;

    void insert(int item){
        if(size+1 > heap.length) resize();
        heap[size++] = item;

    }

    private void resize() {
        int[] temp = new int[size*2];
    }
}
