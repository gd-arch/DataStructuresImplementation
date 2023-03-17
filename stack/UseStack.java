package com.demo.assignment.stack;

public class UseStack {
    public static void main(String[] args) {
        MyStack stack=new MyStack(10);
        stack.push(10);
        stack.push(500);
        stack.push(30);
        stack.push(460);
        stack.push(33);
        stack.print();
        System.out.println("Popped Element ="+stack.pop());
        stack.print();
        System.out.println("Popped Element ="+stack.pop());
        stack.print();
        //sort
        System.out.println("After Sorting");
        stack.sort();
        stack.print();
        //reverse
        System.out.println("After Reversing");
        stack.reverse();
        stack.print();
        //center
        System.out.println("Center Element ="+stack.center());
        //Push 11 elements
        for(int i=0;i<=10;i++){
            int element =(int)(Math.random()*100);
            System.out.println("pushed element="+ element);
            stack.push(element);
        }

        System.out.println("Peek"+stack.peek());
        System.out.println("Iterator");
        for(int val:stack){
            System.out.print(val+" ");
        }
        System.out.println();
        System.out.println("Pop all the elements");
        for(int i=0;i<=10;i++){
            System.out.println("popped element="+stack.pop());
        }





        }

}
