package com.leo.hellocomposeimport android.content.Contextimport android.content.Intentimport android.os.Bundleimport android.widget.Toastimport androidx.activity.ComponentActivityimport androidx.activity.compose.setContentimport androidx.compose.foundation.Imageimport androidx.compose.foundation.clickableimport androidx.compose.foundation.layout.Arrangementimport androidx.compose.foundation.layout.Columnimport androidx.compose.foundation.layout.fillMaxSizeimport androidx.compose.foundation.layout.paddingimport androidx.compose.foundation.layout.sizeimport androidx.compose.material.icons.Iconsimport androidx.compose.material.icons.filled.Favoriteimport androidx.compose.material3.Buttonimport androidx.compose.material3.Iconimport androidx.compose.material3.MaterialThemeimport androidx.compose.material3.Surfaceimport androidx.compose.material3.Textimport androidx.compose.material3.TextFieldimport androidx.compose.runtime.Composableimport androidx.compose.runtime.getValueimport androidx.compose.runtime.mutableStateOfimport androidx.compose.runtime.saveable.rememberSaveableimport androidx.compose.runtime.setValueimport androidx.compose.ui.Alignmentimport androidx.compose.ui.Modifierimport androidx.compose.ui.graphics.vector.ImageVectorimport androidx.compose.ui.res.vectorResourceimport androidx.compose.ui.unit.dpimport androidx.compose.ui.unit.spimport com.leo.hellocompose.ui.theme.HelloComposeThemeclass MainActivity : ComponentActivity() {    override fun onCreate(savedInstanceState: Bundle?) {        super.onCreate(savedInstanceState)        setContent {            HelloComposeTheme {                // A surface container using the 'background' color from the theme                Surface(                    modifier = Modifier.fillMaxSize(),                    color = MaterialTheme.colorScheme.background                ) {                    Greeting("Android does not sucks or may be ", this)                }            }        }    }}@Composablefun Greeting(name: String, context: Context, modifier: Modifier = Modifier) { /*   Column(horizontalAlignment = Alignment.CenterHorizontally) {        Text(            text = "Hello  $name!",            fontSize = 30.sp,            modifier = modifier        )    }*/    var username by rememberSaveable { mutableStateOf("") }    var password by rememberSaveable { mutableStateOf("") }    Column(        horizontalAlignment = Alignment.CenterHorizontally,        verticalArrangement = Arrangement.Center    ) {        Image(            imageVector = ImageVector.vectorResource(id = R.drawable.icon_account_circle_24),            contentDescription = "image",            modifier = modifier.size(50.dp)        )        // displaying an simple text//        also displaying an simple text        Text(            text = "Jetpack compose login"            ,modifier = modifier.padding(top = 20.dp)        )//         this is an editable text ie edittext in xml        TextField(            value = password,            onValueChange = { password = it }, // what to do when value is changed            label = { Text("password") },  // we can label text above the textfield            maxLines = 1,//        isError = true, set for displaying error (red)           // placeholder = { Text("it's an hint") },   // place holder are used to give hints to textField when it is empty            /*leadingIcon = {                Icon(                    Icons.Filled.Favorite,                    contentDescription = "Localized description"                )            },*/            // trailingIcon = { Icon(Icons.Filled.Info,            //   contentDescription = "Localized description",Modifier.clickable(enabled = true, onClickLabel = "enter password", Role.Button, onClick = { makeToast("enter pass",context) }))}, // we can apply tint in this trailing and leading icons//         readOnly = true,  it is used to set text only in read mode.//         enabled = false,  will be in accessible to user            //  shape = ,            modifier = modifier.padding(top = 20.dp)        )        TextField(            value = username,            onValueChange = { username = it }, // what to do when value is changed            label = { Text("username") },  // we can label text above the textfield            maxLines = 1,//        isError = true, set for displaying error (red)       //     placeholder = { Text("it's an hint") },   // place holder are used to give hints to textField when it is empty           /* leadingIcon = {                Icon(                    Icons.Filled.Favorite,                    contentDescription = "Localized description"                )            },*/            // trailingIcon = { Icon(Icons.Filled.Info,            //   contentDescription = "Localized description",Modifier.clickable(enabled = true, onClickLabel = "enter password", Role.Button, onClick = { makeToast("enter pass",context) }))}, // we can apply tint in this trailing and leading icons//         readOnly = true,  it is used to set text only in read mode.//         enabled = false,  will be in accessible to user            //  shape = ,            modifier = modifier.padding(top = 20.dp)        )        Button(            onClick = {                      makeToast("Your username : $username", context)                makeToast("Your Password : $password",context)            }, modifier = modifier.padding(top = 10.dp)        ) {            Text(text = "Let's go")        }    }}fun makeToast(message: String, context: Context) {    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()}