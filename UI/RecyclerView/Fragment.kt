package <PROJECT>.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.drspaceman.tmdb_retrofit_example.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    // View Binding class generated from layout/fragment_home.xml
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var popularAdapter: MovieRecyclerviewAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        setupRecyclerView()

        return binding.root
    }

    private fun setupRecyclerView() {
        popularAdapter = MovieRecyclerviewAdapter()
        binding.recyclerviewHomePopularmovies.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        binding.recyclerviewHomePopularmovies.itemAnimator = DefaultItemAnimator()
        binding.recyclerviewHomePopularmovies.adapter = popularAdapter

        homeViewModel.popularMovies.observe(viewLifecycleOwner, Observer {
            popularAdapter.movieList = it
            popularAdapter.notifyDataSetChanged()
        })

        homeViewModel.fetchMovies()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}