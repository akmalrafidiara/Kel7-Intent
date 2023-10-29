package com.example.mencobaintent

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.mencobaintent.ui.theme.MencobaIntentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MencobaIntentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

//                Intent(Intent.ACTION_MAIN).also {
//                    it.`package` = "com.google.android.apps.maps"
//                    startActivity(it)
//                }

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val intent = Intent(context, DetailActivity::class.java)
    val contextMap = LocalContext.current
    val intentMap = Intent(Intent.ACTION_MAIN).also {
        it.`package` = "com.google.android.apps.maps"
    }
    Column {
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(painter = painterResource(id = R.drawable.banner), contentDescription = null, modifier = Modifier.fillMaxWidth())
        }
        Text(text = "Senja Merah", modifier = modifier.padding(16.dp), fontWeight = FontWeight.Bold)
        Text(text = "Di tepian pantai yang tenang dan indah,\n" +
                "Wanita berambut merah, cahaya senja menerangi wajahnya.\n" +
                "Matanya memancarkan pesona, merenung dalam kejernihan,\n" +
                "Seakan menyaksikan matahari merunduk dalam perpisahan.\n" +
                "\n", modifier = modifier.padding(16.dp).padding(bottom = 2.dp))
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            contentAlignment = androidx.compose.ui.Alignment.CenterEnd
        ) {
            Row {
                Button(onClick = {
                    // ContextCompat.
                    startActivity(context, intent, null)
                }, modifier = Modifier.padding(end = 8.dp)) {
                    Text(text = "Detail")
                }
                Button(onClick = {
                    startActivity(contextMap, intentMap, null)
                }) {
                    Text(text = "Open Maps")
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MencobaIntentTheme {
        Greeting()
    }
}