package com.sample.question.stack;


/**
 * //You can either divide array in two halves or start stacks at extreme ends.
 * //We'll use the second technique to solve this problem.
 * //Top of Stack 1 start from extreme left of array i.e top1 = 0;
 * //Top of Stack 2 start from extreme right of array i.e top2 = size - 1
 * @param <V>
 */
public class TwoStackUsingArray<V> {

    private int maxSize;
    private V[] array;
    private int top1, top2;

    public TwoStackUsingArray(int maxSize, V[] array) {
        this.maxSize = maxSize;
        array = (V[]) new Object[maxSize];
        this.top1 = -1;
        this.top2 = maxSize;
    }

    //insert at top of first stack
    public void push1(V value) {
        if (top1 < top2 - 1) {
            array[++top1] = value;
        }
    }

    //insert at top of second stack
    public void push2(V value) {
        if (top1 < top2 - 1) {
            array[--top2] = value;
        }
    }

    //remove and return value from top of first stack
    public V pop1() {
        if (top1 > -1) {
            return array[top1--];
        }
        return null;
    }

    //remove and return value from top of second stack
    public V pop2() {
        if (top2 < maxSize) {
            return array[top2++];
        }
        return null;
    }
}
