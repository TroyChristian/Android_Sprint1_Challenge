package com.example.myapplication
import kotlinx.android.synthetic.main.activity_edit_page.et_movie_title
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.Movie.Movie

class EditPageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_page)



        var bundle: Bundle? = intent.extras
        if(bundle != null){

        }
        fun loadMovie(movie:Movie){
            et_movie_title.setText(movie.title)
        }
    }
}

