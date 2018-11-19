package android.thortechasia.androidgirlsfinalproject

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_row_match.view.*

class MatchAdapter(val matches: List<Match>) : RecyclerView.Adapter<MatchViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MatchViewHolder {
        val view = p0.inflate(R.layout.item_row_match)
        return MatchViewHolder(view)
    }

    override fun getItemCount(): Int = matches.size

    override fun onBindViewHolder(p0: MatchViewHolder, p1: Int) {
        p0.bindItems(matches[p1])
    }
}

class MatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindItems(match: Match) = with(itemView){
        txt_teamA.text = match.teamA
        txt_teamB.text = match.teamB
        txt_score_teamA.text = "${match.teamAScore}"
        txt_score_teamB.text = "${match.teamBScore}"
    }

}