package edu.itsco.inventarioapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductoDao {

    @Query("SELECT * FROM productos")
    fun getAll(): Flow<List<Producto>>

    @Query("SELECT * FROM productos WHERE id = :id")
    fun getProducto(id: Int): Flow<Producto>

    @Insert
    suspend fun insert(producto: Producto)


}