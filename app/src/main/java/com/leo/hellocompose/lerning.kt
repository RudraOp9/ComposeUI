package com.leo.hellocompose

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.leo.hellocompose.ui.theme.HelloComposeTheme

class lerning : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2("hello world", context = this)
                }
            }
        }
    }


    fun script(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    @Composable
    fun Greeting2(text: String, modifier: Modifier = Modifier,context: Context) {

        Row(horizontalArrangement = Arrangement.Center, modifier = modifier) {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_background),
                contentDescription = "image",
                modifier = modifier
                    .padding(top = 20.dp)
                    .clickable(true, null, null, onClick = {
                        script("i didn't said to click !!")
                    })
            )

        }


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = text,
                modifier = modifier
            )
            Button(
                onClick = {
                    script("you will be logged in soooon")
                    startActivity(Intent(context,MainActivity::class.java))

                },
            ) {
                Text(text = "login")
            }
        }

    }
}


// task 1 : showing hello world - already provided by android
//task 2 : showing hello w in center and showing an login button