package com.franksprachen.higherorlowergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random random = new Random();
    int random_number = random.nextInt(100);
    int tries = 0;

    public void guessNumber(View view) {
        EditText guessedNumberEditText = (EditText) findViewById(R.id.guessedNumberEditText);

        if (TextUtils.isEmpty(guessedNumberEditText.getText().toString())) {
            Toast.makeText(this, "You must write a guess", Toast.LENGTH_SHORT).show();
        }
        else{
            int guessed_number = Integer.parseInt(guessedNumberEditText.getText().toString());

            if (guessed_number > random_number) {
                Toast.makeText(this, "Get lower", Toast.LENGTH_SHORT).show();
                tries++;
            }
            else if (guessed_number < random_number) {
                Toast.makeText(this, "Get higher", Toast.LENGTH_SHORT).show();
                tries++;
            }
            else {
                Toast.makeText(this, "Congratulations " + random_number + " is correct\nYou did it in " + tries + " tries", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void restartGame(View view) {
        tries = 0;
        random_number = random.nextInt(100);
        Toast.makeText(this, "The game has been restarted\nGuess a new number", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}