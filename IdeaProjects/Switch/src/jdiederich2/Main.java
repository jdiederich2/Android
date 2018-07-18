package jdiederich2;

public class Main {

    public static void main(String[] arg) {
    int value = 3;

        if(value == 1) {
            System.out.println("Value was 1");
        } else if(value == 2) {
            System.out.println("Value was 2");
        } else {
            System.out.println("Value not 1 or 2");
        }

        for(int i = 8; i > 1; i--) {
            System.out.println(String.format("%.2f",calculateInterest(10000.0, i)));
        }


        int count = 0;

        for(int i = 200; i < 550; i++) {
            if(isPrime(i) == true) {
                System.out.println("number + " + i + " is prime #");
                count++;
            }

            if(count == 3) {
                System.out.println("Exiting for loop");
                break;
            }

        }
    }


        char charValue = 'A';

        public static double calculateInterest(double amount, double interestRate) {
            return(amount *(interestRate/100));
        }

        public static boolean isPrime(int n) {
            if(n == 1) {
                return false;
            }

            for(int i=2; i <=n/2; i++) {
                if(n % i == 0) {
                    return false;
                }
            }

            return true;
        }




}
