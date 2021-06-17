package com.example.gb_calc;

public enum Operation {
    EMPTY(""),
    PLUS("+"),
    MINUS("-"),
    DIVIDE("/"),
    MULTIPLY("X");

    private final String value;


    Operation(String value){
        this.value=value;
    }

    public Operation operationSet(String value){
        if (value == null){
            return Operation.EMPTY;
        }
        if (value.equals(Operation.PLUS.value)){
            return Operation.PLUS;
        }
        if (value.equals(Operation.MINUS.value)){
            return Operation.MINUS;
        }
        if (value.equals(Operation.DIVIDE.value)){
            return Operation.DIVIDE;
        }
        if (value.equals(Operation.MULTIPLY.value)){
            return Operation.MULTIPLY;
        }
        return Operation.EMPTY;
    }

    @Override
    public String toString() {
        return value;
    }
}
