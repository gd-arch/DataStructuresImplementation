package com.demo.assignment.queue;

public class UseQueue {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(10);
        queue.enqueue(10);
        queue.enqueue(22);
        queue.enqueue(43);
        queue.enqueue(130);
        queue.enqueue(242);
        queue.enqueue(653);
        queue.print();
        System.out.println("Dequeued element ="+queue.dequeue());
        System.out.println("Dequeued element ="+queue.dequeue());
        queue.print();
        System.out.println("Element at peek=" + queue.peek());
        System.out.println("Iterator=");
        for (int a : queue) {
            System.out.println(a);
        }

    }
}
