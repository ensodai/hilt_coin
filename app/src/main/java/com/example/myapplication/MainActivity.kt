package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.myapplication.ui.theme.MyApplicationTheme
import dagger.hilt.android.AndroidEntryPoint
import org.koin.android.ext.android.inject
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var bicycleFactoryDagger: BicycleFactory

    private val bicycleFactoryKoin: BicycleFactory by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val context = LocalContext.current
            MyApplicationTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(
                            onClick = {
                                val bicycle = bicycleFactoryDagger
                                    .build(color = ColorBicycle(), logo = Logo()).toString()
                                Toast.makeText(context, bicycle, Toast.LENGTH_LONG).show()
                            }
                        ) {
                            Text(text = "Hilt")
                        }
                        Button(
                            onClick = {
                                val bicycle = bicycleFactoryKoin
                                    .build(color = ColorBicycle(), logo = Logo()).toString()
                                Toast.makeText(context, bicycle, Toast.LENGTH_LONG).show()
                            }
                        ) {
                            Text(text = "Koin")
                        }
                    }
                }


            }
        }
    }
}
