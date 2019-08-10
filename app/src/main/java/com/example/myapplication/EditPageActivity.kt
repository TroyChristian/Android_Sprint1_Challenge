package com.example.myapplication
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.Movie.Movie
import kotlinx.android.synthetic.main.activity_edit_page.*

class EditPageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_page)
        /*WATCHED*/      fun createMovie(): Movie{
            var newMovie = Movie(et_movie_title.text.toString(),false)
            return newMovie
        }
        btn_save_movie.setOnClickListener{
            var intentSaveMovie = Intent()
            intentSaveMovie.putExtra("movie", createMovie())

        }

        fun loadMovie(movie:Movie){
            et_movie_title.setText(movie.title)
        }

        var bundle: Bundle? = intent.extras
        if(bundle != null){
            loadMovie(bundle!!.getSerializable("tvMovie")as Movie)
        }

    }
}

