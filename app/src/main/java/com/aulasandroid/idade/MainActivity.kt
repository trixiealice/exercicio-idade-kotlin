package com.aulasandroid.idade

import android.R
import android.R.attr.text
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulasandroid.idade.ui.theme.IdadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IdadeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BasicComponentesScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
var idade by mutableStateOf(
    0
)

var maiorIdade by mutableStateOf(
    "MENOR"
)

@Composable
fun BasicComponentesScreen(modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp),

        verticalArrangement = Arrangement.Center

    ) {
        Text(
            text = "Qual é a sua idade?",
            fontSize = 28.sp,
            color = Color(0xFF3F51B5),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),

        )

        Text(
            text = "Aperte os botões para informar a sua idade",
            fontSize = 24.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()

        )


        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = idade.toString(),
            fontSize = 24.sp,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))



        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Botao(valor = -1)
            Botao(valor = 1)

        }

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "você é $maiorIdade de idade",
            fontSize = 28.sp,
            color = Color(0xFF3F51B5),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),

            )

    }
}


@Composable
fun Botao (modifier: Modifier = Modifier, valor: Int = 0) {
    Button(
        onClick = {
            var novaIdade = idade + valor
            if (novaIdade in 0..180) {
                idade += valor
            }
            if (idade < 18) {
                maiorIdade = "MENOR"
        } else {
            maiorIdade = "MAIOR"
        }

        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(63, 81, 181, 255),
            contentColor = Color(255, 255, 255, 255)
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

        }
        if (valor < 0){
            Text(
                text = "-",
                fontSize = 24.sp
            )
        } else {
            Text(
                text = "+",
                fontSize = 24.sp
            )
        }


    }
}