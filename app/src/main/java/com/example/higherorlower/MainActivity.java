package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;

    private EditText maxNumber, enteredNumber;
    private TextView myTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Objects.requireNonNull(getSupportActionBar()).hide();

        Button guessButton = findViewById(R.id.guessButtonId);
        maxNumber = findViewById(R.id.maxNumberId);
        enteredNumber = findViewById(R.id.enteredNumberId);
        myTextview = findViewById(R.id.tellRangetextviewId);
        Button setRangeBtn = findViewById(R.id.setrangebtnid);

        setRangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (maxNumber.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter Max Number First!", Toast.LENGTH_SHORT).show();
                }else {

                    String mytext = "I'm thinking of a number between 1 and " + maxNumber.getText().toString();
                    myTextview.setText(mytext);
                    generateRandomNum();
                }

            }
        });

        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (maxNumber.getText().toString().isEmpty()){

                    Toast.makeText(MainActivity.this, "Enter Max Number First!", Toast.LENGTH_SHORT).show();

                }else if (enteredNumber.getText().toString().isEmpty()){

                    Toast.makeText(MainActivity.this, "Enter Guess Number!", Toast.LENGTH_SHORT).show();

                }else{
                    int guessValue = Integer.parseInt(enteredNumber.getText().toString());

                    if (guessValue > randomNumber){

                        Toast.makeText(MainActivity.this, "Lower than " + guessValue, Toast.LENGTH_SHORT).show();
                        enteredNumber.setText("");

                    }else if (guessValue < randomNumber){

                        Toast.makeText(MainActivity.this, "Higher than " + guessValue, Toast.LENGTH_SHORT).show();
                        enteredNumber.setText("");
                    }else {

                        Toast.makeText(MainActivity.this, "Congrats! You guessed it right", Toast.LENGTH_LONG).show();
                        enteredNumber.setText("");
                        generateRandomNum();
                    }
                }


            }
        });
    }

    public void generateRandomNum(){

        int maxnum = Integer.parseInt(maxNumber.getText().toString());

        Random Rand = new Random();
        randomNumber = Rand.nextInt(maxnum) + 1;
    }
}