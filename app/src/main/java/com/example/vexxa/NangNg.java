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

public class NangNg extends AppCompatActivity implements View.OnClickListener{
    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button btnAnsNg, btnAnsNang, ansC, ansD;
    Button submitBtn;

    int score=0;
    int totalQueLength = mainQuestions.questionNangNg.length;
    int remainQue = totalQueLength-9;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nang_ng);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        totalQuestionsTextView = findViewById(R.id.txt_total_NangNg);
        questionTextView = findViewById(R.id.questionNN);
        btnAnsNg = findViewById(R.id.btnAnsNg);
        btnAnsNang = findViewById(R.id.btnAnsNang);
        /*ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);*/
        submitBtn = findViewById(R.id.btnSubNN);

        btnAnsNg.setOnClickListener(this);
        btnAnsNang.setOnClickListener(this);
        /*ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);*/
        submitBtn.setOnClickListener(this);
        btnAnsNg.setBackgroundColor(Color.rgb(51, 51, 51));
        btnAnsNang.setBackgroundColor(Color.rgb(51, 51, 51));

        loadNewQuestion();
    }
    public void onClick(View view) {

        btnAnsNg.setBackgroundColor(Color.rgb(51, 51, 51));
        btnAnsNang.setBackgroundColor(Color.rgb(51, 51, 51));
        /*ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);*/

        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.btnSubNN){
            if(selectedAnswer.equals(mainQuestions.correctAnsNangNg[currentQuestionIndex])){
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

        questionTextView.setText(mainQuestions.questionNangNg[currentQuestionIndex]);
        btnAnsNg.setText(mainQuestions.choicesNangNg[currentQuestionIndex][0]);
        btnAnsNang.setText(mainQuestions.choicesNangNg[currentQuestionIndex][1]);
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
        startActivity(new Intent(NangNg.this, Filipino.class));
        finish();
    }

    void restartQuiz(){
        score = 0;
        currentQuestionIndex =0;
        loadNewQuestion();
    }
}