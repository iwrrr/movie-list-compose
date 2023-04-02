package com.hwaryun.movielist.presentation.movie_list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hwaryun.movielist.domain.use_case.GetNowPlayingMoviesUseCase
import com.hwaryun.movielist.utils.ext.subscribe
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase
) : ViewModel() {

    var state by mutableStateOf(MovieListState())

    init {
        getMovies()
    }

    fun getMovies() {
        viewModelScope.launch {
            getNowPlayingMoviesUseCase().collect {
                it.subscribe(
                    doOnLoading = {
                        state = state.copy(isLoading = true)
                    },
                    doOnEmpty = {
                        state = state.copy(
                            isLoading = false,
                            movies = emptyList()
                        )
                    },
                    doOnSuccess = { result ->
                        result.payload?.let { movies ->
                            state = state.copy(
                                isLoading = false,
                                movies = movies
                            )
                        }
                    },
                    doOnError = { error ->
                        state = state.copy(
                            isLoading = false,
                            error = error.exception?.message.toString()
                        )
                    }
                )
            }
        }
    }
}