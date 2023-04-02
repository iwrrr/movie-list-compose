package com.hwaryun.movielist.domain.use_case

import com.hwaryun.movielist.data.repository.MovieRepository
import com.hwaryun.movielist.domain.mapper.toListMovie
import com.hwaryun.movielist.domain.model.Movie
import com.hwaryun.movielist.utils.ext.suspendSubscribe
import com.hwaryun.movielist.utils.wrapper.ViewResource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetNowPlayingMoviesUseCase @Inject constructor(
    private val repository: MovieRepository,
    dispatcher: CoroutineDispatcher
) : BaseUseCase<Nothing, List<Movie>>(dispatcher) {

    override suspend fun execute(param: Nothing?): Flow<ViewResource<List<Movie>>> = flow {
        emit(ViewResource.Loading())
        repository.getNowPlayingMovies().collect {
            it.suspendSubscribe(
                doOnSuccess = { result ->
                    result.payload?.results?.let { data ->
                        val movies = data.toListMovie()
                        if (movies.isEmpty()) {
                            emit(ViewResource.Empty())
                        } else {
                            emit(ViewResource.Success(movies))
                        }
                    }
                },
                doOnError = { error ->
                    emit(ViewResource.Error(error.exception))
                }
            )
        }
    }
}