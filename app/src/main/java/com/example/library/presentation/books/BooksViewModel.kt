package com.example.library.presentation.books

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.library.domain.model.books.Book
import com.example.library.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val _state = MutableStateFlow<List<Book>>(emptyList())
    val state = _state

    init {
        viewModelScope.launch {
            repository.getAllBooks().let {
                _state.value = it
            }
        }
    }
}