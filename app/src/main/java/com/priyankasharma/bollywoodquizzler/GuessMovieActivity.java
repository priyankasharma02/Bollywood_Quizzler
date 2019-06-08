package com.priyankasharma.bollywoodquizzler;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Duration;


public class GuessMovieActivity extends AppCompatActivity {

    ImageView movieImage;
    Button option1,option2,option3,option4;
    ProgressBar mProgressBar;
    TextView mScoreTextView;
    QuestionAnswer mQuestionAnswer;
    int mIndex;
    int mOption;
    int mScore;
    Toast mToast;

    //Adding images to array
    private QuestionAnswer[] mMovieQuestionBank = new QuestionAnswer[]{
            new QuestionAnswer(R.drawable.image01_ddlj,R.string.guessMovie01_option1,
                    R.string.guessMovie01_option2,R.string.guessMovie01_option3,
                    R.string.guessMovie01_option4,R.string.guessMovie01_correctOption),
            new QuestionAnswer(R.drawable.image02_damini,R.string.guessMovie02_option1,
                    R.string.guessMovie02_option2,R.string.guessMovie02_option3,
                    R.string.guessMovie02_option4,R.string.guessMovie02_correctOption),
            new QuestionAnswer(R.drawable.image03_andaz_apna_apna,R.string.guessMovie03_option1,
                    R.string.guessMovie03_option2,R.string.guessMovie03_option3,
                    R.string.guessMovie03_option4,R.string.guessMovie03_correctOption),
            new QuestionAnswer(R.drawable.image04_houseful,R.string.guessMovie04_option1,
                    R.string.guessMovie04_option2,R.string.guessMovie04_option3,
                    R.string.guessMovie04_option4,R.string.guessMovie04_correctOption),
            new QuestionAnswer(R.drawable.image05_baabul,R.string.guessMovie05_option1,
                    R.string.guessMovie05_option2,R.string.guessMovie05_option3,
                    R.string.guessMovie05_option4,R.string.guessMovie05_correctOption),
            new QuestionAnswer(R.drawable.image06_rocky_handsome,R.string.guessMovie06_option1,
                    R.string.guessMovie06_option2,R.string.guessMovie06_option3,
                    R.string.guessMovie06_option4,R.string.guessMovie06_correctOption),
            new QuestionAnswer(R.drawable.image07_satyamev_jayte,R.string.guessMovie07_option1,
                    R.string.guessMovie07_option2,R.string.guessMovie07_option3,
                    R.string.guessMovie07_option4,R.string.guessMovie07_correctOption),
            new QuestionAnswer(R.drawable.image08_happy_new_year,R.string.guessMovie08_option1,
                    R.string.guessMovie08_option2,R.string.guessMovie08_option3,
                    R.string.guessMovie08_option4,R.string.guessMovie08_correctOption),
            new QuestionAnswer(R.drawable.image09_ramleela,R.string.guessMovie09_option1,
                    R.string.guessMovie09_option2,R.string.guessMovie09_option3,
                    R.string.guessMovie09_option4,R.string.guessMovie09_correctOption),
            new QuestionAnswer(R.drawable.image10_om_shanti_om,R.string.guessMovie10_option1,
                    R.string.guessMovie10_option2,R.string.guessMovie10_option3,
                    R.string.guessMovie10_option4,R.string.guessMovie10_correctOption),
            new QuestionAnswer(R.drawable.image11_chennai_express,R.string.guessMovie11_option1,
                    R.string.guessMovie11_option2,R.string.guessMovie11_option3,
                    R.string.guessMovie11_option4,R.string.guessMovie11_correctOption),
            new QuestionAnswer(R.drawable.image12_kick,R.string.guessMovie12_option1,
                    R.string.guessMovie12_option2,R.string.guessMovie12_option3,
                    R.string.guessMovie12_option4,R.string.guessMovie12_correctOption),
            new QuestionAnswer(R.drawable.image13_bajrangi_bhaijan,R.string.guessMovie13_option1,
                    R.string.guessMovie13_option2,R.string.guessMovie13_option3,
                    R.string.guessMovie13_option4,R.string.guessMovie13_correctOption),
            new QuestionAnswer(R.drawable.image14_london_paris_newyork,R.string.guessMovie14_option1,
                    R.string.guessMovie14_option2,R.string.guessMovie14_option3,
                    R.string.guessMovie14_option4,R.string.guessMovie14_correctOption),
            new QuestionAnswer(R.drawable.image15_phir_hera_pheri,R.string.guessMovie15_option1,
                    R.string.guessMovie15_option2,R.string.guessMovie15_option3,
                    R.string.guessMovie15_option4,R.string.guessMovie15_correctOption)

    };

    final int progresbar_increment_number = (int)Math.ceil(100.0/mMovieQuestionBank.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_movie);

        movieImage = findViewById(R.id.movieImage);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        mProgressBar = findViewById(R.id.progressBar);
        mScoreTextView= findViewById(R.id.score);

        mQuestionAnswer = mMovieQuestionBank[mIndex];
        movieImage.setImageResource(mQuestionAnswer.getQuestionId());
        option1.setText(mQuestionAnswer.getA());
        option2.setText(mQuestionAnswer.getB());
        option3.setText(mQuestionAnswer.getC());
        option4.setText(mQuestionAnswer.getD());

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(option1.getText());
                updateQuestion();
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(option2.getText());
                updateQuestion();
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(option3.getText());
                updateQuestion();
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(option4.getText());
                updateQuestion();
            }
        });



    }

    public void checkAnswer(CharSequence userSelection)
    {

       CharSequence correctAnswer = getResources().getText(mQuestionAnswer.getCorrectOption());
       if(mToast!=null)
           mToast.cancel();
       if(correctAnswer==userSelection) {
           mScore++;
           mToast = Toast.makeText(this, "You Got It", Toast.LENGTH_SHORT);
       }
       else
           mToast = Toast.makeText(this,"Oops Wrong Answer", Toast.LENGTH_SHORT);
       mToast.show();

    }

    public void updateQuestion()
    {
        mIndex = (mIndex+1)%mMovieQuestionBank.length;
        if(mIndex==0) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Game Over");
            alert.setCancelable(false);
            alert.setMessage("Your Score is: " + mScore);
            alert.setPositiveButton("Go To Menu", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(GuessMovieActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            });
            alert.show();
        }

        else {
            mQuestionAnswer = mMovieQuestionBank[mIndex];
            movieImage.setImageResource(mQuestionAnswer.getQuestionId());
            option1.setText(mQuestionAnswer.getA());
            option2.setText(mQuestionAnswer.getB());
            option3.setText(mQuestionAnswer.getC());
            option4.setText(mQuestionAnswer.getD());

            mProgressBar.incrementProgressBy(progresbar_increment_number);
            mScoreTextView.setText("Score " + mScore + "/" + mMovieQuestionBank.length);
        }
    }
}
