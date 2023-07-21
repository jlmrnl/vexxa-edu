package com.example.vexxa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class General extends AppCompatActivity implements View.OnClickListener{

    TextView totalQuestionsView;
    TextView questionView;
    ImageView seeImage;
    Button btnAns1, btnAns2, btnAns3, btnAns4, btnNxt;

    int score=0;
    int totalQueLength = mainQuestions.guessQuestion.length;

    int remainQue = totalQueLength-9;
    int currentQuestionsIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        totalQuestionsView = findViewById(R.id.txt_total_geussinggame);
        questionView = findViewById(R.id.textquestion);
        btnAns1 = findViewById(R.id.btnAns1);
        btnAns2 = findViewById(R.id.btnAns2);
        btnAns3 = findViewById(R.id.btnAns3);
        btnAns4 = findViewById(R.id.btnAns4);
        btnNxt = findViewById(R.id.btnNxt);

        btnAns1.setOnClickListener(this);
        btnAns2.setOnClickListener(this);
        btnAns3.setOnClickListener(this);
        btnAns4.setOnClickListener(this);
        btnNxt.setOnClickListener(this);
        btnAns1.setBackgroundColor(Color.rgb(51, 51, 51));
        btnAns2.setBackgroundColor(Color.rgb(51, 51, 51));
        btnAns3.setBackgroundColor(Color.rgb(51, 51, 51));
        btnAns4.setBackgroundColor(Color.rgb(51, 51, 51));

        loadNewQuestion();

    }

    public void onClick(View view) {
        btnAns1.setBackgroundColor(Color.rgb(51,51,51));
        btnAns2.setBackgroundColor(Color.rgb(51,51,51));
        btnAns3.setBackgroundColor(Color.rgb(51,51,51));
        btnAns4.setBackgroundColor(Color.rgb(51,51,51));

        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.btnNxt){
            if(selectedAnswer.equals(mainQuestions.guessAnswers[currentQuestionsIndex])){
                score++;
            }
            currentQuestionsIndex++;
            totalQuestionsView.setText("Question No. "+ remainQue++);

            loadNewQuestion();
        }else{
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.rgb(102,102,255));
        }
    }
    void loadNewQuestion(){
        if(currentQuestionsIndex == totalQueLength){
            finishQuiz();
            return;
        }
        questionView.setText(mainQuestions.guessQuestion[currentQuestionsIndex]);
        btnAns1.setText(mainQuestions.guessChoices[currentQuestionsIndex][0]);
        btnAns2.setText(mainQuestions.guessChoices[currentQuestionsIndex][1]);
        btnAns3.setText(mainQuestions.guessChoices[currentQuestionsIndex][2]);
        btnAns4.setText(mainQuestions.guessChoices[currentQuestionsIndex][3]);

    }
    void finishQuiz(){
        String passStatus = " ";
        if(score > totalQueLength *0.60){
            passStatus = "Passed";
        }else{
            passStatus = "Failed";
        }
        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is " + score + " out of " + totalQueLength)
                .setPositiveButton("Confirm",(dialogInterface, i) -> Home())
                .setCancelable(false)
                .show();
    }

    private void Home() { startActivity(new Intent( General.this, mainMenu.class));
        finish();
    }
    void restartQuiz(){
        score = 0;
        currentQuestionsIndex = 0;
        loadNewQuestion();
    }
}