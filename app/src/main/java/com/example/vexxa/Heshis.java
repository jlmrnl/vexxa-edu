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

public class Heshis extends AppCompatActivity implements View.OnClickListener{
    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button btnAnsHes, btnAnsHis, ansC, ansD;
    Button submitBtn;

    int score=0;
    int totalQueLength = mainQuestions.questionHesHis.length;
    int remainQue = totalQueLength-8;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heshis);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        totalQuestionsTextView = findViewById(R.id.txt_total_HesHis);
        questionTextView = findViewById(R.id.questionHH);
        btnAnsHes = findViewById(R.id.btnAnsHes);
        btnAnsHis = findViewById(R.id.btnAnsHis);
        /*ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);*/
        submitBtn = findViewById(R.id.btnSubHH);

        btnAnsHes.setOnClickListener(this);
        btnAnsHis.setOnClickListener(this);
        /*ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);*/
        submitBtn.setOnClickListener(this);
        btnAnsHes.setBackgroundColor(Color.rgb(51, 51, 51));
        btnAnsHis.setBackgroundColor(Color.rgb(51, 51, 51));

        loadNewQuestion();

    }
    public void onClick(View view) {

        btnAnsHes.setBackgroundColor(Color.rgb(51, 51, 51));
        btnAnsHis.setBackgroundColor(Color.rgb(51, 51, 51));
        /*ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);*/

        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.btnSubHH){
            if(selectedAnswer.equals(mainQuestions.correctAnsHesHis[currentQuestionIndex])){
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

        questionTextView.setText(mainQuestions.questionHesHis[currentQuestionIndex]);
        btnAnsHes.setText(mainQuestions.choicesHesHis[currentQuestionIndex][0]);
        btnAnsHis.setText(mainQuestions.choicesHesHis[currentQuestionIndex][1]);
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
        startActivity(new Intent(Heshis.this, English.class));
        finish();
    }

    void restartQuiz(){
        score = 0;
        currentQuestionIndex =0;
        loadNewQuestion();
    }


}