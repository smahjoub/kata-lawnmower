package com.mowitnow.lawnowner.exceptions;

public class InvalidInputFormat extends Exception {

    public final static String Error = "An invalid input format has been detected";

    public InvalidInputFormat() {
        super(Error);
    }

    public InvalidInputFormat(String additionalMsg) {
        super(Error + System.lineSeparator() + additionalMsg);
    }
}
