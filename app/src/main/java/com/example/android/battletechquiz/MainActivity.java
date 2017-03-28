package com.example.android.battletechquiz;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.android.battletechquiz.R.id.question;

public class MainActivity extends AppCompatActivity {

    private TextView Question;
    private Button answerA;
    private Button answerB;
    private Button answerC;
    private Button answerD;
    private int questionCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void startQuiz(View view){
        /* hide start button */
        view.setVisibility(View.INVISIBLE);

        /* Initialize all questionSection Views*/
        View questionSection = findViewById(R.id.questionSection);
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

    public void giveAnswer(View view){
        if (questionCursor < 3) {
            setQuestion(questionCursor);
        }
        else {
            /* show finish card */
        }


    }

    public void setQuestion(int cursor){
        Resources r = getResources();

        String cad="Question";

        cad = cad+Integer.toString(cursor);
        int currentQuestion = getResources().getIdentifier(cad, "array", getPackageName());
        Log.v("currentQuestion", Integer.toString(currentQuestion));
        Log.v("questionCursor after", Integer.toString(questionCursor));

        String[]question = r.getStringArray(currentQuestion);

        Question.setText(question[0]);
        answerA.setText(question[1]);
        answerB.setText(question[2]);
        answerC.setText(question[3]);
        answerD.setText(question[4]);

        questionCursor = cursor + 1;
    }


}
