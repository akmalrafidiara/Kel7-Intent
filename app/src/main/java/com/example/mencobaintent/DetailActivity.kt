package com.example.mencobaintent

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mencobaintent.ui.theme.MencobaIntentTheme

class DetailActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent() {
            MencobaIntentTheme {
                Text(text = "Halo ini page 2 anjay kelazzz")
            }
            Box(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                Button(onClick = {
                    Intent(application, MainActivity::class.java).also {
                        startActivity(it)
                        finish()
                    }
                }) {
                    Text(text = "Kembali")
                }
            }
        }
    }
}