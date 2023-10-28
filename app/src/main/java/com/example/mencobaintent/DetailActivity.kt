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
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mencobaintent.ui.theme.MencobaIntentTheme

class DetailActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent() {
            MencobaIntentTheme {
                Column {
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)) {
                        Button(onClick = {
                            Intent(application, MainActivity::class.java).also {
                                startActivity(it)
                                finish()
                            }
                        }) {
                            Text(text = "Kembali")
                        }
                    }
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
                        modifier = Modifier.fillMaxWidth().clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                }
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Name: Makima")
                    Text(text = "Age: -")
                    Text(text = "Hobby: Mancing")
                }
            }
            Text(text = "Makima adalah karakter yang kompleks dan ambigu. Di awal cerita, ia muncul sebagai mentor dan pemimpin dari protagonis utama, Chainsaw Man (Denji). Ia sering terlihat tenang, bijak, dan peduli terhadap kesejahteraan anggota timnya. Namun, seiring perkembangan cerita, sifat sebenarnya Makima mulai terungkap. Ia dianggap sebagai salah satu antagonis utama dalam cerita, yang memiliki agenda rahasia dan kepentingan pribadi yang kuat.",
                modifier = Modifier.padding(top = 16.dp))
        }
    }
}