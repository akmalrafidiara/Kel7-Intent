package com.example.mencobaintent

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mencobaintent.ui.theme.MencobaIntentTheme

class DetailActivity: ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MencobaIntentTheme {
                Column {
                    TopAppBar(title = {
                        TextButton(onClick = {
                            Intent(application, MainActivity::class.java).also {
                                startActivity(it)
                                finish()
                            }
                        }) {
                            Icon(Icons.Filled.ArrowBack, contentDescription = null)
                            Text(text = "Kembali")
                        }
                    })
                    DetailContent()
                }
            }

        }
    }

    @Composable
    fun DetailContent() {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "More about her", fontWeight = FontWeight.Bold)
            Row(modifier = Modifier.padding(top = 16.dp)) {
                Box(modifier = Modifier.size(100.dp)){
                    Image(
                        painter = painterResource(id = R.drawable.detail),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                }
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Name: Makima")
                    Text(text = "Age: -")
                    Text(text = "Hobby: Mancing")
                    TextButton(onClick = {
                        val intent = Intent(Intent.ACTION_SEND).apply {
                            type = "text/plain"
                            putExtra(Intent.EXTRA_EMAIL, arrayOf("makima@chain.com"))
                            putExtra(Intent.EXTRA_SUBJECT, "Hello, world!")
                            putExtra(Intent.EXTRA_TEXT, "This is a message from my app")
                        }
                        if(intent.resolveActivity(packageManager) != null) {
                            startActivity(intent)
                        }
                    }) {
                        Text(text = "Send Mail")
                    }
                }
            }
            Text(text = "Makima adalah karakter yang kompleks dan ambigu. Di awal cerita, ia muncul sebagai mentor dan pemimpin dari protagonis utama, Chainsaw Man (Denji). Ia sering terlihat tenang, bijak, dan peduli terhadap kesejahteraan anggota timnya. Namun, seiring perkembangan cerita, sifat sebenarnya Makima mulai terungkap. Ia dianggap sebagai salah satu antagonis utama dalam cerita, yang memiliki agenda rahasia dan kepentingan pribadi yang kuat.",
                modifier = Modifier.padding(top = 16.dp))
        }
    }
}