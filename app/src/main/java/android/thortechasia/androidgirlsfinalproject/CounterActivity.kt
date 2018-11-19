package android.thortechasia.androidgirlsfinalproject

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_counter.*

class CounterActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TEAMA = "extra_teama"
        const val EXTRA_TEAMB = "extra_teamb"

        const val EXTRA_SCORE_TEAMA = "extra_score_teama"
        const val EXTRA_SCORE_TEAMB = "extra_score_teamb"
    }

    //variabel score untuk menyimpan score selama pertandingan
    private var scoreTeamA = 0
    private var scoreTeamB = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)

        //get nama team from main activity
        val teamA = intent.getStringExtra(EXTRA_TEAMA)
        val teamB = intent.getStringExtra(EXTRA_TEAMB)

        // set text ke textview
        teamA_name.text = teamA
        teamB_name.text = teamB

        teamAListener()
        teamBListener()
        buttonListener()

    }

    private fun teamAListener() {

        btnTeamA_Plus1.setOnClickListener {
            scoreTeamA += 1
            team_a_score.text = scoreTeamA.toString()
        }

        btnTeamA_Plus2.setOnClickListener {
            scoreTeamA += 2
            team_a_score.text = scoreTeamA.toString()
        }

        btnTeamA_Plus3.setOnClickListener {
            scoreTeamA += 3
            team_a_score.text = scoreTeamA.toString()
        }
    }

    private fun teamBListener() {
        btnTeamB_Plus1.setOnClickListener {
            scoreTeamB += 1
            team_b_score.text = scoreTeamB.toString()
        }

        btnTeamB_Plus2.setOnClickListener {
            scoreTeamB += 2
            team_b_score.text = scoreTeamB.toString()
        }

        btnTeamB_Plus3.setOnClickListener {
            scoreTeamB += 3
            team_b_score.text = scoreTeamB.toString()
        }
    }

    private fun buttonListener() {
        btn_reset.setOnClickListener {
            scoreTeamA = 0
            scoreTeamB = 0
            team_a_score.text = scoreTeamA.toString()
            team_b_score.text = scoreTeamB.toString()
        }

        btn_simpan.setOnClickListener {
            this.toast("Match Berakhir")
            val i = Intent()
            i.putExtra(EXTRA_TEAMA, teamA_name.text.toString())
            i.putExtra(EXTRA_TEAMB, teamB_name.text.toString())
            i.putExtra(EXTRA_SCORE_TEAMA, team_a_score.text.toString())
            i.putExtra(EXTRA_SCORE_TEAMB, team_b_score.text.toString())
            setResult(Activity.RESULT_OK, i)
            finish()
        }
    }

}
