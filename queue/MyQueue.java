package com.demo.assignment.queue;

import java.util.*;


public class MyQueue implements Iterable<Integer> {
    private final int[] queue;
    private int front;
    private int size;

    public MyQueue(int cap) {
        queue = new int[cap];
        front = 0;
        size = 0;
    }


    int size() {
        return size;
    }

    void print() {
        int i = 0;
        while (i < size) {
            System.out.print(queue[(front + i) % queue.length] + " ");
            i++;

        }
        System.out.println();
    }
    void sort(){
        int i = 0;
        int[] subArr =new int[size];
        while (i < size) {
           subArr[i]= queue[(front + i) % queue.length] ;
            i++;

        }
        Arrays.sort(subArr);
        i=0;
        while (i < size) {
            queue[(front + i) % queue.length]=subArr[i] ;
            i++;

        }

    }


    void enqueue(int val) {
        if (size == queue.length) {
            System.out.println("Queue overflow");
            return;
        }

        queue[(front + size) % queue.length] = val;
        size++;
    }

    int dequeue() {
        if (size == 0) {
            System.out.println("Queue underflow");
            return -1;
        }
        int element = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return element;
    }

    int peek() {
        if (size == 0) {
            System.out.println("Queue underflow");
            return -1;
        }
        return queue[front];
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyQueueIterator(front, size);
    }

    private class MyQueueIterator implements Iterator<Integer> {
        private final int front;
        private int size;
        private int current;

        public MyQueueIterator(int front, int size) {
            this.front = front;
            this.size = size;
        }

        @Override
        public boolean hasNext() {
            return size > 0;
        }

        @Override
        public Integer next() {
            int val = queue[(front + current) % queue.length];
            current++;
            size--;
            return val;

        }
    }

}
