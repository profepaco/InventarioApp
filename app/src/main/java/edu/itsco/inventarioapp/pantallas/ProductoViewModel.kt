package edu.itsco.inventarioapp.pantallas

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import edu.itsco.inventarioapp.data.InventarioDB
import edu.itsco.inventarioapp.data.Producto
import edu.itsco.inventarioapp.data.ProductoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class ProductoViewModel(application: Application): ViewModel() {

    private val productoRepository: ProductoRepository
    val allProductos: Flow<List<Producto>>

    val listState: StateFlow<HomeUiState>
    init{
        val myDb = InventarioDB.companion.getInstance(
            application.applicationContext)
        productoRepository = ProductoRepository(myDb.getProductoDao())
        allProductos = productoRepository.getProductos()
        listState  = productoRepository
            .getProductos()
            .map{
            HomeUiState(it)
        }.stateIn(
                scope = viewModelScope,
                started = SharingStarted
                    .WhileSubscribed(
                        5_00L
                    ),
                initialValue = HomeUiState()
            )
    }

    suspend fun insertarProducto(producto: Producto){
        productoRepository.insertarProducto(producto)
    }
}

data class HomeUiState(
    val list: List<Producto> = listOf()
)

class ProductoViewModelFactory(val application: Application)
    :ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductoViewModel(application) as T
    }
}