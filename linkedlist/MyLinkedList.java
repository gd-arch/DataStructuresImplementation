package com.demo.assignment.linkedlist;

import java.util.Iterator;


public class MyLinkedList implements Iterable<Integer> {

    private Node head;
    private int size;

    //Insert Element at last of linked list
    public void insert(int data) {

        //create a new node
        Node newNode = new Node(data);
        //if the linked list has no element mark new node as head and return
        if (head == null) {
            head = newNode;

        } else {
            //traverse to the last element in linked list and mark next of last node equal to the new node
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;

        }
        size++;


    }

    //insert element at an index
    public void insertAt(int position, int data) {

        //invalid input-if input index is more than list size or less than list size
        //pos=0 insert at beginning
        //pos==size insert at last
        int len = size();

        if (position > len || position < 0) {
            System.out.println("Invalid Position");
            return;

        }
        //if input index is correct and less than list size


        if (position == len) {
            //insert at end
            insert(data);
            return;
        } else if (position == 0) {
            //insert at beginning
            // create a new Head to insert
            Node newHead = new Node(data);
            newHead.next = head;
            head = newHead;

        } else {
            //insert in between
            Node temp = new Node(data);
            Node ptr = head;
            int index = 0;
            //traverse to the given index and insert new node
            while (index != (position - 1) && ptr.next != null) {
                ptr = ptr.next;
                index++;
            }
            temp.next = ptr.next;
            ptr.next = temp;


        }

        size++;


    }

    //delete last node
    public void delete() {
        if (head == null) return;
        Node temp = head;
        if (temp.next == null) {
            //only one node
            head = null;

        } else {
            //More than 1 node
            //Move to last 2nd node and mark its next pointer as null
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
        size--;


    }

    //Delete at a particular position
    public void deleteAt(int position) {
        int len = size();
        if (position >= len || position < 0) {
            System.out.println("Invalid Position");
            return;

        }

        if (position == len - 1) {
            //delete last node
            delete();
            return;

        } else if (position == 0) {
            //Delete Head

            Node temp = head;
            head = head.next;
            temp.next = null;


        } else {
            int index = 0;
            Node ptr = head;
            while (index != (position - 1) && ptr.next != null) {
                ptr = ptr.next;
                index++;
            }
            Node temp = ptr.next;
            ptr.next = temp.next;
            temp.next = null;
        }
        size--;

    }

    //Helper of Merge Sort returns the Mid-Node of Linked List
    private Node mid(Node node) {
        Node slow = node, fast = node.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //Return the index and element at center of linked list

    public void sort() {
        //Merge Sort
        head = mergeSort(head);
    }

    public int center() {
        if (head == null) return -1;
        Node temp = head;
        for (int i = 0; i < size / 2; i++) {
            temp = temp.next;
        }
        return temp.data;
    }


    private Node mergeSort(Node start) {
        if (start.next == null) return start;

        Node mid = mid(start);
        Node right = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(start);
        Node newRight = mergeSort(right);

        return merge(newLeft, newRight);
    }

    private Node merge(Node left, Node right) {
        if (left == null) return right;
        if (right == null) return left;
        //create a new linked list
        Node ansHead = new Node(-1);
        Node temp = ansHead;
        while (left != null && right != null) {
            if (left.data < right.data) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        while (left != null) {
            temp.next = left;
            left = left.next;
            temp = temp.next;

        }
        while (right != null) {
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }
        return ansHead.next;

    }

    public Node reverse() {
        Node prev = null;
        Node current = head;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    public int size() {

        return size;
    }

    public Iterator<Integer> iterator() {
        return new MyLinkedListIterator(this);
    }

    public void print() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;

        }
        System.out.println();


    }

    static class Node {
        private final int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" + "data=" + data + '}';
        }
    }

    private static class MyLinkedListIterator implements Iterator<Integer> {
        private Node current;

        public MyLinkedListIterator(MyLinkedList list) {
            current = list.head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {
            Integer data = current.data;
            current = current.next;
            return data;
        }
    }

}
