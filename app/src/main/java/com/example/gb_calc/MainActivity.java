package com.example.gb_calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CalcData calcData = new CalcData();
        initView(calcData);
    }

    private void initView(CalcData calcData) {
       /* calcData.setTextInput(findViewById(R.id.textView));
        calcData.setTextResult(findViewById(R.id.textResult));*/
        textInput = findViewById(R.id.textView);
        textResult = findViewById(R.id.textResult);
        initButtons(calcData);

    }

    private void initButtons(CalcData calcData) {
        initButton0ClickListener();
        initButton1ClickListener();
        initButton2ClickListener();
        initButton3ClickListener();
        initButton4ClickListener();
        initButton5ClickListener();
        initButton6ClickListener();
        initButton7ClickListener();
        initButton8ClickListener();
        initButton9ClickListener();
        initButtonPointClickListener();
        initButtonClearClickListener();
        initButtonPlusClickListener();
        initButtonMinusClickListener();
        initButtonMultiplyClickListener();
        initButtonDivideClickListener();
        initButtonEqualsClickListener();
/*        initButton0ClickListener(calcData);
        initButton1ClickListener(calcData);
        initButton2ClickListener(calcData);
        initButton3ClickListener(calcData);
        initButton4ClickListener(calcData);
        initButton5ClickListener(calcData);
        initButton6ClickListener(calcData);
        initButton7ClickListener(calcData);
        initButton8ClickListener(calcData);
        initButton9ClickListener(calcData);
        initButtonPointClickListener(calcData);
        initButtonClearClickListener(calcData);
        initButtonPlusClickListener(calcData);
        initButtonMinusClickListener(calcData);
        initButtonMultiplyClickListener(calcData);
        initButtonDivideClickListener(calcData);
        initButtonEqualsClickListener(calcData);*/
    }

    private void initButton1ClickListener() {
        Button button_0 = findViewById(R.id.button1);
        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textInput.append(getString(R.string._1));
            }
        });
    }


    private void initButton0ClickListener() {
        Button button_0 = findViewById(R.id.button0);
        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textInput.append(getString(R.string._0));
            }
        });
    }

    private void initButton2ClickListener() {
        Button button_0 = findViewById(R.id.button2);
        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textInput.append(getString(R.string._2));
            }
        });
    }

    private void initButton3ClickListener() {
        Button button_0 = findViewById(R.id.button3);
        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textInput.append(getString(R.string._3));
            }
        });
    }

    private void initButton4ClickListener() {
        Button button_0 = findViewById(R.id.button4);
        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textInput.append(getString(R.string._4));
            }
        });
    }

    private void initButton5ClickListener() {
        Button button_0 = findViewById(R.id.button5);
        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textInput.append(getString(R.string._5));
            }
        });
    }

    private void initButton6ClickListener() {
        Button button_0 = findViewById(R.id.button6);
        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textInput.append(getString(R.string._6));
            }
        });
    }

    private void initButton7ClickListener() {
        Button button_0 = findViewById(R.id.button7);
        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textInput.append(getString(R.string._7));
            }
        });
    }

    private void initButton8ClickListener() {
        Button button_0 = findViewById(R.id.button8);
        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textInput.append(getString(R.string._8));
            }
        });
    }

    private void initButton9ClickListener() {
        Button button_0 = findViewById(R.id.button9);
        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textInput.append(getString(R.string._9));
            }
        });
    }

    private void initButtonPointClickListener() {
        Button button_0 = findViewById(R.id.button_point);
        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emptyCheck();
                lastCharCheck();
                if (!pointCheck) {
                    textInput.append(getString(R.string.point));
                    pointCheck = true;
                }
            }
        });
    }


    private void initButtonClearClickListener() {
        Button button_0 = findViewById(R.id.button_clear);
        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textInput.setText("");
                textResult.setText("");
                pointCheck = false;
                operationSubstract = false;
                operationMultiplication = false;
                operationDivision = false;
                operationSum = false;
            }
        });
    }

    private void initButtonPlusClickListener() {
        Button button_0 = findViewById(R.id.button_plus);
        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emptyCheck();
                if (operationCheck()) {
                    operationChange();
                    if (!operationSum) {
                        firstValueCheck();
                        valueOne = Float.parseFloat(String.valueOf(textInput.getText()));
                        textInput.append(getString(R.string.plus));
                        operPos = textInput.getText().length();
                        pointCheck = false;
                        operationSum = true;
                    }
                }
            }
        });
    }

    private void initButtonMinusClickListener() {
        Button button_0 = findViewById(R.id.button_minus);
        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emptyCheck();
                if (operationCheck()) {
                    operationChange();
                    if (!operationSubstract) {
                        firstValueCheck();
                        valueOne = Float.parseFloat(String.valueOf(textInput.getText()));
                        textInput.append(getString(R.string.minus));
                        operPos = textInput.getText().length();
                        pointCheck = false;
                        operationSubstract = true;
                    }
                }
            }
        });
    }

    private void initButtonMultiplyClickListener() {
        Button button_0 = findViewById(R.id.button_multiply);
        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emptyCheck();
                if (operationCheck()) {
                    operationChange();
                    if (!operationMultiplication) {
                        firstValueCheck();
                        valueOne = Float.parseFloat(String.valueOf(textInput.getText()));
                        textInput.append(getString(R.string.multiply));
                        operPos = textInput.getText().length();
                        pointCheck = false;
                        operationMultiplication = true;
                    }
                }
            }
        });
    }

    private void initButtonDivideClickListener() {
        Button button_0 = findViewById(R.id.button_divide);
        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emptyCheck();
                if (operationCheck()) {
                    operationChange();
                    if (!operationDivision) {
                        firstValueCheck();
                        valueOne = Float.parseFloat(String.valueOf(textInput.getText()));
                        textInput.append(getString(R.string.divide));
                        operPos = textInput.getText().length();
                        pointCheck = false;
                        operationDivision = true;
                    }
                }
            }
        });
    }

    private void initButtonEqualsClickListener() {
        Button button_0 = findViewById(R.id.button_equals);
        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emptyCheck();
                lastCharCheck();
                textResult.setText("");
                valueTwo = Float.parseFloat(String.valueOf(textInput.getText().subSequence(operPos, textInput.getText().length())));
                if (operationSum) {
                    textResult.setText(Float.toString(valueOne + valueTwo));
                    textInput.setText("");

                } else if (operationSubstract) {
                    textResult.setText(Float.toString(valueOne - valueTwo));
                    textInput.setText("");

                } else if (operationMultiplication) {
                    textResult.setText(Float.toString(valueOne * valueTwo));
                    textInput.setText("");

                } else if (operationDivision) {
                    if (valueTwo == 0) {
                        textResult.setText(getString(R.string.ErrorZeroDiv));
                    } else {
                        textResult.setText(Float.toString(valueOne / valueTwo));
                    }
                    textInput.setText("");
                }
                pointCheck = false;
                operationDivision = false;
                operationMultiplication = false;
                operationSubstract = false;
                operationSum = false;
            }
        });
    }

    private boolean operationCheck() {
        boolean check = true;
        lastPointCheck();
        String inputCheck = textInput.getText().toString().substring(0, textInput.getText().length() - 1);
        if (inputCheck.contains(getString(R.string.plus)) ||
                inputCheck.contains(getString(R.string.minus)) ||
                inputCheck.contains(getString(R.string.divide)) ||
                inputCheck.contains(getString(R.string.multiply))) {
            check = false;
        }
        return check;
    }

    private void lastPointCheck() {
        if (textInput.getText().toString().endsWith(getString(R.string.point))) {
            textInput.append(getString(R.string._0));
        }
    }

    private void lastCharCheck() {
        if (textInput.getText().toString().endsWith(getString(R.string.plus)) ||
                textInput.getText().toString().endsWith(getString(R.string.minus)) ||
                textInput.getText().toString().endsWith(getString(R.string.multiply)) ||
                textInput.getText().toString().endsWith(getString(R.string.divide)) ||
                textInput.getText().toString().endsWith(getString(R.string.point))) {
            textInput.append(getString(R.string._0));
        }
    }

    private void emptyCheck() {
        if (textInput.getText().toString().isEmpty()) {
            textInput.append(getString(R.string._0));
        }

    }

    private void operationChange() {
        if (operationDivision || operationMultiplication || operationSubstract || operationSum) {
            textInput.setText(textInput.getText().subSequence(0, textInput.getText().length() - 1));
            operationDivision = false;
            operationMultiplication = false;
            operationSubstract = false;
            operationSum = false;
        }
    }

    private void firstValueCheck() {
        if (textInput.getText() == null) {
            textInput.setText(getString(R.string._0));
        }
    }

    /*    private void initButton0ClickListener(CalcData calcData) {
            Button button_0 = findViewById(R.id.button0);
            button_0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calcData.appendText(calcData.getTextInput(),getString(R.string._0));
                }
            });
        }

        private void initButton1ClickListener(CalcData calcData) {
            Button button_0 = findViewById(R.id.button1);
            button_0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calcData.appendText(calcData.getTextInput(),getString(R.string._1));
                }
            });
        }

        private void initButton2ClickListener(CalcData calcData) {
            Button button_0 = findViewById(R.id.button2);
            button_0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calcData.appendText(calcData.getTextInput(),getString(R.string._2));
                }
            });
        }

        private void initButton3ClickListener(CalcData calcData) {
            Button button_0 = findViewById(R.id.button3);
            button_0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calcData.appendText(calcData.getTextInput(),getString(R.string._3));
                }
            });
        }

        private void initButton4ClickListener(CalcData calcData) {
            Button button_0 = findViewById(R.id.button4);
            button_0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calcData.appendText(calcData.getTextInput(),getString(R.string._4));
                }
            });
        }

        private void initButton5ClickListener(CalcData calcData) {
            Button button_0 = findViewById(R.id.button5);
            button_0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calcData.appendText(calcData.getTextInput(),getString(R.string._5));
                }
            });
        }

        private void initButton6ClickListener(CalcData calcData) {
            Button button_0 = findViewById(R.id.button6);
            button_0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calcData.appendText(calcData.getTextInput(),getString(R.string._6));
                }
            });
        }

        private void initButton7ClickListener(CalcData calcData) {
            Button button_0 = findViewById(R.id.button7);
            button_0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calcData.appendText(calcData.getTextInput(),getString(R.string._7));
                }
            });
        }

        private void initButton8ClickListener(CalcData calcData) {
            Button button_0 = findViewById(R.id.button8);
            button_0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calcData.appendText(calcData.getTextInput(),getString(R.string._8));
                }
            });
        }

        private void initButton9ClickListener(CalcData calcData) {
            Button button_0 = findViewById(R.id.button9);
            button_0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calcData.appendText(calcData.getTextInput(),getString(R.string._9));
                }
            });
        }
        private void initButtonPointClickListener(CalcData calcData) {
            Button button_0 = findViewById(R.id.button_point);
            button_0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    emptyCheck(calcData);
                    lastCharCheck(calcData);
                    if (!calcData.isPointCheck()) {
                        calcData.appendText(calcData.getTextInput(), String.valueOf(R.string.point));
                        calcData.setPointCheck(true);
                    }
                }
            });
        }


        private void initButtonClearClickListener(CalcData calcData) {
            Button button_0 = findViewById(R.id.button_clear);
            button_0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calcData.setText(calcData.getTextInput(), "");
                    calcData.setText(calcData.getTextResult(), "");
                    calcData.setPointCheck(false);
                    calcData.setOperationDivision(false);
                    calcData.setOperationMultiplication(false);
                    calcData.setOperationSubstract(false);
                    calcData.setOperationSum(false);
                }
            });
        }

        private void initButtonPlusClickListener(CalcData calcData) {
            Button button_0 = findViewById(R.id.button_plus);
            button_0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    emptyCheck(calcData);
                    if (operationCheck(calcData)) {
                        operationChange(calcData);
                        if (!calcData.isOperationSum()) {
                            firstValueCheck(calcData);
                            calcData.setValueOne(Float.parseFloat(String.valueOf(calcData.getTextInput().getText())));
                            calcData.appendText(calcData.getTextInput(),getString(R.string.plus));
                            calcData.setOperPos(calcData.getTextInput().getText().length());
                            calcData.setPointCheck(false);
                            calcData.setOperationSum(true);
                        }
                    }
                }
            });
        }

        private void initButtonMinusClickListener(CalcData calcData) {
            Button button_0 = findViewById(R.id.button_minus);
            button_0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    emptyCheck(calcData);
                    if (operationCheck(calcData)) {
                        operationChange(calcData);
                        if (!calcData.isOperationSubstract()) {
                            firstValueCheck(calcData);
                            calcData.setValueOne(Float.parseFloat(String.valueOf(calcData.getTextInput().getText())));
                            calcData.appendText(calcData.getTextInput(),getString(R.string.minus));
                            calcData.setOperPos(calcData.getTextInput().getText().length());
                            calcData.setPointCheck(false);
                            calcData.setOperationSubstract(true);
                        }
                    }
                }
            });
        }

        private void initButtonMultiplyClickListener(CalcData calcData) {
            Button button_0 = findViewById(R.id.button_multiply);
            button_0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    emptyCheck(calcData);
                    if (operationCheck(calcData)) {
                        operationChange(calcData);
                        if (!calcData.isOperationMultiplication()) {
                            firstValueCheck(calcData);
                            calcData.setValueOne(Float.parseFloat(String.valueOf(calcData.getTextInput().getText())));
                            calcData.appendText(calcData.getTextInput(),getString(R.string.multiply));
                            calcData.setOperPos(calcData.getTextInput().getText().length());
                            calcData.setPointCheck(false);
                            calcData.setOperationMultiplication(true);
                        }
                    }
                }
            });
        }

        private void initButtonDivideClickListener(CalcData calcData) {
            Button button_0 = findViewById(R.id.button_divide);
            button_0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    emptyCheck(calcData);
                    if (operationCheck(calcData)) {
                        operationChange(calcData);
                        if (!calcData.isOperationDivision()) {
                            firstValueCheck(calcData);
                            calcData.setValueOne(Float.parseFloat(String.valueOf(calcData.getTextInput().getText())));
                            calcData.appendText(calcData.getTextInput(),getString(R.string.divide));
                            calcData.setOperPos(calcData.getTextInput().getText().length());
                            calcData.setPointCheck(false);
                            calcData.setOperationDivision(true);
                        }
                    }
                }
            });
        }

        private void initButtonEqualsClickListener(CalcData calcData) {
            Button button_0 = findViewById(R.id.button_equals);
            button_0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    emptyCheck(calcData);
                    lastCharCheck(calcData);
                    calcData.setText(calcData.getTextResult(), "");
                    calcData.setValueTwo(Float.parseFloat(String.valueOf(calcData.getTextInput().getText())));
                    calcData.setValueTwo(Float.parseFloat(String.valueOf(calcData.getTextInput().getText().subSequence(calcData.getOperPos(), calcData.getTextInput().getText().length()))));
                    if (calcData.isOperationSum()) {
                        calcData.setText(calcData.getTextResult(),Float.toString(calcData.getValueOne() + calcData.getValueTwo()) );
                        calcData.setText(calcData.getTextInput(), "");

                    } else if (calcData.isOperationSubstract()) {
                        calcData.setText(calcData.getTextResult(),Float.toString(calcData.getValueOne() - calcData.getValueTwo()) );
                        calcData.setText(calcData.getTextInput(), "");

                    } else if (calcData.isOperationMultiplication()) {
                        calcData.setText(calcData.getTextResult(),Float.toString(calcData.getValueOne() * calcData.getValueTwo()) );
                        calcData.setText(calcData.getTextInput(), "");

                    } else if (calcData.isOperationDivision()) {
                        if (calcData.getValueTwo() == 0) {
                            calcData.setText(calcData.getTextResult(), String.valueOf(R.string.ErrorZeroDiv));
                        } else {
                            calcData.setText(calcData.getTextResult(),Float.toString(calcData.getValueOne() / calcData.getValueTwo()) );
                        }
                        calcData.setText(calcData.getTextInput(), "");
                    }
                    calcData.setPointCheck(false);
                    calcData.setOperationDivision(false);
                    calcData.setOperationMultiplication(false);
                    calcData.setOperationSubstract(false);
                    calcData.setOperationSum(false);
                }
            });
        }

        private boolean operationCheck(CalcData calcData) {
            boolean check = true;
            lastPointCheck(calcData);
            String inputCheck = calcData.getTextInput().getText().toString().substring(0, calcData.getTextInput().getText().length() - 1);
            if (inputCheck.contains(getString(R.string.plus)) ||
                    inputCheck.contains(getString(R.string.minus)) ||
                    inputCheck.contains(getString(R.string.divide)) ||
                    inputCheck.contains(getString(R.string.multiply))) {
                check = false;
            }
            return check;
        }

        private void lastPointCheck(CalcData calcData) {
            if (calcData.getTextInput().getText().toString().endsWith(getString(R.string.point))) {
                calcData.appendText(calcData.getTextInput(), String.valueOf(R.string._0));
            }
        }

        private void lastCharCheck(CalcData calcData) {
            if (calcData.getTextInput().getText().toString().endsWith(getString(R.string.plus)) ||
                    calcData.getTextInput().getText().toString().endsWith(getString(R.string.minus)) ||
                    calcData.getTextInput().getText().toString().endsWith(getString(R.string.multiply)) ||
                    calcData.getTextInput().getText().toString().endsWith(getString(R.string.divide)) ||
                    calcData.getTextInput().getText().toString().endsWith(getString(R.string.point))) {
                calcData.appendText(calcData.getTextInput(),getString(R.string._0));
            }
        }

        private void emptyCheck(CalcData calcData) {
            if (calcData.getTextInput().getText().toString().isEmpty()) {
                calcData.appendText(calcData.getTextInput(),getString(R.string._0));
            }

        }

        private void operationChange(CalcData calcData) {
            if (calcData.isOperationDivision() || calcData.isOperationMultiplication()
                    || calcData.isOperationSubstract() || calcData.isOperationSum()) {
                calcData.setText(calcData.getTextResult(), String.valueOf(calcData.getTextInput().getText().subSequence(0, calcData.getTextInput().getText().length() - 1)));
                calcData.setOperationDivision(false);
                calcData.setOperationSum(false);
                calcData.setOperationSubstract(false);
                calcData.setOperationMultiplication(false);
            }
        }

        private void firstValueCheck(CalcData calcData) {
            if (calcData.getTextInput().getText() == null) {
                calcData.setText(calcData.getTextInput(), getString(R.string._0));
            }
        }*/
}