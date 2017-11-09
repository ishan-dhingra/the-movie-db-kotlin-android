package com.anythingintellect.themoviedb.view

import android.app.DatePickerDialog
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.DatePicker
import com.anythingintellect.themoviedb.R
import com.anythingintellect.themoviedb.TheMovieDBApp
import com.anythingintellect.themoviedb.adapter.MovieListAdapter
import com.anythingintellect.themoviedb.databinding.ActivityMainBinding
import com.anythingintellect.themoviedb.di.ContextModule
import com.anythingintellect.themoviedb.util.Navigator
import com.anythingintellect.themoviedb.util.toReleaseFormat
import com.anythingintellect.themoviedb.viewmodel.MovieListViewModel
import java.util.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MovieListViewModel
    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as TheMovieDBApp).appComponent
                .plusContext(ContextModule(this))
                .inject(this)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,
                R.layout.activity_main)
        binding.vm = viewModel
        viewModel.loadMovies(Date())
        setupRV(binding.rvList)
    }

    private fun setupRV(rvList: RecyclerView) {
        rvList.layoutManager = LinearLayoutManager(this)
        rvList.adapter = MovieListAdapter(viewModel.movies, navigator)
        rvList.addItemDecoration(DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL))
        rvList.addOnScrollListener(object  : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                val lastItem = (rvList.layoutManager as LinearLayoutManager)
                        .findLastVisibleItemPosition()
                val totalItem = (rvList.layoutManager as LinearLayoutManager).itemCount
                if (totalItem - 2 <= lastItem) {
                    viewModel.loadMovies()
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        menu!!.getItem(0).title = viewModel.date!!.toReleaseFormat()
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item!!.itemId == R.id.act_filter_release) {
            showReleasePicker()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showReleasePicker() {
        val calendar = Calendar.getInstance()
        calendar.time = viewModel.date
        val dialog = DatePickerDialog(this, onReleaseDateChanged,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH))
        dialog.show()
    }

    val onReleaseDateChanged = fun (picker: DatePicker, year: Int, month: Int, date: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, date)
        viewModel.loadMovies(calendar.time)
    }

}
