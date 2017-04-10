package com.example.android.battletechquiz;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.battletechquiz.R.id.question;

public class MainActivity extends AppCompatActivity {

    private TextView Question;
    private Button answerA;
    private Button answerB;
    private Button answerC;
    private Button answerD;
    private int questionCursor;
    private int correctAnswers = 0;
    private String correctAnswer;
    private int questionCount = 10;
    private View questionSection;
    private View playerData;
    private View finalQuestion;
    private EditText playerNameView;
    private Button startButton;
    private String playerName;
    private String house;
    private RadioGroup houseView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionSection = findViewById(R.id.questionSection);
        playerNameView = (EditText)findViewById(R.id.playerName);
        playerData = findViewById(R.id.playerData);
        startButton = (Button)findViewById(R.id.start);
        finalQuestion = findViewById(R.id.finalQuestion);
        houseView = (RadioGroup)findViewById(R.id.House);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void setHouse(View view){
        /* get house name for final scores */
        RadioButton self = (RadioButton) view;
        house = self.getText().toString();
    }

    public void startQuiz(View view){
        /* hide playerData */
        playerData.setVisibility(View.INVISIBLE);
        startButton.setVisibility(View.INVISIBLE);
        /* get player name for final scores */
        playerName = playerNameView.getText().toString();

        /* Initialize all questionSection Views*/
        Question = (TextView) findViewById(question);
        answerA = (Button) findViewById(R.id.answerA);
        answerB = (Button) findViewById(R.id.answerB);
        answerC = (Button) findViewById(R.id.answerC);
        answerD = (Button) findViewById(R.id.answerD);

        /* set starting */
        questionCursor = 1;

        setQuestion(questionCursor);

        questionSection.setVisibility(View.VISIBLE);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void highlightAnswer(String answer){
        switch(correctAnswer) {
            case "answerA":
                answerA.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.answerCorrect));
                break;
            case "answerB":
                answerB.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.answerCorrect));
                break;
            case "answerC":
                answerC.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.answerCorrect));
                break;
            case "answerD":
                answerD.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.answerCorrect));
                break;
        }

        sleep();

    }

    public void giveAnswerA(View view){
        Button answer = (Button)view;

        Log.v("Answer Button text", answer.getText().toString());

        /*highlightAnswer(correctAnswer);*/

        if (correctAnswer.equals("answerA")) {
            correctAnswers = correctAnswers + 1;
            Log.v("correctAnswers", String.valueOf(correctAnswers));
        }

        if (questionCursor <= questionCount) {
            setQuestion(questionCursor);
        }
        else {
            Log.v("correctAnswers final", String.valueOf(correctAnswers));
            questionSection.setVisibility(View.INVISIBLE);
            finalQuestion.setVisibility(View.VISIBLE);
        }

    }

    public void giveAnswerB(View view){
        Button answer = (Button)view;

        Log.v("Answer Button text", answer.getText().toString());

        /*highlightAnswer(correctAnswer);*/

        if (correctAnswer.equals("answerB")) {
            correctAnswers = correctAnswers + 1;
            Log.v("correctAnswers", String.valueOf(correctAnswers));
        }

        if (questionCursor <= questionCount) {
            setQuestion(questionCursor);
        }
        else {
            Log.v("correctAnswers final", String.valueOf(correctAnswers));
            questionSection.setVisibility(View.INVISIBLE);
            finalQuestion.setVisibility(View.VISIBLE);
        }

    }

    public void giveAnswerC(View view){
        Button answer = (Button)view;

        Log.v("Answer Button text", answer.getText().toString());

        /*highlightAnswer(correctAnswer);*/

        if (correctAnswer.equals("answerC")) {
            correctAnswers = correctAnswers + 1;
            Log.v("correctAnswers", String.valueOf(correctAnswers));
        }

        if (questionCursor <= questionCount) {
            setQuestion(questionCursor);
        }
        else {
            Log.v("correctAnswers final", String.valueOf(correctAnswers));
            questionSection.setVisibility(View.INVISIBLE);
            finalQuestion.setVisibility(View.VISIBLE);
        }

    }

    public void giveAnswerD(View view){
        Button answer = (Button)view;

        Log.v("Answer Button text", answer.getText().toString());

        /*highlightAnswer(correctAnswer);*/

        if (correctAnswer.equals("answerD")) {
            correctAnswers = correctAnswers + 1;
            Log.v("correctAnswers", String.valueOf(correctAnswers));
        }

        if (questionCursor <= questionCount) {
            setQuestion(questionCursor);
        }
        else {
            Log.v("correctAnswers final", String.valueOf(correctAnswers));
            questionSection.setVisibility(View.INVISIBLE);
            finalQuestion.setVisibility(View.VISIBLE);
        }

    }

    public void showScore(View view){

        String era = "";

        CheckBox era1 = (CheckBox) findViewById(R.id.era1);
        CheckBox era2 = (CheckBox) findViewById(R.id.era2);
        CheckBox era3 = (CheckBox) findViewById(R.id.era3);
        CheckBox era4 = (CheckBox) findViewById(R.id.era4);

        if (era1.isChecked()){
            era = era + "\n" + getString(R.string.era1);
        }
        if (era2.isChecked()){
            era = era + "\n" + getString(R.string.era2);
        }
        if (era3.isChecked()){
            era = era + "\n" + getString(R.string.era3);
        }
        if (era4.isChecked()){
            era = era + "\n" + getString(R.string.era4);
        }


        findViewById(R.id.answerA);

        if (correctAnswers == questionCount){
            Toast.makeText(getApplicationContext(), "Awesome " + playerName + "!\n" + "You scored " + String.valueOf(correctAnswers) + " correct Answers out of " + questionCount + " for House " + house + "." + "\n\n" + "You like these Battletech eras best:" + era
                    , Toast.LENGTH_LONG).show();
        }
        else if (correctAnswers > 0){
            Toast.makeText(getApplicationContext(), "Congratulations " + playerName + "!\n" + "You scored " + String.valueOf(correctAnswers) + " correct Answers out of " + questionCount + " for House " + house + "." + "\n\n" + "You like these Battletech eras best:" + era
                    , Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "Sorry " + playerName + ".\n" + "You scored " + String.valueOf(correctAnswers) + " correct Answers out of " + questionCount + " for House " + house + "." + "\n\n" + "You like these Battletech eras best:" + era
                    , Toast.LENGTH_LONG).show();
        }

        /* Reset Quiz to be able to start again*/
        finalQuestion.setVisibility(View.INVISIBLE);
        playerData.setVisibility(View.VISIBLE);
        startButton.setVisibility(View.VISIBLE);
        era1.setChecked(false);
        era2.setChecked(false);
        era3.setChecked(false);
        era4.setChecked(false);
        playerNameView.setText("");
        correctAnswers = 0;

    }

    public void setQuestion(int cursor){
        Resources r = getResources();

        String identifier="Question";

        identifier = identifier+Integer.toString(cursor);
        int currentQuestion = getResources().getIdentifier(identifier, "array", getPackageName());

        String[]question = r.getStringArray(currentQuestion);

        Question.setText(question[0]);
        answerA.setText(question[1]);
        answerB.setText(question[2]);
        answerC.setText(question[3]);
        answerD.setText(question[4]);
        correctAnswer = question[5];

        questionCursor = cursor + 1;
    }

    public void sleep(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
