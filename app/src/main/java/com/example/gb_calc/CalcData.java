package com.example.gb_calc;

public class CalcData {
    private String input = "";
    private String result = "";

    private final String ZERO_ERROR = "ERROR. cannot divide on zero!";

    private Operation operation = Operation.EMPTY;
    private boolean pointCheck;

    private float valueOne;
    private float valueTwo;

    private int operPos;

    public CalcData() {
        pointCheck = false;
    }

    public boolean isPointCheck() {
        return pointCheck;
    }

    public void setPointCheck(boolean pointCheck) {
        this.pointCheck = pointCheck;
    }

    public float getValueOne() {
        return valueOne;
    }

    public void setValueOne(float valueOne) {
        this.valueOne = valueOne;
    }

    public float getValueTwo() {
        return valueTwo;
    }

    public void setValueTwo(float valueTwo) {
        this.valueTwo = valueTwo;
    }

    public int getOperPos() {
        return operPos;
    }

    public void setOperPos(int operPos) {
        this.operPos = operPos;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public void appendInput(String appendText) {
        StringBuilder sb = new StringBuilder(input);
        sb.append(appendText);
        input = sb.toString();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void emptyCheck() {
        if (input.isEmpty()) {
            appendInput("0");
        }
    }

    public void lastCharCheck() {
        if (input.endsWith(Operation.PLUS.toString()) ||
                input.endsWith(Operation.MINUS.toString()) ||
                input.endsWith(Operation.MULTIPLY.toString()) ||
                input.endsWith(Operation.DIVIDE.toString()) ||
                input.endsWith(Operation.POINT.toString())) {
            appendInput("0");
        }
    }

    public void clearFields() {
        setInput("");
        setResult("");
        setPointCheck(false);
        operation = Operation.EMPTY;
    }

    public boolean operationCheck() { //смысл?
        boolean check = true;
        lastPointCheck();
        String inputCheck = input.substring(0, input.length() - 1);
        if (inputCheck.endsWith(Operation.PLUS.toString()) ||
                inputCheck.endsWith(Operation.MINUS.toString()) ||
                inputCheck.endsWith(Operation.MULTIPLY.toString()) ||
                inputCheck.endsWith(Operation.DIVIDE.toString())) {
            check = false;
        }
        return check;
    }

    public void lastPointCheck() {
        if (input.endsWith(Operation.POINT.toString())) {
            appendInput("0");
        }
    }

    public void pointInput(){
        emptyCheck();
        lastPointCheck();
        if(!isPointCheck()){
            appendInput(Operation.POINT.toString());
            setPointCheck(true);
        }
    }

    public void operationChange(Operation oper) {
        emptyCheck();
        lastPointCheck();
        if (input.endsWith(Operation.PLUS.toString()) ||
                input.endsWith(Operation.MINUS.toString()) ||
                input.endsWith(Operation.MULTIPLY.toString()) ||
                input.endsWith(Operation.DIVIDE.toString())) {
            input = input.substring(0, input.length() - 1);
            operation = Operation.EMPTY;
        }
        if (operation == Operation.EMPTY){
                operationInputUpd(oper);
        }
    }


    private void operationInputUpd(Operation oper) {
        emptyCheck();
        valueOne = Float.parseFloat(input);
        appendInput(oper.toString());
        operPos = input.length();
        setPointCheck(false);
        operation = oper;
    }

    public void operationEquals(){
        emptyCheck();
        lastPointCheck();
        setResult("");
        valueTwo = Float.parseFloat(input.substring(operPos));
        switch (operation) {
            case PLUS:
                setResult(Float.toString(valueOne + valueTwo));
                setInput("");
                break;
            case MINUS:
                setResult(Float.toString(valueOne - valueTwo));
                setInput("");
                break;
            case MULTIPLY:
                setResult(Float.toString(valueOne * valueTwo));
                setInput("");
                break;
            case DIVIDE:
                if (valueTwo == 0) {
                 setResult(ZERO_ERROR);
                } else {
                    setResult(Float.toString(valueOne / valueTwo));
                }
                setInput("");
        }
        setPointCheck(false);
        operation = Operation.EMPTY;
    }
}
