package com.example.calcassignment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText inputFirstNumber, inputSecondNumber;
    Button addButton, subtractButton, divideButton, multiplyButton, resetButton;
    TextView resultBanner,resultView;

    @SuppressLint("SetTextI18n") //helps us avoid hard coded strings errors
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc);
        inputFirstNumber = findViewById(R.id.inputFirstNumber);
        inputSecondNumber = findViewById(R.id.inputSecondNumber);
        addButton = findViewById(R.id.addButton);
        subtractButton = findViewById(R.id.subtractButton);
        divideButton = findViewById(R.id.divideButton);
        multiplyButton = findViewById(R.id.multiplyButton);
        resetButton = findViewById(R.id.resetButton);
        resultBanner = findViewById(R.id.resultBanner);
        resultView = findViewById(R.id.resultView);

        //create a function that will check if the two input fields are empty and returns true or false, this function will be called inside each arithmetic method

//        boolean areFieldsEmpty = (inputFirstNumber.getText().toString().isEmpty() || inputSecondNumber.getText().toString().isEmpty());
//        if (areFieldsEmpty) {
//            resultBanner.setText("Please enter two numbers");
//            return;
//        }



        addButton.setOnClickListener(v -> {
            if (areFieldsEmpty()) {
                resultView.setText("Error");
                Toast.makeText(getApplicationContext(), "Please enter numbers in both fields.", Toast.LENGTH_SHORT).show();
                return;
            }

            double firstNumber = Double.parseDouble(inputFirstNumber.getText().toString());
            double secondNumber = Double.parseDouble(inputSecondNumber.getText().toString());
            double result = firstNumber + secondNumber;
            resultView.setText(Double.toString(result));
        });

        subtractButton.setOnClickListener(v -> {
            if (areFieldsEmpty()) {
                resultView.setText("Error");
                Toast.makeText(getApplicationContext(), "Please enter numbers in both fields.", Toast.LENGTH_SHORT).show();
                return;
            }
            double firstNumber = Double.parseDouble(inputFirstNumber.getText().toString());
            double secondNumber = Double.parseDouble(inputSecondNumber.getText().toString());
            double result = firstNumber - secondNumber;
            resultView.setText(Double.toString(result));
        });
        divideButton.setOnClickListener(v -> {
            if (areFieldsEmpty()) {
                resultView.setText("Error");
                Toast.makeText(getApplicationContext(), "Please enter numbers in both fields.", Toast.LENGTH_SHORT).show();
                return;
            }
            double firstNumber = Double.parseDouble(inputFirstNumber.getText().toString());
            double secondNumber = Double.parseDouble(inputSecondNumber.getText().toString());
            //validate that the division is valid
            if (secondNumber == 0) {
                resultView.setText("Cannot divide by zero");
                return; //exit the function early if the division is invalid
            }
            double result = firstNumber / secondNumber;
            resultView.setText(Double.toString(result));
        });
        multiplyButton.setOnClickListener(v -> {
            if (areFieldsEmpty()) {
                resultView.setText("Error");
                Toast.makeText(getApplicationContext(), "Please enter numbers in both fields.", Toast.LENGTH_SHORT).show();
                return;
            }
            double firstNumber = Double.parseDouble(inputFirstNumber.getText().toString());
            double secondNumber = Double.parseDouble(inputSecondNumber.getText().toString());
            double result = firstNumber * secondNumber;
            resultView.setText(Double.toString(result));

        });
        resetButton.setOnClickListener(v -> {
            inputFirstNumber.setText("");
            inputSecondNumber.setText("");
            resultView.setText("");
            inputFirstNumber.requestFocus();

        });


    }
    boolean areFieldsEmpty() {
        return (inputFirstNumber.getText().toString().isEmpty() || inputSecondNumber.getText().toString().isEmpty());
    }
}