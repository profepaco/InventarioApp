package edu.itsco.inventarioapp.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import edu.itsco.inventarioapp.navegacion.Pantallas
import edu.itsco.inventarioapp.ui.theme.InventarioAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NuevoProductoScreen(
    navController: NavHostController
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Nuevo producto")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(
                            route= Pantallas.Home.url
                        )
                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Regresar"
                        )
                    }
                }
            )
        }
    ) {
        Formulario(Modifier.padding(it),
            navController)
    }
}

@Composable
fun Formulario(
    modifier: Modifier = Modifier,
    navController: NavHostController
){
    var nombre by remember {
        mutableStateOf("")
    }
    var precio by remember{
        mutableStateOf("")
    }
    var cantidad by remember{
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .padding(
                top = 64.dp,
                start = 8.dp,
                end = 8.dp
            )
            .fillMaxWidth()
    ) {
        OutlinedTextField(
            value = nombre,
            onValueChange = {
                nombre = it
            },
            label = { Text("Nombre")},
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = precio ,
            onValueChange = {
                precio = it
            },
            label = { Text("Precio")},
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            )
        )
        OutlinedTextField(
            value = cantidad,
            onValueChange = {
                cantidad = it
            },
            label = { Text("Cantidad")},
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(all = 8.dp)
        ){
            Button(onClick = {

            }){
                Text("Guardar")
            }
            OutlinedButton(onClick = {
                navController.navigate(
                    route = Pantallas.Home.url
                )
            })
            {
                Text("Cancelar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNuevoProductoScreen(){
    InventarioAppTheme {
        NuevoProductoScreen(
            navController = rememberNavController()
        )
    }
}