public class Main {

    public static void main(String[] args) {

        // Int has a width of 32
        int myMinvalue = -2_147_483_648;  // As of Java 7 you can use an underscore to separate numbers.
        int myMaxvalue = 2_147_483_647;
        int myTotal = (myMinvalue/2);
        System.out.println("myTotal = " + myTotal);

        // byte has a width of 8
        byte myByteValue = 10; // Much smaller than int -128 to 127
        byte myNewByteValue = (byte)(myByteValue/2);  // (byte) converts the standard int return value to a byte.
        System.out.println("myNewByteValue = " + myNewByteValue);
        // short has a width of 16
        short myShortValue = 32767; // Twice the amount of space as a byte, have the amount of an int.  -32768 to 32767

        // long has a width of 64
        long myLongValue = 100L;  // "L" lets the computer know that it's a long value. 100L = 9_223_372_036_854_775_807L




    }
}
