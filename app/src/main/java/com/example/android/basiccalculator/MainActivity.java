package com.example.android.basiccalculator;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String displayOnScreen = ""; //String which is being displayed
    int digitCounter = 0; // Total digit not more than 8 digit
    int decimalPointUsed = 0; //Decimal point can be used once
    float value = 0;
    String operation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*This is the method for displaying in the TextView as a string*/

    public void display(String display) {
        TextView displayTextView = (TextView) findViewById(R.id.textViewDisplay);
        if (display == "") {
            displayTextView.setText("0");
        } else {
            displayTextView.setText(display);
        }
    }

    public float getDisplayedValue() {
        float displayedValue = 0;
        if (displayOnScreen == "") {
            displayedValue = 0;
        } else {
            displayedValue = Float.parseFloat(displayOnScreen);
        }
        return displayedValue;
    }

    // These are the method for button one to nine

    public void buttonOne(View view) {
        if (digitCounter == 8) {
            return;
        }
        displayOnScreen += "1";
        digitCounter++;
        display(displayOnScreen);
    }

    public void buttonTwo(View view) {
        if (digitCounter == 8) {
            return;
        }
        displayOnScreen += "2";
        digitCounter++;
        display(displayOnScreen);
    }

    public void buttonThree(View view) {
        if (digitCounter == 8) {
            return;
        }
        displayOnScreen += "3";
        digitCounter++;
        display(displayOnScreen);
    }

    public void buttonFour(View view) {
        if (digitCounter == 8) {
            return;
        }
        displayOnScreen += "4";
        digitCounter++;
        display(displayOnScreen);
    }

    public void buttonFive(View view) {
        if (digitCounter == 8) {
            return;
        }
        displayOnScreen += "5";
        digitCounter++;
        display(displayOnScreen);
    }

    public void buttonSix(View view) {
        if (digitCounter == 8) {
            return;
        }
        displayOnScreen += "6";
        digitCounter++;
        display(displayOnScreen);
    }

    public void buttonSeven(View view) {
        if (digitCounter == 8) {
            return;
        }
        displayOnScreen += "7";
        digitCounter++;
        display(displayOnScreen);
    }

    public void buttonEight(View view) {
        if (digitCounter == 8) {
            return;
        }
        displayOnScreen += "8";
        digitCounter++;
        display(displayOnScreen);
    }

    public void buttonNine(View view) {
        if (digitCounter == 8) {
            return;
        }
        displayOnScreen += "9";
        digitCounter++;
        display(displayOnScreen);
    }

    // These methods for 0 and decimal point
    public void buttonDot(View view) {
        if (digitCounter == 0) {
            displayOnScreen += "0.";
            decimalPointUsed = 1;
            digitCounter++;
        } else {
            if (decimalPointUsed == 0) {
                displayOnScreen += ".";
                decimalPointUsed = 1;
                display(displayOnScreen);
            } else
                return;
        }
    }

    public void buttonZero(View view) {
        if (digitCounter == 8) {
            return;
        } else {
            if (digitCounter == 0) {
                display("");
                return;
            } else {
                displayOnScreen += "0";
                digitCounter++;
                display(displayOnScreen);
            }
        }
    }

    //This method clears the screen
    public void clear(View view) {
        digitCounter = 0;
        decimalPointUsed = 0;
        display("");
        displayOnScreen = "";
    }

    public void clearConsole() {
        displayOnScreen = "";
        digitCounter = 0;
        decimalPointUsed = 0;
    }

    public void addButton(View view) {
        value = getDisplayedValue();
        operation = "+";
        clearConsole();
    }

    public void subtractionButton(View view) {
        value = getDisplayedValue();
        operation = "-";
        clearConsole();
    }
    public void multiplicationButton(View view) {
        value = getDisplayedValue();
        operation = "*";
        clearConsole();
    }
    public void divisionButton(View view) {
        value = getDisplayedValue();
        operation = "/";
        clearConsole();
    }

    public void equalButton(View view) {
        switch (operation) {
            case "+":
                value += getDisplayedValue();
                displayOnScreen = "" + value;
                break;
            case "-":
                value -= getDisplayedValue();
                displayOnScreen = "" + value;
                break;
            case "*":
                value *= getDisplayedValue();
                displayOnScreen = "" + value;
                break;
            case "/":

                if(getDisplayedValue()==0){
                    Toast.makeText(this,"Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    displayOnScreen = "Error";
                }
                else{
                    value/=getDisplayedValue();
                    displayOnScreen = "" + value;
                }
                break;

        }
        display(displayOnScreen);
        operation = "";
        clearConsole();
    }
}

