package com.demo.assignment.hashtable;

import java.util.Iterator;
import java.util.LinkedList;

public class MyHashTable<K, V>  {
    private int size;
    private LinkedList<HashMapNode>[] buckets;
    private static final double defaultLoadFactor = 2.0;

    public MyHashTable() {
        initBuckets(4);
        size = 0;

    }

    //initializes the buckets default size to 4 and initializes it with new linked list
    private void initBuckets(int capacity) {
        buckets = new LinkedList[capacity];
        for (int bucketIndex = 0; bucketIndex < capacity; bucketIndex++) {
            buckets[bucketIndex] = new LinkedList<>();
        }
    }

    //Puts a value associated with key in hashmap
    public void put(K key, V value) {
        //find in which buckets is the key is placed using hashFn
        int bucketIndex = hashFn(key);
        //search at what index inside the bucket is the Node with that key is available
        int dataIndex = getIndexWithinBucket(key, bucketIndex);
        //if data index is found then replace the value at that node with V
        if (dataIndex != -1) {
            HashMapNode node = buckets[bucketIndex].get(dataIndex);
            node.value = value;

        }
        //if data index is not found then add the value at the  bucket index found by hashFn
        else {
            HashMapNode newNode = new HashMapNode(key, value);
            buckets[bucketIndex].add(newNode);
            size++;
        }
        double lambda = size * 1.0 / buckets.length;

        if (lambda > defaultLoadFactor) {
            rehash();
        }


    }

    //Doubles the size of buckets so that lambda can be reduced under load factor
    private void rehash() {
        LinkedList<HashMapNode>[] oldBuckets = buckets;
        initBuckets(2 * oldBuckets.length);
        size = 0;

        for (LinkedList<HashMapNode> oldBucket : oldBuckets) {
            for (HashMapNode oldNode : oldBucket) {
                put(oldNode.key, oldNode.value);
            }
        }
    }

    //return the index of key within the bucket
    private int getIndexWithinBucket(K key, int bucketIndex) {
        int dataIndex = 0;

        for (HashMapNode node : buckets[bucketIndex]) {
            if (node.key.equals(key)) {
                return dataIndex;
            } else {
                dataIndex++;
            }
        }
        return -1;

    }

    //uses hashcode to find the bucket index based on key's hash code
    private int hashFn(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % buckets.length;
    }

    public V get(K key) {
        int bucketIndex = hashFn(key);
        int dataIndex = getIndexWithinBucket(key, bucketIndex);

        if (dataIndex == -1) {
            return null;
        } else {
            HashMapNode node = buckets[bucketIndex].get(dataIndex);
            return node.value;
        }

    }

    public V remove(K key) {
        int bucketIndex = hashFn(key);
        int dataIndex = getIndexWithinBucket(key, bucketIndex);

        if (dataIndex == -1) {
            return null;
        } else {
            HashMapNode node = buckets[bucketIndex].remove(dataIndex);
            size--;
            return node.value;
        }
    }

    public boolean contains(K key) {
        int bucketIndex = hashFn(key);
        int dataIndex = getIndexWithinBucket(key, bucketIndex);

        return dataIndex != -1;

    }

    public int size() {
        return size;
    }

    public void print() {
        for (LinkedList<HashMapNode> bucket : buckets) {
            for (HashMapNode node : bucket) {
                System.out.print(node.key + "-" + node.value + " ");
            }

        }
        System.out.println();

    }



    private class HashMapNode {
        K key;
        V value;

        HashMapNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


}
