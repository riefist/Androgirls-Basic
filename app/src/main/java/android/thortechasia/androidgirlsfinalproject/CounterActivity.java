package android.thortechasia.androidgirlsfinalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CounterActivity extends AppCompatActivity {

    public static final String EXTRA_TEAMA = "extra_teama";
    public static final String EXTRA_TEAMB = "extra_teamb";
    public static final String EXTRA_SCORE_TEAMA = "extra_score_teama";
    public static final String EXTRA_SCORE_TEAMB = "extra_score_teamb";

    private TextView txtTeamA, txtTeamB;

    int scoreTeamA = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        txtTeamA = findViewById(R.id.teamA_name);
        txtTeamB = findViewById(R.id.teamB_name);

        String teamA = getIntent().getStringExtra(EXTRA_TEAMA);
        String teamB = getIntent().getStringExtra(EXTRA_TEAMB);

        txtTeamA.setText(teamA);
        txtTeamB.setText(teamB);

    }

    public void addOneForTeamA(View v) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    public void addTwoForTeamA(View v) {
        scoreTeamA = scoreTeamA + 2;
        displayForTeamA(scoreTeamA);
    }

    public void addThreeForTeamA(View v) {
        scoreTeamA = scoreTeamA + 3;
        displayForTeamA(scoreTeamA);
    }

    public void addOneForTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    public void addTwoForTeamB(View v) {
        scoreTeamB = scoreTeamB + 2;
        displayForTeamB(scoreTeamB);
    }

    public void addThreeForTeamB(View v) {
        scoreTeamB = scoreTeamB + 3;
        displayForTeamB(scoreTeamB);
    }

    public void resetScore(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    public void saveResult(View v){
        Intent intent = new Intent();
        intent.putExtra(EXTRA_TEAMA, txtTeamA.getText().toString());
        intent.putExtra(EXTRA_TEAMB, txtTeamB.getText().toString());
        intent.putExtra(EXTRA_SCORE_TEAMA, scoreTeamA);
        intent.putExtra(EXTRA_SCORE_TEAMB, scoreTeamB);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void displayForTeamA(int score) {
        TextView scoreView = findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        TextView scoreView = findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
}
