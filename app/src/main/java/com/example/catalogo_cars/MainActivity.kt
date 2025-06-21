package com.example.catalogo_cars

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.catalogo_cars.ui.theme.Catalogo_CarsTheme

class MainActivity : ComponentActivity() {
    private val carrosPorPais = mapOf(
        "Alemanha" to mapOf(
            "BMW" to listOf("M3", "X6"),
            "Mercedes-Benz" to listOf("SLR", "300 SL"),
            "Audi" to listOf("R8", "RS6"),
            "Volkswagen" to listOf("Golf R", "Passat")
        ),
        "Japão" to mapOf(
            "Toyota" to listOf("Corolla", "Supra"),
            "Honda" to listOf("Civic", "Accord"),
            "Nissan" to listOf("GTR-34", "350z"),
            "Mazda" to listOf("MX-5", "CX-5")
        ),
        "EUA" to mapOf(
            "Ford" to listOf("Corolla", "Supra"),
            "Chevrolet" to listOf("Camaro", "Corvette c6"),
            "Cadillac" to listOf("Hennessey CTS-V", "Eldorado Biarritz"),
            "Dodge" to listOf("Challenger SRT Hellcat", "Charger 1970")
        ),
        "Itália" to mapOf(
            "Ferrari" to listOf("F40", "458 Italia"),
            "Lamborghini" to listOf("Diablo SV", "Murcielago"),
            "AlfaRomeo" to listOf("8C Competizione", "Giulia Quadrifoglio"),
            "Lancia" to listOf("Delta integrale HF", "037")
        )
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Catalogo_CarsTheme {
                AppUI(carrosPorPais)
            }
        }
    }
}


@Composable
fun AppUI(carrosPorPais: Map<String, Map<String, List<String>>>) {
    var paisSelecionado by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp) // ajusta consoante o teu mapa
        ) {
            // Mapa centralizado
            Image(
                painter = painterResource(R.drawable.mapa2),
                contentDescription = "Mapa",
                modifier = Modifier
                    .fillMaxSize(),

                contentScale = ContentScale.Crop

            )

            Button(
                onClick = { paisSelecionado = "Alemanha" },
                modifier = Modifier
                    .offset(x = 160.dp, y = 105.dp)
                    .size(width = 64.dp, height = 30.dp),
                contentPadding = PaddingValues(0.dp)
                ) {
                Text("DEU", fontSize = 8.sp)
            }

            Button(
                onClick = { paisSelecionado = "Japão" },
                modifier = Modifier
                    .offset(x = 355.dp, y = 130.dp)
                    .size(width = 64.dp, height = 30.dp),
                contentPadding = PaddingValues(0.dp)
                ) {
                Text("JPN", fontSize = 8.sp)
            }

            Button(
                onClick = { paisSelecionado = "EUA" },
                modifier = Modifier
                    .offset(x = 30.dp, y = 135.dp)
                    .size(width = 60.dp, height = 30.dp),
                contentPadding = PaddingValues(0.dp),
                ) {
                Text("EUA", fontSize = 8.sp)
            }

            Button(
                onClick = { paisSelecionado = "Itália" },
                modifier = Modifier
                    .offset(x = 185.dp, y = 125.dp)
                    .size(width = 64.dp, height = 30.dp),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text("ITA", fontSize = 8.sp)
            }
        }

        paisSelecionado?.let { pais ->
            val marcas = carrosPorPais[pais]
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .background(Color.White.copy(alpha = 0.9f))
                    .padding(8.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                marcas?.forEach { (marca, modelos) ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        val logoId = remember(marca) {
                            val nome = marca.lowercase().replace(" ", "").replace("-", "")
                            R.drawable::class.java.getDeclaredField(nome).getInt(null)
                        }
                        Image(
                            painter = painterResource(id = logoId),
                            contentDescription = marca,
                            modifier = Modifier.size(60.dp)
                        )
                        Text(
                            text = modelos.joinToString("\n"),
                            fontSize = 14.sp,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }
            }
        } ?: Text("Nenhum carro encontrado", color = Color.Gray)
    }
}

