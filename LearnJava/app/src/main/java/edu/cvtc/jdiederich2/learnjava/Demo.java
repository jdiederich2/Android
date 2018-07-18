package edu.cvtc.jdiederich2.learnjava;

public class Demo {

    public static void main(String[] args) {
        Player jen = new Player();
        System.out.println(jen.getHandleName());
        jen.setNameAndLevel("Je", 5);
        System.out.println(jen.getHandleName());
        System.out.println("Level: " + jen.getLevel());
        System.out.println("Lives: " + jen.getLives());


    }
}
