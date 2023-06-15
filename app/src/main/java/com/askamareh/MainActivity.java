package com.askamareh;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    //Declare all global variables that will be accessed later.
    int min;
    int max;

    int aMax;

    int aMin;
    int randomAnswerType;
    int randomAnswerValue;
    String answerType;
    String randomAnswer;

    int randomReaction;

    //Declare all the view variables in the design to be accessed later
    ImageView amarehReaction;
    TextView amarehResponse;
    EditText userQuestion;
    Button askButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign design element ids to their variables
        amarehReaction = findViewById(R.id.amarehReaction);
        amarehResponse = findViewById(R.id.amarehResponse);
        userQuestion = findViewById(R.id.userQuestion);
        askButton = findViewById(R.id.askButton);

        //Set a listener for when the ask button is clicked
        askButton.setOnClickListener(view -> {

            if (TextUtils.isEmpty(userQuestion.getText().toString())){
                amarehResponse.setText("The way this works is that you actually have to ask me something.");

            } else {
                onAnswerSubmitted();
            }
        });

        showSoftKeyboard(userQuestion);

        startNewGame();

    }

    //Show the keyboard only when the user clicks to enter their question, and make the keyboard disappear when they click out.
    public void showSoftKeyboard(View view) {
        if (view.requestFocus()) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
        }
    }

    void onAnswerSubmitted(){
        getCurrentAnswer();
        startNewGame();
    }

    ArrayList<Answers> answerTypes;

    void startNewGame() {

        answerTypes = new ArrayList<>();

        //Create Answers objects that contain all the possible answers in organized categories.
        Answers affirmative = new Answers(R.drawable.amareh_affirmative,
                "If I were any more sure, I'd be a beach.",
                "\uD83D\uDC80 Of course. You don't even have to ask.",
                "On my mama!",
                "Yes, my dear.",
                "Now that's a truth even more reliable than I am.",
                "Smart of you to come to me about this. It's a yes.",
                "Eh. Probably.",
                "That outcome's looking as good as my hair!",
                "Yes, yes, yes, yes, yes!",
                "Nothing can surprise me. I'm sure about this."
        );

        Answers negative = new Answers(R.drawable.amareh_negative,
                "Oh, honey...child, no.",
                "Do us both a favor and listen to me the first time. No.",
                "I asked Daddy for advice on this one, and yikes.",
                "I just can't see that being right in any way.",
                "Please! *hair toss*",
                null,
                null,
                null,
                null,
                null
        );

        Answers neutral = new Answers(R.drawable.amareh_neutral,
                "*yawn* I haven't slept in months. Zzz...",
                "Do you come bearing gifts? If not, try again. \uD83D\uDE18",
                "I can't tell you that.",
                "Believe it or not, I don't know everything. Unlike some people I know.",
                "Hold up, what did you ask again?",
                null,
                null,
                null,
                null,
                null
        );

        //Add new objects to the answerTypes array.
        answerTypes.add(affirmative);
        answerTypes.add(negative);
        answerTypes.add(neutral);

        //Access answer types at random: whether the answer will pull from the affirmative, negative, or neutral object.
        min = 0;
        max = 2;
        randomAnswerType = (int)Math.floor(Math.random() * (max - min + 1) + min);

        switch(randomAnswerType){
            case 0:
                answerType = "affirmative";
                break;
            case 1:
                answerType = "negative";
                break;
            case 2:
            default:
                answerType = "neutral";
        }

        //Pull a random answer from the selected answer type.
        //Note: the mins cannot be zero within the arrays, because the zero index contains the image file.
        randomAnswerValue = (int)Math.floor(Math.random() * (aMax - aMin + 1) + aMin);

        if (Objects.equals(answerType, "affirmative")){
            aMin = 1;
            aMax = 10;

            switch (randomAnswerValue){
                case 1:
                    randomAnswer = affirmative.answer0;
                    break;
                case 2:
                    randomAnswer = affirmative.answer1;
                    break;
                case 3:
                    randomAnswer = affirmative.answer2;
                    break;
                case 5:
                    randomAnswer = affirmative.answer4;
                    break;
                case 6:
                    randomAnswer = affirmative.answer5;
                    break;
                case 7:
                    randomAnswer = affirmative.answer6;
                    break;
                case 8:
                    randomAnswer = affirmative.answer7;
                    break;
                case 9:
                    randomAnswer = affirmative.answer8;
                    break;
                case 10:
                    randomAnswer = affirmative.answer9;
                    break;
                case 4:
                default:
                    randomAnswer = affirmative.answer3;
            }

            //Display the corresponding facial reaction image.
            randomReaction = affirmative.imageId;

        } else if (Objects.equals(answerType, "negative")) {
            aMin = 1;
            aMax = 5;

            switch(randomAnswerValue){
                case 1:
                    randomAnswer = negative.answer0;
                    break;
                case 2:
                    randomAnswer = negative.answer1;
                    break;
                case 3:
                    randomAnswer = negative.answer2;
                    break;
                case 5:
                    randomAnswer = negative.answer4;
                    break;
                case 4:
                default:
                    randomAnswer = negative.answer3;
            }

            //Display the corresponding facial reaction image.
            randomReaction = negative.imageId;

        } else {
            aMin = 1;
            aMax = 5;

            switch(randomAnswerValue){
                case 1:
                    randomAnswer = neutral.answer0;
                    break;
                case 2:
                    randomAnswer = neutral.answer1;
                    break;
                case 3:
                    randomAnswer = neutral.answer2;
                    break;
                case 5:
                    randomAnswer = neutral.answer4;
                    break;
                case 4:
                default:
                    randomAnswer = neutral.answer3;
            }

            //Display the corresponding facial reaction image.
            randomReaction = neutral.imageId;

        }

    }

    //Output the resulting response and reaction.
    void getCurrentAnswer() {
        amarehResponse.setText(randomAnswer);
        amarehReaction.setImageResource(randomReaction);
        userQuestion.setText("");
    }

}