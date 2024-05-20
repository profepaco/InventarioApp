package edu.itsco.inventarioapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Producto::class],
    version = 1, exportSchema = false)
abstract class InventarioDB: RoomDatabase() {

    abstract fun getProductoDao(): ProductoDao

    object companion {

        @Volatile
        private var Instance: InventarioDB? = null

        fun getInstance(context: Context)
            : InventarioDB{
            return Instance ?: synchronized(this){
                Room.databaseBuilder(
                    context = context,
                    InventarioDB::class.java,
                    "db_inventario")
                    .build()
                    .also{
                        Instance = it
                    }
            }
        }
    }
}