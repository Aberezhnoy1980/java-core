package ru.home.classes;

public class FinalStack {
    private final int[] stack;
    private int tos;

    private final int capacity;

    public FinalStack(int size) {
        this.stack = new int[size];
        this.tos = -1;
        this.capacity = size;
    }

    public void push(int item) {
        if (tos == stack.length - 1) System.out.println("Stack is full");
        else stack[++tos] = item;
    }

    public int pop() {
        if (tos < 0) {
            System.out.println("Stack is empty");
            return 0;
        }
        return stack[tos--];
    }

    public int getCapacity() {
        return capacity;
    }
}

class FinalStackTest {
    public static void main(String[] args) {
        final FinalStack finalStack1 = new FinalStack(5);
        final FinalStack finalStack2 = new FinalStack(8);

        for (int i = 0; i < finalStack1.getCapacity(); i++)
            finalStack1.push(i);
        for (int i = 0; i < finalStack2.getCapacity(); i++)
            finalStack2.push(i);

        System.out.println("finalStack1: ");
        for (int i = 0; i < finalStack1.getCapacity(); i++) {
            System.out.println(finalStack1.pop());
        }
        System.out.println("finalStack2: ");
        for (int i = 0; i < finalStack2.getCapacity(); i++) {
            System.out.println(finalStack2.pop());
        }
    }
}
