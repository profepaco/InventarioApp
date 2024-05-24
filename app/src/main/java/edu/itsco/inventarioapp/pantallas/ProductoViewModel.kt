package edu.itsco.inventarioapp.pantallas

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import edu.itsco.inventarioapp.data.InventarioDB
import edu.itsco.inventarioapp.data.Producto
import edu.itsco.inventarioapp.data.ProductoRepository
import kotlinx.coroutines.flow.Flow

class ProductoViewModel(application: Application): ViewModel() {

    private val productoRepository: ProductoRepository
    val allProductos: Flow<List<Producto>>

    init{
        val myDb = InventarioDB.companion.getInstance(
            application.applicationContext)
        productoRepository = ProductoRepository(myDb.getProductoDao())
        allProductos = productoRepository.getProductos()
    }

    suspend fun insertarProducto(producto: Producto){
        productoRepository.insertarProducto(producto)
    }
}


class ProductoViewModelFactory(val application: Application)
    :ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductoViewModel(application) as T
    }
}