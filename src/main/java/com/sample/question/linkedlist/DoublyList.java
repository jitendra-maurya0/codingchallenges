package com.sample.question.linkedlist;

public class DoublyList {

    DNode head;

    public void add(int el){
        if(head == null){
            head = new DNode(el);
        }else{
            while (head.next != null){
                head = head.next;
            }
            DNode d = new DNode(el);

            head.next =d;
            d.prev = head;
            head = d;
        }
    }

    public void display(){
        while (head.next != null){
            System.out.print(" "+head.data);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        int[]arr = {1,2,3,5};
        DoublyList doublyList = new DoublyList();
        for(Integer i: arr){

            doublyList.add(i);
        }
        doublyList.display();
    }
}
