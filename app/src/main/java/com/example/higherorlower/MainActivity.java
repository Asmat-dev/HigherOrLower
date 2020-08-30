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
    private TextView myTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Objects.requireNonNull(getSupportActionBar()).hide();

        Button guessButton = findViewById(R.id.guessButtonId);
        maxNumber = findViewById(R.id.maxNumberId);
        enteredNumber = findViewById(R.id.enteredNumberId);
        myTextView = findViewById(R.id.tellRangetextviewId);
        Button setRangeBtn = findViewById(R.id.setrangebtnid);

        setRangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (maxNumber.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, R.string.enter_max_number, Toast.LENGTH_SHORT).show();
                }else {

                    String mytext = getString(R.string.number_between) + maxNumber.getText().toString();
                    myTextView.setText(mytext);
                    generateRandomNum();
                }

            }
        });

        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (maxNumber.getText().toString().isEmpty()){

                    Toast.makeText(MainActivity.this, R.string.enter_max_first, Toast.LENGTH_SHORT).show();

                }else if (enteredNumber.getText().toString().isEmpty()){

                    Toast.makeText(MainActivity.this, R.string.enter_guessed_number, Toast.LENGTH_SHORT).show();

                }else{
                    int guessValue = Integer.parseInt(enteredNumber.getText().toString());

                    if (guessValue > randomNumber){

                        Toast.makeText(MainActivity.this, getString(R.string.lower_than) + guessValue, Toast.LENGTH_SHORT).show();
                        enteredNumber.setText("");

                    }else if (guessValue < randomNumber){

                        Toast.makeText(MainActivity.this, getString(R.string.higher_than) + guessValue, Toast.LENGTH_SHORT).show();
                        enteredNumber.setText("");
                    }else {

                        Toast.makeText(MainActivity.this, R.string.congrats, Toast.LENGTH_LONG).show();
                        enteredNumber.setText("");
                        generateRandomNum();
                    }
                }


            }
        });
    }

    public void generateRandomNum(){

        int maxNum = Integer.parseInt(maxNumber.getText().toString());

        Random Rand = new Random();
        randomNumber = Rand.nextInt(maxNum) + 1;
    }
}