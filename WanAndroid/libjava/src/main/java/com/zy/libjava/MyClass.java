package com.zy.libjava;

public class MyClass {

    public static void main(String[] args) {

        Human man = new Man();
        man.gogn();
    }

    static abstract class Human {
        abstract void gogn();
    }

    static class Man extends Human {

        @Override
        void gogn() {
            System.out.println("Man.gogn");
        }

    }

    static class Woman extends Human {
        @Override
        void gogn() {
            System.out.println("Woman.gogn");
        }
    }

}
