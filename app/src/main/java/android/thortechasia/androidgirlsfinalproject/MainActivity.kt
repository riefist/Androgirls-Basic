package android.thortechasia.androidgirlsfinalproject

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val matches: MutableList<Match> = mutableListOf()
    private lateinit var matchAdapter: MatchAdapter

    companion object {
        const val REQUEST_HASIL = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRv()

        btn_match_begin.setOnClickListener {
            val i = Intent(this@MainActivity, CounterActivity::class.java)
            i.putExtra(CounterActivity.EXTRA_TEAMA, edt_teamA.text.toString())
            i.putExtra(CounterActivity.EXTRA_TEAMB, edt_teamB.text.toString())
            startActivityForResult(i, REQUEST_HASIL)
        }
    }

    private fun initRv(){
        rv_match.layoutManager = LinearLayoutManager(this)
        matchAdapter = MatchAdapter(matches)
        rv_match.adapter = matchAdapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_HASIL) {
            if (resultCode == Activity.RESULT_OK) {
                val teamA = data?.getStringExtra(CounterActivity.EXTRA_TEAMA)
                val teamB= data?.getStringExtra(CounterActivity.EXTRA_TEAMB)
                val teamAScore = data?.getStringExtra(CounterActivity.EXTRA_SCORE_TEAMA)
                val teamBScore = data?.getStringExtra(CounterActivity.EXTRA_SCORE_TEAMB)

                val match = Match(teamA, teamB, teamAScore?.toInt(), teamBScore?.toInt())
                matches.add(match)
                matchAdapter.notifyDataSetChanged()

                edt_teamB.setText("")
                edt_teamA.setText("")

            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

}


