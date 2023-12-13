package org.example;

class calcExceptions extends Exception {

    private final String detailMessage;

    public calcExceptions(int numberEx, String Payload) {
        switch (numberEx) {
            //Invalid input
            case 1:
                detailMessage="\n\nInvalid input: "+Payload+"\nUsage: a + b, a - b, a * b, a / b;\nWhere: a,b are both Arabic or Roman numerals from 0 to 10 inclusive.\n\n";
                break;
            case 2:
                detailMessage="\n\nInvalid Roman result in arabic numerals: "+Payload+"\nResult are both only positive.\n\n";
                break;
            default:
                detailMessage="\n\nUnknown Exception: "+Payload+"\n\n";
        }
    }

    @Override
    public String getMessage() {
        return detailMessage;
    }
}
