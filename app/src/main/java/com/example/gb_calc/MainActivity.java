package com.example.gb_calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final static String keyCalcData = "CalcData";
    private TextView textInput;
    private TextView textResult;
    private String temp;
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
    private CalcData calcData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        textInput = findViewById(R.id.textView);
        textResult = findViewById(R.id.textResult);
        calcData = new CalcData();
        temp = getString(R.string.empty);
        initButtons();

    }

    private void initButtons() {
        setButtonsClickToListener(button_0, R.id.button0, R.string._0);
        setButtonsClickToListener(button_1, R.id.button1, R.string._1);
        setButtonsClickToListener(button_2, R.id.button2, R.string._2);
        setButtonsClickToListener(button_3, R.id.button3, R.string._3);
        setButtonsClickToListener(button_4, R.id.button4, R.string._4);
        setButtonsClickToListener(button_5, R.id.button5, R.string._5);
        setButtonsClickToListener(button_6, R.id.button6, R.string._6);
        setButtonsClickToListener(button_7, R.id.button7, R.string._7);
        setButtonsClickToListener(button_8, R.id.button8, R.string._8);
        setButtonsClickToListener(button_9, R.id.button9, R.string._9);
        initButtonPointClickListener();
        initButtonClearClickListener();
        initButtonPlusClickListener();
        initButtonMinusClickListener();
        initButtonMultiplyClickListener();
        initButtonDivideClickListener();
        initButtonEqualsClickListener();
        initButtonSettingsClickListener();
    }

    private void initButtonSettingsClickListener() {
        Button button_settings = findViewById(R.id.buttonSettings);
        button_settings.setOnClickListener(v -> {
           Intent runSettings = new Intent(MainActivity.this, SettingsActivity.class);
           startActivity(runSettings);
        });
    }

    private void setButtonsClickToListener(Button button, int p, int p2) {
        button = findViewById(p);
        button.setOnClickListener(v -> updateTextInput(p2));
    }

    private void updateTextInput(int p) {
        calcData.appendInput(getString(p));
        temp = calcData.getInput();
        textInput.setText(temp);
    }

    private void initButtonPointClickListener() {
        Button button_point = findViewById(R.id.button_point);
        button_point.setOnClickListener(v -> {
            calcData.pointInput();
            temp = calcData.getInput();
            textInput.setText(temp);
        });
    }


    private void initButtonClearClickListener() {
        Button button_clear = findViewById(R.id.button_clear);
        button_clear.setOnClickListener(v -> {
            calcData.clearFields();
            textInput.setText(calcData.getInput());
            textResult.setText(calcData.getResult());
        });
    }

    private void initButtonPlusClickListener() {
        Button button_plus = findViewById(R.id.button_plus);
        button_plus.setOnClickListener(v -> {
            calcData.operationChange(Operation.PLUS);
            textInput.setText(calcData.getInput());
        });
    }

    private void initButtonMinusClickListener() {
        Button button_minus = findViewById(R.id.button_minus);
        button_minus.setOnClickListener(v -> {
            calcData.operationChange(Operation.MINUS);
            textInput.setText(calcData.getInput());
        });
    }

    private void initButtonMultiplyClickListener() {
        Button button_multiply = findViewById(R.id.button_multiply);
        button_multiply.setOnClickListener(v -> {
            calcData.operationChange(Operation.MULTIPLY);
            textInput.setText(calcData.getInput());
        });
    }

    private void initButtonDivideClickListener() {
        Button button_divide = findViewById(R.id.button_divide);
        button_divide.setOnClickListener(v -> {
            calcData.operationChange(Operation.DIVIDE);
            textInput.setText(calcData.getInput());
        });
    }

    private void initButtonEqualsClickListener() {
        Button button_equals = findViewById(R.id.button_equals);
        button_equals.setOnClickListener(v -> {
            calcData.emptyCheck();
            calcData.lastCharCheck();
            calcData.operationEquals();
            textInput.setText(calcData.getInput());
            textResult.setText(calcData.getResult());
        });
    }

    @Override
    public void onSaveInstanceState(Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        instanceState.putParcelable(keyCalcData,calcData);
    }

    @Override
    protected void onRestoreInstanceState(Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        calcData = instanceState.getParcelable(keyCalcData);
        setTextView();
    }

    private void setTextView() {
        textInput.setText(calcData.getInput());
        textResult.setText(calcData.getResult());
    }

}