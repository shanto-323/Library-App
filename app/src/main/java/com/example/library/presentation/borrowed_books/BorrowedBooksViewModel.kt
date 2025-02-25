package com.example.library.presentation.borrowed_books

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.library.domain.model.borrowed_books.BorrowedBooksTypeItem
import com.example.library.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BorrowedBooksViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _state = MutableStateFlow<List<BorrowedBooksTypeItem>>(emptyList())
    val state = _state

    init {
        viewModelScope.launch {
            repository.getAllBorrowedBooks().let {
                _state.value = it
            }
        }
    }
}