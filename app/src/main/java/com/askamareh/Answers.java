package com.askamareh;

public class Answers {
    //Declare all possible variables for an Answers object
    int imageId;
    String answer0;
    String answer1;
    String answer2;
    String answer3;
    String answer4;
    String answer5;
    String answer6;
    String answer7;
    String answer8;
    String answer9;


    //Declare an Answers object template that accepts arguments for each variable and initializes them
    public Answers (int imageIdentifier,
                    String answerZero,
                    String answerOne,
                    String answerTwo,
                    String answerThree,
                    String answerFour,
                    String answerFive,
                    String answerSix,
                    String answerSeven,
                    String answerEight,
                    String answerNine
    ) {
        imageId = imageIdentifier;
        answer0 = answerZero;
        answer1 = answerOne;
        answer2 = answerTwo;
        answer3 = answerThree;
        answer4 = answerFour;
        answer5 = answerFive;
        answer6 = answerSix;
        answer7 = answerSeven;
        answer8 = answerEight;
        answer9 = answerNine;
    }

}
