package com.example.myapplication
//comment for initial commit
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.myapplication.Movie.Movie
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {
    var movieList = mutableListOf<Movie>()
    var counter = 0

    companion object{
        const val REQUEST_CODE_EDIT_MOVIE = 2

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        btn_add_movie.setOnClickListener{

        }
    }
    fun createTextView(movie: Movie, index:Int){
        var newMovieView = TextView(this)
        newMovieView.textSize = 24f
        newMovieView.id = index
        newMovieView.text = movie.title

        newMovieView.setOnClickListener{
            var movieIntent = Intent(createPackageContext(this), ListActivity)
            movieIntent.putExtra("movieKey", movieList[newMovieView.id])
        }

    }
}