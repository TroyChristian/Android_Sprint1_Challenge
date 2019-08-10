package com.example.myapplication
//comment for initial commit
import android.app.Activity
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

        btn_add_movie.setOnClickListener{
            var addMovieIntent = Intent(this, EditPageActivity::class.java)
            startActivityForResult(addMovieIntent, REQUEST_CODE_EDIT_MOVIE)
        }
    }

    fun refreshMovieList(){
        ll_movielist.removeAllViews()
        for((counter, movie) in movieList.withIndex()) {
            createTextView(movie, counter)
        }
    }
    override fun onPostResume(){
        refreshMovieList()
        super.onPostResume()
    }


    fun createTextView(movie: Movie, index:Int): TextView {
        var newMovieView = TextView(this)
        newMovieView.textSize = 24f
        newMovieView.id = index
        newMovieView.text = movie.title

        newMovieView.setOnClickListener{
            var movieIntent = Intent(this, EditPageActivity::class.java)
            movieIntent.putExtra("movieKey", movieList[newMovieView.id])
            movieList.removeAt(newMovieView.id)
            startActivityForResult(movieIntent, REQUEST_CODE_EDIT_MOVIE)
        }
        return newMovieView


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == REQUEST_CODE_EDIT_MOVIE && resultCode == Activity.RESULT_OK){
            val newResultMovie = data!!.getSerializableExtra("movie") as Movie
            movieList.add(newResultMovie)
            ll_movielist.addView(createTextView(newResultMovie, counter))
            //counter++
        }
    }
}