package com.demo.assignment.stack;


import java.util.Arrays;
import java.util.Iterator;

public class MyStack implements Iterable<Integer> {
    private final int[] stack;
    private int top;

    public MyStack(int cap) {
        stack = new int[cap];
        top = -1;
    }

    public int size() {
        return top + 1;
    }

    public void print() {
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public void push(int val) {
        if (top + 1 < stack.length) {
            top++;
            stack[top] = val;

        } else System.out.println("Stack overflow");
    }

    public int pop() {
        if (top >= 0) {
            int pop = stack[top];
            top--;
            return pop;

        } else {
            System.out.println("Stack underflow");
            return -1;
        }
    }

    public int peek() {
        if (top >= 0) return stack[top];
        else {
            System.out.println("Stack underflow");
            return -1;
        }
    }
    public boolean contains(int val){
        for (int i = top; i >= 0; i--) {
            if(val== stack[i]) return true;
        }
        return false;
    }
    public int center(){
        return stack[size()/2];

    }
    //Need to sort only the sub array whose size is up till the top of stack
    public void sort(){

        int[] subArr =new int[top+1];
        for(int i=0;i<=top;i++){
            subArr[i]= stack[i];
        }
        Arrays.sort(subArr);
        for(int i=0;i<=top;i++){
            stack[i]=subArr[i];
        }
    }
    //reverse only the sub array up to the top of stack and fill the data in stack in reverse order
    public void reverse(){
        int arr[]=new int[top+1];
        for(int i=0;i<=top;i++){
            arr[i]= stack[i];
        }
        Arrays.sort(arr);
        for(int i=top;i>=0;i--){
            stack[top-i]=arr[i];
        }
    }


    @Override
    public Iterator<Integer> iterator() {
        return new MyStackIterator(top);
    }
    private class MyStackIterator implements Iterator<Integer>{
        private int top;

        public MyStackIterator(int top) {
            this.top = top;
        }

        @Override
        public boolean hasNext() {
            return top!=-1;
        }

        @Override
        public Integer next() {
            int val = stack[top];
            top--;
            return val;

        }
    }
}

