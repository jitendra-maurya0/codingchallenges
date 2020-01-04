package com.sample.test.stack;

import java.util.Stack;

/**
 * create queue using two stack
 */
public class QueueUsingTwoStack {

    Stack s1 = new Stack();
    Stack s2 = new Stack();

    public void enqueue(int x){

        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }

        s1.push(x);

        while (!s2.isEmpty()){
            s1.push(s2.pop());
        }

    }


    public int dequeue(){

        if (s1.isEmpty()) {
            System.out.println("no element exist");
            return -1;
        }

        return  (int)s1.pop();

    }

    public static void main(String[] args) {

        QueueUsingTwoStack queueUsingTwoStack =  new QueueUsingTwoStack();

         queueUsingTwoStack.enqueue(1);
         queueUsingTwoStack.enqueue(2);
         queueUsingTwoStack.enqueue(3);

        System.out.println(queueUsingTwoStack.dequeue());
        System.out.println(queueUsingTwoStack.dequeue());


    }
}
