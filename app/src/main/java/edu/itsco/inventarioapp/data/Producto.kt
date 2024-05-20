package edu.itsco.inventarioapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "productos")
data class Producto(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nombre: String,
    val precio: Double,
    val cantidad: Int
)