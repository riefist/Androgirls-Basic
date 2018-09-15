package android.thortechasia.androidgirlsfinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtTeamA, edtTeamB;
    private TextView txtTeamA, txtScoreTeamA, txtTeamB, txtScoreTeamB;
    private ConstraintLayout layoutPrevious;

    public static final int REQUEST_HASIL = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTeamA = findViewById(R.id.edt_teamA);
        edtTeamB = findViewById(R.id.edt_teamB);
        txtTeamA = findViewById(R.id.txt_teamA);
        txtTeamB = findViewById(R.id.txt_teamB);
        txtScoreTeamA = findViewById(R.id.txt_score_teamA);
        txtScoreTeamB = findViewById(R.id.txt_score_teamB);
        layoutPrevious = findViewById(R.id.layout_previous_match);
    }

    public void matchBegin(View v) {
        Intent i = new Intent(MainActivity.this, CounterActivity.class);
        i.putExtra(CounterActivity.EXTRA_TEAMA, edtTeamA.getText().toString());
        i.putExtra(CounterActivity.EXTRA_TEAMB, edtTeamB.getText().toString());
        startActivityForResult(i, REQUEST_HASIL);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_HASIL) {
            if (resultCode == RESULT_OK) {
                layoutPrevious.setVisibility(View.VISIBLE);
                txtTeamA.setText(data.getStringExtra(CounterActivity.EXTRA_TEAMA));
                txtTeamB.setText(data.getStringExtra(CounterActivity.EXTRA_TEAMB));
                txtScoreTeamA.setText(""+data.getIntExtra(CounterActivity.EXTRA_SCORE_TEAMA, 0));
                txtScoreTeamB.setText(""+data.getIntExtra(CounterActivity.EXTRA_SCORE_TEAMB, 0));
            }
        }
        super.onActivityResult(requestCode, resultCode, data);

    }
}


