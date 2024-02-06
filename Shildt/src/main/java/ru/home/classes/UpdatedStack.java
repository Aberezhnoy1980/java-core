package ru.home.classes;

public class UpdatedStack {
    //  в этом классе определяется целочисленный стек,
    // который может содержать 10 значений.
    private int[] stack = new int[10];
    private int tos;

    // инициализировать вершину стека
    UpdatedStack() {
        tos = -1;
    }

    static {
        System.out.println("New stack created!");
    }

    // разместить элемент в стеке
    void push(int item) {
        if (tos == 9)
            System.out.println("Stack is full");
        else
            stack[++tos] = item;
    }

    // извлечь элемент из стека
    int pop() {
        if (tos < 0) {
            System.out.println("Stack not loaded");
            return 0;
        }
        else
            return stack[tos--];
    }
}

class UpdatedStackTest {
    public static void main(String... args) {
        final UpdatedStack updatedStack1 = new UpdatedStack();
        final UpdatedStack updatedStack2 = new UpdatedStack();

        for (int i = 0; i < 10; i++) {
            updatedStack1.push(i);
        }

        for (int i = 0; i < 20; i++) {
            updatedStack2.push(i);
        }

        System.out.println("Stack in updatedStack1");
        for (int i = 0; i < 10; i++) {
            System.out.println(updatedStack1.pop());
        }

        System.out.println("Stack in updatedStack2");
        for (int i = 0; i < 10; i++) {
            System.out.println(updatedStack2.pop());
        }
    }
}


