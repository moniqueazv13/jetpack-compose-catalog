package com.example.jetpackcomposecatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecatalog.ui.theme.JetpackComposeCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCatalogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyBox()
                }
            }
        }
    }
}

/**
 * Através do Modifier é possível alterar o alinhamento dos filhos com a propriedade
 * contentAlignment = Aligment.Center
 */
@Composable
fun MyBox() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        /**
         * Ao remover os valores de width e height abaixo, o layout interpreta como "wrapcontent", e o bloco
         * azul desaparece
         */
        Box(modifier = Modifier.background(Color.Cyan)) {
            Text(text = "Isso é um exemplo")

            /**
             * Enquanto o bloco azul não tiver widht e height definidos,
             * ele irá seguir o tamanho do componente Text.
             * Porém, caso seja definidos, isso limita a expansão do componente Texte e pode distorcer a
             * exibição do texto, já que o mesmo depende da expansividade do box.
             */
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeCatalogTheme {
        MyBox()
    }
}