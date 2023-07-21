package com.example.vexxa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Your extends AppCompatActivity implements View.OnClickListener{
    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button btnAnsYoure, btnAnsYour, ansC, ansD;
    Button submitBtn;

    int score=0;
    int totalQueLength = mainQuestions.questionYour.length;
    int remainQue = totalQueLength-8;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        totalQuestionsTextView = findViewById(R.id.txt_total_Your);
        questionTextView = findViewById(R.id.questionYY);
        btnAnsYoure = findViewById(R.id.btnAnsYoure);
        btnAnsYour = findViewById(R.id.btnAnsYour);
        /*ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);*/
        submitBtn = findViewById(R.id.btnSubYY);

        btnAnsYoure.setOnClickListener(this);
        btnAnsYour.setOnClickListener(this);
        /*ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);*/
        submitBtn.setOnClickListener(this);
        btnAnsYoure.setBackgroundColor(Color.rgb(51, 51, 51));
        btnAnsYour.setBackgroundColor(Color.rgb(51, 51, 51));
        /*totalQuestionsTextView.setText("Question No. : "+ remainQue);*/

        loadNewQuestion();
    }
    public void onClick(View view) {

        btnAnsYoure.setBackgroundColor(Color.rgb(51, 51, 51));
        btnAnsYour.setBackgroundColor(Color.rgb(51, 51, 51));
        /*ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);*/

        Button clickedButton = (Button) view;
        if (clickedButton.getId() == R.id.btnSubYY) {
            if (selectedAnswer.equals(mainQuestions.correctAnsYour[currentQuestionIndex])) {
                score++;
            }
            currentQuestionIndex++;
            totalQuestionsTextView.setText("Question No. " + remainQue++);

            loadNewQuestion();


        } else {
            //choices button clicked
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.rgb(102, 102, 255));

        }
    }
    void loadNewQuestion() {

        if (currentQuestionIndex == totalQueLength) {
            finishQuiz();
            return;
        }

        questionTextView.setText(mainQuestions.questionYour[currentQuestionIndex]);
        btnAnsYoure.setText(mainQuestions.choicesYour[currentQuestionIndex][0]);
        btnAnsYoure.setText("You're");
        btnAnsYour.setText(mainQuestions.choicesYour[currentQuestionIndex][1]);
        btnAnsYour.setText("Your");
        /*ansC.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionAnswer.choices[currentQuestionIndex][3]);*/
    }
    void finishQuiz(){
        String passStatus = "";
        if(score > totalQueLength *0.60){
            passStatus = "Passed";
        }else{
            passStatus = "Failed";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is "+ score+" out of "+ totalQueLength)
                .setPositiveButton("Confirm",(dialogInterface, i) -> Home())
                .setCancelable(false)
                .show();


    }

    private void Home() {
        startActivity(new Intent(Your.this, English.class));
        finish();
    }

    void restartQuiz(){
        score = 0;
        currentQuestionIndex =0;
        loadNewQuestion();
    }


}