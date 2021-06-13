package com.example.gb_calc;

public enum Operation {
    EMPTY(""),
    PLUS("+"),
    MINUS("-"),
    DIVIDE("/"),
    MULTIPLY("X"),
    POINT(".");

    private final String value;

    Operation(String value){
        this.value=value;
    }

    @Override
    public String toString() {
        return value;
    }
}
