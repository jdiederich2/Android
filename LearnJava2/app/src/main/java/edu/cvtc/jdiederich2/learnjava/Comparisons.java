package edu.cvtc.jdiederich2.learnjava;

public class Comparisons {
    public static void main(String[] args) {
        int value = 4;
        for(int i =0; i < 8; i++) {
            if(i == value) {
                System.out.println(i + " is equal to " + value);
            }

            if(i < value) {
                System.out.println(i + " is less than or equal to " + value);
            }

            if(i > value) {
                System.out.println(i + " is greater than or equal to " + value);
            }
        }

        System.out.println(4 != value);
        System.out.println(5 != value);

        String greeting = "Hello Tim";
        String greeting2 = "Hello";
        greeting2 += " Tim";
        System.out.println(greeting);
        System.out.println(greeting2);
        System.out.println(greeting.equals(greeting2));
    }
}
