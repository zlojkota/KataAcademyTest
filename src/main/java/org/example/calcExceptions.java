package org.example;

public class calcExceptions extends Exception {
    public calcExceptions(int numberEx, String Payload) {
        switch (numberEx) {
            //Invalid input
            case 1:
                System.out.println("\n\nInvalid input: "+Payload+"\nUsage: a + b, a - b, a * b, a / b;\nWhere: a,b are both Arabic or Roman numerals from 0 to 10 inclusive.");
                break;
            default:
                System.out.println("\n\nUnknown Exception: "+Payload);
        }
    }
}
