package id.antasari.p4appnavigation_230104040056.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FormViewModel : ViewModel() {
    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name

    private val _nim = MutableStateFlow("")
    val nim: StateFlow<String> = _nim

    fun save(name: String, nim: String) {
        viewModelScope.launch {
            _name.value = name
            _nim.value = nim
        }
    }
}