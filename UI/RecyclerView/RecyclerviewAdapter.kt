package <PROJECT>.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.drspaceman.tmdb_retrofit_example.R
import com.drspaceman.tmdb_retrofit_example.data.TmdbMovie
import com.drspaceman.tmdb_retrofit_example.databinding.ViewholderHomeMovieBinding

class MovieRecyclerviewAdapter() : RecyclerView.Adapter<MovieRecyclerviewAdapter.MovieViewHolder>() {
    var movieList: List<TmdbMovie> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        
        // Example ViewBinding class: generated from layout/viewholder_home_movie.xml
        val binding = ViewholderHomeMovieBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )

        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movieList[position])
    }

    override fun getItemCount() = movieList.size

    // ViewHolder for Recyclerview item
    inner class MovieViewHolder(val binding: ViewholderHomeMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindMovie(movie: TmdbMovie) {
            binding.textviewHomeMovietitle.text = movie.title
            binding.textviewHomeMovieyear.text = movie.release_date.substring(0, 4)

            // Load images with Glide
            val posterUrl = movie.getPosterUrl()
            Glide.with(itemView)
                .load(posterUrl)
                .fitCenter()
                .placeholder(R.drawable.ic_movie_generic)
                .error(R.drawable.ic_image_broken)
                .fallback(R.drawable.ic_movie_generic)
                .into(binding.imageviewHomeMovieposter)


            //            itemView.setOnClickListener {
//                // TODO: load details page
//            }
        }

    }
}
