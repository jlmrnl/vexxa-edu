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

public class mainThereTheir extends AppCompatActivity  implements View.OnClickListener {
    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button btnAnsThere, btnAnsTheir, ansC, ansD;
    Button submitBtn;

    int score=0;
    int totalQueLength = mainQuestions.questionThereTheir.length;
    int remainQue = totalQueLength-8;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_there_their);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        totalQuestionsTextView = findViewById(R.id.txt_total_ThereTheir);
        questionTextView = findViewById(R.id.questionTT);
        btnAnsThere = findViewById(R.id.btnAnsThere);
        btnAnsTheir = findViewById(R.id.btnAnsTheir);
        /*ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);*/
        submitBtn = findViewById(R.id.btnSubTT);

        btnAnsThere.setOnClickListener(this);
        btnAnsTheir.setOnClickListener(this);
        /*ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);*/
        submitBtn.setOnClickListener(this);
        btnAnsThere.setBackgroundColor(Color.rgb(51, 51, 51));
        btnAnsTheir.setBackgroundColor(Color.rgb(51, 51, 51));

        loadNewQuestion();




    }

    public void onClick(View view) {

        btnAnsThere.setBackgroundColor(Color.rgb(51, 51, 51));
        btnAnsTheir.setBackgroundColor(Color.rgb(51, 51, 51));
        /*ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);*/

        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.btnSubTT){
            if(selectedAnswer.equals(mainQuestions.correctAnsThereTheir[currentQuestionIndex])){
                score++;
            }
            currentQuestionIndex++;
            totalQuestionsTextView.setText("Question No. "+ remainQue++);

            loadNewQuestion();


        }else{
            //choices button clicked
            selectedAnswer  = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.rgb(102, 102, 255));

        }

    }

    void loadNewQuestion(){

        if(currentQuestionIndex == totalQueLength){
            finishQuiz();
            return;
        }

        questionTextView.setText(mainQuestions.questionThereTheir[currentQuestionIndex]);
        btnAnsThere.setText(mainQuestions.choicesThereTheir[currentQuestionIndex][0]);
        btnAnsTheir.setText(mainQuestions.choicesThereTheir[currentQuestionIndex][1]);
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
        startActivity(new Intent(mainThereTheir.this, English.class));
        finish();
    }

    void restartQuiz(){
        score = 0;
        currentQuestionIndex =0;
        loadNewQuestion();
    }


}