package com.leo.hellocompose

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leo.hellocompose.ui.theme.HelloComposeTheme
import kotlin.math.roundToInt
import kotlin.math.roundToLong

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
                    // Greeting2("hello world", context = this)
                    // ListView1()
                    //Quadrant()
                    //BusinessCard()
                    Bmi(modifier = Modifier)
                }
            }
        }
    }


    fun script(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    @Composable
    fun Bmi(modifier: Modifier){
        var mass by rememberSaveable { mutableStateOf("") }
        var a by rememberSaveable {
            mutableStateOf(false)
        }
        var b by rememberSaveable {
            mutableStateOf(false)
        }
        var height by rememberSaveable { mutableStateOf("") }


         Column(horizontalAlignment = Alignment.CenterHorizontally , modifier = modifier.padding(top = 20.dp)) {
             
             OutlinedTextField(
                 value = mass, 
                 onValueChange = {mass = it
                     if (!mass.equals("") && !height.equals("")) b = true else b= false},
                 label = { Text(text = "weight")},
                 shape = RoundedCornerShape(10.dp),
                 //trailingIcon = { Text(text = "kg")}
                 suffix = { Text(text = "kg")},
                 singleLine = true,
                 keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                 modifier = modifier.padding(top = 20.dp)
             )
             OutlinedTextField(
                 value = height,
                 onValueChange = {height = it
                     if (!mass.equals("") && !height.equals("")) b = true else b= false},
                 label = { Text(text = "height")},
                 shape = RoundedCornerShape(10.dp),
                 //trailingIcon = { Text(text = "kg")}
                 suffix = { Text(text = "cm")},
                 singleLine = true,
                 keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                 modifier = modifier.padding(top = 20.dp)

             )


             Button(enabled = b,
                  modifier = modifier.padding(top = 20.dp)
                 ,
                 onClick = {
                 /*TODO*/
                     a= true



                 }) {

                 Text(text = "Calculate")

             }


             if (a && !mass.equals("") && !height.equals("")){
                 val result : Float = (mass.toDouble() / (height.toDouble()/100.0 * height.toDouble()/100.0)).toFloat()
                 //OutlinedTextField(value = "$result", onValueChange = {}, enabled = false )
                 Text(text = "Your BMI is : ${result}", style = TextStyle(),modifier = modifier.padding(top = 20.dp).border(1.dp,
                     Color.Blue, RoundedCornerShape(50)
                 ).padding(10.dp))
             }

         }
    }


    @Composable
    fun Greeting2(text: String, modifier: Modifier = Modifier, context: Context) {

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


                },
            ) {
                Text(text = "login")
            }

        }

    }

    @Composable
    fun Quadrant(modifier: Modifier = Modifier) {
        Row(modifier = modifier) {
            Column( modifier = modifier.weight(0.5f)) {
                Column(modifier = modifier
                    .weight(0.5f)
                    .background(Color(0xFFEADDFF)), verticalArrangement = Arrangement.Center){
                    Text(textAlign = TextAlign.Justify,
                        text = "Text composable",
                        modifier = modifier
                            .padding(16.dp)
                            .align(Alignment.CenterHorizontally),
                        fontWeight = FontWeight.Bold

                    )
                    Text(
                        text = "Displays text and follows the recommended Material Design guidelines.",
                        modifier.padding(16.dp)

                    )
                }
                Column(
                    modifier = modifier
                        .weight(0.5f)
                        .background(Color(0xFFD0BCFF)),
                    verticalArrangement = Arrangement.Center)
                {
                    Text(text = "Row composable",
                        modifier = modifier
                            .padding(16.dp)
                            .align(Alignment.CenterHorizontally),
                        fontWeight = FontWeight.Bold)
                    Text(text = "A layout composable that places its children in a horizontal sequence.",
                        modifier.padding(16.dp))
                }
            }
            Column(modifier = modifier.weight(0.5f)) {

                Column(
                    modifier = modifier
                        .weight(0.5f)
                        .background(Color(0xFFD0BCFF)),
                    verticalArrangement = Arrangement.Center)
                {
                    Text(text = "Image composable",
                        modifier = modifier
                            .padding(16.dp)
                            .align(Alignment.CenterHorizontally),
                        fontWeight = FontWeight.Bold)
                    Text(text = "Creates a composable that lays out and draws a given Painter class object.",
                        modifier.padding(16.dp))
                }
                Column(modifier = modifier
                    .weight(0.5f)
                    .background(Color(0xFFEADDFF)), verticalArrangement = Arrangement.Center){

                Text(text = "Column composable",
                        modifier = modifier
                            .padding(16.dp)
                            .align(Alignment.CenterHorizontally),
                        fontWeight = FontWeight.Bold)
                    Text(text = "A layout composable that places its children in a vertical sequence.",
                        modifier.padding(16.dp))
                }
            }
        }
    }

    @Composable
    fun ListView1(modifier: Modifier = Modifier) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            var a = 0
            val list = arrayListOf(a)
            do {
                a += 1
                list.add(a)

            } while (a < 100)

            LazyColumn(
                userScrollEnabled = true,
                modifier = modifier
                    .fillMaxHeight()
                    .padding(start = 50.dp, end = 50.dp, top = 10.dp)
                /*.indicatorLine(
                    true, false, interactionSource = DragInteraction.Start,
                    Color.Black, 10.dp, 10.dp
                )*/,
                verticalArrangement = Arrangement.spacedBy(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(items = list, itemContent = {
                    Log.d("COMPOSE", "This get rendered $it")

                    Text(
                        text = it.toString(),
                        style = TextStyle(fontSize = 80.sp),
                        modifier = modifier

                            .clickable(enabled = true, "wat", null, onClick = {
                                makeToast(it.toString(), this@lerning)
                            })
                    )
                    HorizontalDivider(color = Color.LightGray, thickness = 1.dp)

                })
            }
        }
    }

    @Composable
    fun BusinessCard(){
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            Image(painter = painterResource(id = R.drawable.img) ,
                contentDescription = "android image",
                Modifier
                    .size(100.dp)
                    .background(
                        Color.Gray, shape = CircleShape
                    )
                    .padding(10.dp)
            )
            Text(text = "Rudra Pratap", fontSize = 50.sp, color = Color.DarkGray)
            Text(text = "Senior android developer", fontSize = 20.sp, modifier = Modifier.padding(top = 10.dp))


        }


        Column (horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Bottom){
            Column(horizontalAlignment = Alignment.Start) {
                Row ( verticalAlignment = Alignment.CenterVertically){
                    Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "contact me", modifier = Modifier
                        .size(50.dp)
                        .padding(bottom = 5.dp))
                    Text(text = "+91 95757-56428")
                }
                Row ( verticalAlignment = Alignment.CenterVertically){
                    Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "contact me", modifier = Modifier
                        .size(50.dp)
                        .padding(bottom = 5.dp))
                    Text(text = "g.dev/le0Rudra")
                }
                Row ( verticalAlignment = Alignment.CenterVertically){
                    Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "contact me", modifier = Modifier
                        .size(50.dp)
                        .padding(bottom = 5.dp))
                    Text(text = "rudrapratapsinhchauhan1@gmail.com")
                }

            }
        }


    }
}


// task 1 : showing hello world - already provided by android
//task 2 : showing hello w in center and showing an login button
//task 3 : showing two textfeilds with an button and on pressing button get data of text feilds.
//task 4 :