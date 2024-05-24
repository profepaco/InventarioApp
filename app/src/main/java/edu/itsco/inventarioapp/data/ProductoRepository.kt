package edu.itsco.inventarioapp.data

import kotlinx.coroutines.flow.Flow

class ProductoRepository(private val daoProducto: ProductoDao) {

    fun getProductos(): Flow<List<Producto>>
        = daoProducto.getAll()

    suspend fun insertarProducto(producto: Producto)
        = daoProducto.insert(producto)
}