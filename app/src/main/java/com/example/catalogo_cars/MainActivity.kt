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
}
