package org.example;

public class Main2 {
    public static void main(String[] args) {

//        System.out.println("Hello world!");
////even numbers 2, 4, 6, 8, 10, 12, 14 .....
//        for (int i = 2; i <= 20; i += 2) {
//            System.out.println(i);
//        }
//
//        for (int j = 1; j < 21; j++) {
//            if (j % 2 == 0) {
//                System.out.println(j);
//            }
//        }


        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("fizzbuzz");
            } else if (i % 3 == 0) {
                System.out.println("fizz");
            } else if (i % 5 == 0) {
                System.out.println("buzz");
            } else {
                System.out.println(i);
            }

        }
    }
}

