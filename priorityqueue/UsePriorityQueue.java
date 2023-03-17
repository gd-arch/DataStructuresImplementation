package com.demo.assignment.priorityqueue;



public class UsePriorityQueue {
    public static void main(String[] args) {
        MyPriorityQueue pq = new MyPriorityQueue();
        pq.enqueue(22,4);
        pq.enqueue(100,8);
        pq.enqueue(11,8);
        pq.enqueue(2,2);
        pq.enqueue(22,46);
        pq.enqueue(100,5);
        pq.enqueue(11,6);
        pq.enqueue(2,0);
        pq.print();
        System.out.println("Deque  ="+pq.dequeue());
        System.out.println("Deque  ="+pq.dequeue());


        pq.print();
        System.out.println("Mid value is=" + pq.center());

        System.out.println("Peek value= "+pq.peek());


        pq.print();

        pq.enqueue(2,5);
        pq.enqueue(22,100);
        pq.enqueue(100,45);
        pq.enqueue(11,46);
        pq.enqueue(2,54);

        pq.print();

        System.out.println("Reverse the PQ");
        pq.reverse();
        pq.print();
        System.out.println("For Each loop");
        for(Item item:pq){
            System.out.println(item);

        }








    }
}
