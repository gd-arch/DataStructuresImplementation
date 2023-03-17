package com.demo.assignment.priorityqueue;

import java.util.*;

public class MyPriorityQueue implements Iterable<Item> {
    private static Comparator<Item> reverseComparator = Comparator.comparing(Item::getPriority).reversed();
    private final ArrayList<Item> items;

    public MyPriorityQueue() {
        items = new ArrayList<>();
    }

    public MyPriorityQueue(int size) {
        items = new ArrayList<>(size);
    }

    public void enqueue(int val, int priority) {
        //Add the element at last
        items.add(new Item(val, priority));
        //call upheapify on current index
        upHeapify(items.size() - 1);
    }

    private void upHeapify(int index) {
        if (reverseComparator == null) {
            if (index == 0) return;
            int parentIndex = (index - 1) / 2;
            //if value of parent is smaller then swap value with current index
            if (items.get(parentIndex).compareTo(items.get(index)) > 0) {
                swap(parentIndex, index);
                downHeapify(parentIndex);

            }
            //if we are on the root node then return
        } else {
            if (index == 0) return;
            int parentIndex = (index - 1) / 2;
            //if value of parent is smaller then swap value with current index
            if (reverseComparator.compare(items.get(parentIndex), items.get(index)) > 0) {
                swap(parentIndex, index);
                upHeapify(parentIndex);

            }
        }


    }
    //Helper function of up heapify and down heapify

    private void swap(int parentIndex, int index) {
        Item temp = items.get(parentIndex);
        items.set(parentIndex, items.get(index));
        items.set(index, temp);
    }

    public Item dequeue() {
        if (size() == 0) {
            System.out.println("Underflow");
            return null;
        }
        //swap with last element because shifting the whole array one step ahead if root is removed will take 0(n)
        swap(0, size() - 1);
        //remove the last element
        Item item = items.remove(items.size() - 1);
        downHeapify(0);
        return item;

    }

    //find the min value between parent and child swap if parent not equal to min value
    private void downHeapify(int parentIndex) {
        if (reverseComparator == null) {
            int minIndex = parentIndex;
            int leftChildIndex = 2 * parentIndex + 1;
            int rightChildIndex = 2 * parentIndex + 2;
            //check if left index exists and its value is less than parent index and if yes then change minIndex
            if (leftChildIndex < items.size() && items.get(leftChildIndex).compareTo(items.get(minIndex)) < 0) {
                minIndex = leftChildIndex;
            }
            //check if right index exists and its value is less than parent index and if yes then change minIndex
            if (rightChildIndex < items.size() && items.get(rightChildIndex).compareTo(items.get(minIndex)) < 0) {
                minIndex = rightChildIndex;
            }
            //swap if minIndex is not equal to parent
            if (minIndex != parentIndex) {
                swap(parentIndex, minIndex);
                //call downheapify on minIndex because the swapped value may come lower in the tree
                downHeapify(minIndex);
            }
        } else {
            int minIndex = parentIndex;
            int leftChildIndex = 2 * parentIndex + 1;
            int rightChildIndex = 2 * parentIndex + 2;
            //check if left index exists and its value is less than parent index and if yes then change minIndex
            if (leftChildIndex < items.size() && reverseComparator.compare(items.get(leftChildIndex), (items.get(minIndex))) < 0) {
                minIndex = leftChildIndex;
            }
            //check if right index exists and its value is less than parent index and if yes then change minIndex
            if (rightChildIndex < items.size() && reverseComparator.compare(items.get(rightChildIndex), (items.get(minIndex))) < 0) {
                minIndex = rightChildIndex;
            }
            //swap if minIndex is not equal to parent
            if (minIndex != parentIndex) {
                swap(parentIndex, minIndex);
                //call downheapify on minIndex because the swapped value may come lower in the tree
                downHeapify(minIndex);
            }


        }
    }

    //returns the highest priority element
    public int peek() {
        if (size() == 0) {
            System.out.println("underflow");
            return -1;
        }
        return items.get(0).getValue();
    }

    public int size() {
        return items.size();
    }

    public boolean contains(int val) {
        for (Item item : items) {
            if (item.getValue() == val) return true;
        }
        return false;

    }

    public int center() {
        MyPriorityQueue pq = new MyPriorityQueue(this.items.size());
        for (Item item : this.items) {
            pq.items.add(item);
        }
        int mid = pq.size() / 2;
        while (mid-- > 0) {
            pq.dequeue();
        }
        return pq.dequeue().getValue();

    }

    //Empties the priority queue while iterating
    public Iterator<Item> iterator() {

        return new MyPriorityQueueIterator();
    }

    public void reverse() {
        if (reverseComparator == null) {
            reverseComparator = Comparator.comparing(Item::getPriority).reversed();
        } else {
            reverseComparator = null;
        }
        //Reverse the heap by heapifying internal nodes
        for (int internalNodeIndex = (items.size() - 2) / 2; internalNodeIndex >= 0; --internalNodeIndex)
            downHeapify(internalNodeIndex);

    }

    public void print() {
        MyPriorityQueue pq = new MyPriorityQueue(this.items.size());

        for (Item item : this.items) {
            pq.items.add(item);
        }
        while (pq.size() > 0) {
            System.out.print(pq.dequeue() + " ");
        }
        System.out.println();


    }

    public class MyPriorityQueueIterator implements Iterator<Item> {

        @Override
        public boolean hasNext() {
            return items.size() > 0;
        }

        @Override
        public Item next() {
            return dequeue();
        }
    }


}

class Item implements Comparable<Item> {
    private final int value;
    private final int priority;

    public Item(int value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    public int getValue() {
        return value;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Item o) {
        return this.priority - o.priority;
    }

    @Override
    public String toString() {
        return "{" + "value=" + value + ", priority=" + priority + '}';
    }
}

