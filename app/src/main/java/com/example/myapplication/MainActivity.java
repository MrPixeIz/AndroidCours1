package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final int MAX=10;
    private GuessNumber guessNumber;
    private EditText inputNumber;
    private Button buttonTry;
    private Button buttonCompare;
    private EditText inputNumber1;
    private EditText inputNumber2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber=findViewById(R.id.editTextGuessNumber);
        buttonTry=findViewById(R.id.buttonTryNumber);
        buttonCompare=findViewById(R.id.buttonCompare);
        inputNumber1=findViewById(R.id.editTextNum1);
        inputNumber2=findViewById(R.id.editTextNum2);

        guessNumber=new GuessNumber(MAX);
        setListenner();
    }

    private void setListenner(){
        buttonTry.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                guess();
            }
        });
        buttonCompare.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                compare();
            }
        });

    }
    private void guess(){
        int numberToGuess = Integer.parseInt(inputNumber.getText().toString());
        GuessNumber.guessState result= guessNumber.testNumber(numberToGuess);
        if(result==GuessNumber.guessState.BIGGER)
        {
            showHint("Votre nombre est plus grand");
        }
        else if(result==GuessNumber.guessState.SMALLER){
            showHint("Votre nombre est plus petit");
        }
        else{
            showHint("Bravo, un nouveau nombre à été généré");
            guessNumber.generateNewNumber();
        }
    }
    private void showHint(String hint){
        Toast.makeText(this, hint, Toast.LENGTH_SHORT).show();
    }
    private void compare()
    {
        try {
            inputNumber1.setBackgroundResource(R.color.white);
            inputNumber2.setBackgroundResource(R.color.white);
            int number1= Integer.parseInt(inputNumber1.getText().toString());
            int number2= Integer.parseInt(inputNumber2.getText().toString());
            String message;
            if (number1>number2)
            {
                message="Le nombre 1 est plus grand";
                inputNumber1.setBackgroundResource(R.color.green);
            }
            else if (number1<number2)
            {
                message="Le nombre 2 est plus grand";
                inputNumber2.setBackgroundResource(R.color.green);
            }
            else {
                message="Les nombres sont égaux";
            }
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
        catch(Exception ex){
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
