package com.example.petanigg.desine


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.petanigg.Repository.TireRepository
import com.example.petanigg.table.TireTable
import kotlinx.coroutines.launch

class TireViewModel(private val repository: TireRepository): ViewModel() {
    val allTires: LiveData<List<TireTable>> = repository.allTires.asLiveData()

    fun insert(tire: TireTable) = viewModelScope.launch {
        repository.insert(tire)
    }

    fun delete(tire: TireTable) = viewModelScope.launch {
        repository.delete(tire)
    }

    fun update(tire: TireTable) = viewModelScope.launch {
        repository.update(tire)
    }
}

class TireViewModelFactory(private val repository: TireRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TireViewModel::class.java)) {
            return TireViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}