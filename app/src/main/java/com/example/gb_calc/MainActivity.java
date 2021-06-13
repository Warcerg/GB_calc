package com.example.gb_calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textInput;
    private TextView textResult;
    private String temp = getString(R.string.empty);
    private Button button_0;
    private Button button_1;
    private Button button_2;
    private Button button_3;
    private Button button_4;
    private Button button_5;
    private Button button_6;
    private Button button_7;
    private Button button_8;
    private Button button_9;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CalcData calcData = new CalcData();
        initView(calcData);
    }

    private void initView(CalcData calcData) {
        textInput = findViewById(R.id.textView);
        textResult = findViewById(R.id.textResult);
        initButtons(calcData);

    }

    private void initButtons(CalcData calcData) {
        setButtonsClickToListener(button_0, calcData, R.id.button0, R.string._0);
        setButtonsClickToListener(button_1, calcData, R.id.button1, R.string._1);
        setButtonsClickToListener(button_2, calcData, R.id.button2, R.string._2);
        setButtonsClickToListener(button_3, calcData, R.id.button3, R.string._3);
        setButtonsClickToListener(button_4, calcData, R.id.button4, R.string._4);
        setButtonsClickToListener(button_5, calcData, R.id.button5, R.string._5);
        setButtonsClickToListener(button_6, calcData, R.id.button6, R.string._6);
        setButtonsClickToListener(button_7, calcData, R.id.button7, R.string._7);
        setButtonsClickToListener(button_8, calcData, R.id.button8, R.string._8);
        setButtonsClickToListener(button_9, calcData, R.id.button9, R.string._9);
        initButtonPointClickListener(calcData);
        initButtonClearClickListener(calcData);
        initButtonPlusClickListener(calcData);
        initButtonMinusClickListener(calcData);
        initButtonMultiplyClickListener(calcData);
        initButtonDivideClickListener(calcData);
        initButtonEqualsClickListener(calcData);
    }

      private void setButtonsClickToListener(Button button, CalcData calcData, int p, int p2) {
        button = findViewById(p);
        button.setOnClickListener(v -> updateTextInput(calcData, p2));
    }

    private void updateTextInput(CalcData calcData, int p) {
        calcData.appendInput( getString(p));
        temp = calcData.getInput();
        textInput.setText(temp);
    }

    private void initButtonPointClickListener(CalcData calcData) {
        Button button_point = findViewById(R.id.button_point);
        button_point.setOnClickListener(v -> {
            calcData.pointInput();
            temp = calcData.getInput();
            textInput.setText(temp);
        });
    }


    private void initButtonClearClickListener(CalcData calcData) {
        Button button_clear = findViewById(R.id.button_clear);
        button_clear.setOnClickListener(v -> {
            calcData.clearFields();
            textInput.setText(calcData.getInput());
            textResult.setText(calcData.getResult());
        });
    }

    private void initButtonPlusClickListener(CalcData calcData) {
        Button button_plus = findViewById(R.id.button_plus);
        button_plus.setOnClickListener(v -> {
            calcData.operationChange(Operation.PLUS);
            textInput.setText(calcData.getInput());
        });
    }

    private void initButtonMinusClickListener(CalcData calcData) {
        Button button_minus = findViewById(R.id.button_minus);
        button_minus.setOnClickListener(v -> {
            calcData.operationChange(Operation.MINUS);
            textInput.setText(calcData.getInput());
        });
    }

    private void initButtonMultiplyClickListener(CalcData calcData) {
        Button button_multiply = findViewById(R.id.button_multiply);
        button_multiply.setOnClickListener(v -> {
            calcData.operationChange(Operation.MULTIPLY);
            textInput.setText(calcData.getInput());
        });
    }

    private void initButtonDivideClickListener(CalcData calcData) {
        Button button_divide = findViewById(R.id.button_divide);
        button_divide.setOnClickListener(v -> {
            calcData.operationChange(Operation.DIVIDE);
            textInput.setText(calcData.getInput());
        });
    }

    private void initButtonEqualsClickListener(CalcData calcData) {
        Button button_equals = findViewById(R.id.button_equals);
        button_equals.setOnClickListener(v -> {
            calcData.emptyCheck();
            calcData.lastCharCheck();
            calcData.operationEquals();
            textInput.setText(calcData.getInput());
            textResult.setText(calcData.getResult());
        });
    }

}