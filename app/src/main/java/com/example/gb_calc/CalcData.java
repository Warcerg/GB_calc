package com.example.gb_calc;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;

public class CalcData {
    private TextView textInput;
    private TextView textResult;

    private boolean operationSum = false;
    private boolean operationSubstract = false;
    private boolean operationMultiplication = false;
    private boolean operationDivision = false;
    private boolean pointCheck = false;

    private float valueOne;
    private float valueTwo;

    private int operPos;

    public CalcData() {
        operationSum = false;
        operationSubstract = false;
        operationMultiplication = false;
        operationDivision = false;
        pointCheck = false;
    }

    public TextView getTextInput() {
        return textInput;
    }

    public void setTextInput(TextView textInput) {
        this.textInput = textInput;
    }

    public TextView getTextResult() {
        return textResult;
    }

    public void setTextResult(TextView textResult) {
        this.textResult = textResult;
    }

    public boolean isOperationSum() {
        return operationSum;
    }

    public void setOperationSum(boolean operationSum) {
        this.operationSum = operationSum;
    }

    public boolean isOperationSubstract() {
        return operationSubstract;
    }

    public void setOperationSubstract(boolean operationSubstract) {
        this.operationSubstract = operationSubstract;
    }

    public boolean isOperationMultiplication() {
        return operationMultiplication;
    }

    public void setOperationMultiplication(boolean operationMultiplication) {
        this.operationMultiplication = operationMultiplication;
    }

    public boolean isOperationDivision() {
        return operationDivision;
    }

    public void setOperationDivision(boolean operationDivision) {
        this.operationDivision = operationDivision;
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

    public void appendText(TextView textView, String string){
        textView.append(string);
    }

    public void setText(TextView textView, String string){
        textView.setText(string);
    }


}
