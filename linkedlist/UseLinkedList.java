package com.demo.assignment.linkedlist;

import java.util.LinkedList;

public class UseLinkedList {
    public static void main(String[] args) {
//testing
        MyLinkedList mylist = new MyLinkedList();
        mylist.insert(10);
        mylist.insert(20);
        mylist.insert(30);
        mylist.print();
        System.out.println("Size of list="+mylist.size());
        mylist.insertAt(2, 60);
        System.out.println("Sorted List is");
        mylist.sort();
        mylist.print();
        mylist.insertAt(mylist.size(), 40);
        mylist.insertAt(0, 100);
        System.out.println("Sorted List is");
        mylist.sort();
        mylist.print();
        System.out.println("Size of list "+mylist.size());
        System.out.println("center-" + mylist.center());
        mylist.deleteAt(0);
        mylist.print();
        System.out.println("Size of list "+mylist.size());
        System.out.println("Sorted List displayed using iterator");
        mylist.sort();
        for (Integer val : mylist) {
            System.out.println(val);
        }
        System.out.println("Item deleted @ index 2");
        mylist.deleteAt(2);
        mylist.print();
        System.out.println("Item deleted @ last index ");
        mylist.deleteAt(mylist.size());
        System.out.println("center-" + mylist.center());
        mylist.print();
        System.out.println(mylist.size());
        mylist.reverse();
        mylist.print();
        System.out.println("center-" + mylist.center());
        //custom Iterator
        for (Integer val : mylist) {
            System.out.println(val);
        }


    }
}
