package ru.home.callback;

public class FuncIntApp {
    static class MyButton {
        private String text;
        private Callback callback;

        public MyButton(String text) {
            this.text = text;
        }

        public void setCallback(Callback callback) {
            this.callback = callback;
        }

        public void click() {
            callback.action();
        }
    }

    public static void main(String[] args) {
        final MyButton button1 = new MyButton("Btn1");
        button1.setCallback(() -> System.out.println("action on event for this button"));
        button1.click();

        final MyButton button2 = new MyButton("Btn2");
        button2.setCallback(() -> System.out.println("another action on event for this button"));
        button2.click();

        final MyButton button3 = new MyButton("Btn3");
        button3.setCallback(() -> System.out.println("everything you want"));
        button3.click();
    }
}
