package com.sample.question.queue;

import java.util.*;

public class PriorityQueueTest {

    void testQueue(){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<5;i++){
            Random random = new Random();
            int rand = random.nextInt(10);
            queue.offer(rand);
            list.add(rand);
        }

        System.out.println("Testing priority queue");
        while (!queue.isEmpty()){
            System.out.print(" "+queue.poll());
        }
        System.out.println("\n List printing");
        for (Integer j: list){
            System.out.print(" "+j);
        }

    }

    public static void main(String[] args) {
        PriorityQueueTest priorityQueueTest = new PriorityQueueTest();
        priorityQueueTest.testQueue();

    }
}
