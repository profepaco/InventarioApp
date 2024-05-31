package edu.itsco.inventarioapp.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import edu.itsco.inventarioapp.data.Producto
import edu.itsco.inventarioapp.navegacion.Pantallas
import edu.itsco.inventarioapp.ui.theme.InventarioAppTheme
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.toList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: ProductoViewModel
) {
    val homeUiState by
        viewModel.listState.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Productos")
                }
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    navController.navigate(
                        route = Pantallas.NuevoProducto.url
                    )
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add")
                Text("ADD")
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ) {
        Column(modifier = Modifier.padding(it)){
            ListaProductos(lista = homeUiState.list)
        }
    }
}

@Composable
fun ListaProductos(lista: List<Producto>){
    LazyColumn() {
        items(lista){
            ProductoCard(producto = it)
        }
    }
}

@Composable
fun ProductoCard(
    modifier: Modifier = Modifier,
    producto: Producto
){
    Card(modifier = modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Column(modifier.padding(8.dp)){
            Text(
                text = producto.nombre,
                style = MaterialTheme.typography.titleLarge
            )
            Row(){
                Text(
                    text = "Precio: ${producto.precio}",
                    Modifier.weight(1F)
                )
                Text(text = "Cantidad: ${producto.cantidad}")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListaProductoPreview() {
    val productos: List<Producto> = listOf(
        Producto(
            1,
            "Macbook",
            29999.99,
            3
        ),
        Producto(
            1,
            "Zephyrus G14",
            25999.99,
            5
        )
    )
    ListaProductos(lista = productos)
}

@Preview(showBackground = true)
@Composable
fun ProductoCardPreview(){
    ProductoCard(
        producto = Producto(
            1,
            "Macbook",
            29999.99,
            3))
}


/*
@Preview(showBackground = true)
@Composable
fun HomePreview(){
    InventarioAppTheme {
        HomeScreen(
            navController = rememberNavController()
        )
    }
}
*/