package com.demo.assignment.hashtable;

import java.util.HashMap;

public class UseHashTable {
    public static void main(String[] args) {
        MyHashTable<Integer, String> ht = new MyHashTable<>();

        ht.put(10, "Aman");
        ht.put(12, "Suman");
        ht.print();
        ht.put(10, "Ganesh");
        ht.put(13, "akhiles");
        ht.print();
        ht.put(11, "Ram");
        ht.put(15, "Shyam");
        ht.put(19, "Priyanka");
        ht.put(23, "ankita");
        ht.print();
        if (ht.contains(11)) {
            System.out.println("Hash Table value for 11--" + ht.get(11));
        }
        if (!ht.contains(40)) {
            ht.put(40, "Mangal");
            ht.print();
        }
        System.out.println("Ht remove operation");
        ht.remove(40);
        ht.remove(12);
        ht.print();


    }
}
