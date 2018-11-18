package android.thortechasia.androidgirlsfinalproject

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val REQUEST_HASIL = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_match_begin.setOnClickListener {
            val i = Intent(this@MainActivity, CounterActivity::class.java)
            i.putExtra(CounterActivity.EXTRA_TEAMA, edt_teamA.text.toString())
            i.putExtra(CounterActivity.EXTRA_TEAMB, edt_teamB.text.toString())
            startActivityForResult(i, REQUEST_HASIL)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_HASIL) {
            if (resultCode == Activity.RESULT_OK) {
                txt_teamA.text = data?.getStringExtra(CounterActivity.EXTRA_TEAMA)
                txt_teamB.text = data?.getStringExtra(CounterActivity.EXTRA_TEAMB)
                txt_score_teamA.text = data?.getStringExtra(CounterActivity.EXTRA_SCORE_TEAMA)
                txt_score_teamB.text = data?.getStringExtra(CounterActivity.EXTRA_SCORE_TEAMB)
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

}


