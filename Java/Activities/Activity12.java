package com.example.Activity;



interface Addable {
    int add(int a, int b);
}

public class Activity12 {
    public static void main(String[] args) {

        
        Addable ad1 = (a, b) -> (a + b);
        System.out.println(ad1.add(40, 60));

        
        Addable ad2 = (int a, int b) -> {
            return (a + b);
        };
        System.out.println(ad2.add(340, 420));
    }
}
