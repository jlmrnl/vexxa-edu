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

public class MunaMona extends AppCompatActivity implements View.OnClickListener {
    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button btnAnsMuna, btnAnsMona, ansC, ansD;
    Button submitBtn;

    int score=0;
    int totalQueLength = mainQuestions.questionMunaMona.length;
    int remainQue = totalQueLength-8;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muna_mona);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        totalQuestionsTextView = findViewById(R.id.txt_total_MunaMona);
        questionTextView = findViewById(R.id.questionMM);
        btnAnsMuna = findViewById(R.id.btnAnsMuna);
        btnAnsMona = findViewById(R.id.btnAnsMona);
        /*ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);*/
        submitBtn = findViewById(R.id.btnSubMM);

        btnAnsMuna.setOnClickListener(this);
        btnAnsMona.setOnClickListener(this);
        /*ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);*/
        submitBtn.setOnClickListener(this);
        btnAnsMuna.setBackgroundColor(Color.rgb(51, 51, 51));
        btnAnsMona.setBackgroundColor(Color.rgb(51, 51, 51));

        loadNewQuestion();




    }

    public void onClick(View view) {

        btnAnsMuna.setBackgroundColor(Color.rgb(51, 51, 51));
        btnAnsMona.setBackgroundColor(Color.rgb(51, 51, 51));
        /*ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);*/

        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.btnSubMM){
            if(selectedAnswer.equals(mainQuestions.correctAnsMunaMona[currentQuestionIndex])){
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

        questionTextView.setText(mainQuestions.questionMunaMona[currentQuestionIndex]);
        btnAnsMuna.setText(mainQuestions.choicesMunaMona[currentQuestionIndex][0]);
        btnAnsMona.setText(mainQuestions.choicesMunaMona[currentQuestionIndex][1]);
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
        startActivity(new Intent(MunaMona.this, English.class));
        finish();
    }

    void restartQuiz(){
        score = 0;
        currentQuestionIndex =0;
        loadNewQuestion();
    }


}