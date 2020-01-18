package com.sample.question.hasTable;

import com.sample.question.linkedlist.SinglyLinkedList;
import com.sample.question.linkedlist.SinglyLinkedList.Node;

import java.util.HashSet;

public class RemoveDuplicatesFromLL {

    public static <V> void removeDuplicatesWithHashing(SinglyLinkedList<V> list) {
        Node current = list.getHeadNode();
        Node prevNode = list.getHeadNode();
        //will store all the elements that we observe once
        HashSet<V> visitedNodes = new HashSet<V>();

        if (!list.isEmpty() && current.nextNode != null) {
            while (current != null) {
                //check if already visited then delete this node
                if (visitedNodes.contains(current.data)) {
                    //deleting the node by undating the pointer of previous node
                    prevNode.nextNode = current.nextNode;
                    current = current.nextNode;
                } else {
                    //if node was not already visited then add it to the visited set
                    visitedNodes.add((V) current.data);
                    //moving on to next element in the list
                    prevNode = current;
                    current = current.nextNode;
                }
            }
        }
    }
    public static void main(String args[]) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>(); // created linked list

        for(int i = 1; i <= 8; i++) {
            list.insertAtHead(i);      // inserting data in list
        }
        //inserting duplicates
        list.insertAtHead(2);
        list.insertAtHead(4);
        list.insertAtHead(1);

        System.out.println("List before deleting duplicates from list :");
        list.printList();
        removeDuplicatesWithHashing(list); // calling removeDuplicatesWithHashing function
        System.out.println("List after deleting duplicates from list :");
        list.printList();
    }

}
