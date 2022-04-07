package com.allenx555.test;

class PrintTest implements Print{
    public void print() {
        System.out.println("test1");
    }
}

class PrintEnd implements Print{
    public void print() {
        System.out.println("test2");
    }
}
public class Test {
    public static void main(String []args) {
        PrintTest start = new PrintTest();
        PrintEnd end = new PrintEnd();
        start.print();
        end.print();
    }
}
