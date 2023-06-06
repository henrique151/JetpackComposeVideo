package com.plcoding.navigatebackwithresult

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.plcoding.navigatebackwithresult.ui.theme.NavigateBackWithResultTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigateBackWithResultTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "screen1"
                ) {
                    composable("screen1") { entry ->
                        val text = entry.savedStateHandle.get<String>("my_text")
                        val nome = text?.split(" ")?.getOrNull(0)
                        val telefone = text?.split(" ")?.getOrNull(1)
                        val email = text?.split(" ")?.getOrNull(2)
                        val password = text?.split(" ")?.getOrNull(3)
                        val cpf = text?.split(" ")?.getOrNull(4)
                        val rg = text?.split(" ")?.getOrNull(5)
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .fillMaxHeight()
                                .padding(0.dp, 250.dp, 0.dp, 0.dp),

                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment  =  Alignment.CenterHorizontally,
                        ) {

                            Text(
                                text = "Bem Vindo á Tela de Cadastro",textAlign = TextAlign.Center,
                                modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 20.dp),
                                style = TextStyle(
                                    fontSize = 24.sp,
                                    shadow = Shadow(
                                        color = Color.Black,
                                        blurRadius = 2f,
                                    )
                                )
                            )

                            Image(
                                painter = painterResource(R.drawable.cadastro),
                                contentDescription = "Circle Image",
                                contentScale = ContentScale.Crop,

                                modifier = Modifier
                                    .size(180.dp)
                                    .clip(CircleShape) // clip to the circle shape
                                    .border(1.dp, Color.Transparent, CircleShape)

                            )
                            
                            Button(onClick = {
                                navController.navigate("screen2")
                                {
                                    popUpTo("login") {
                                        inclusive = true
                                    }

                                }
                            }) {
                                Text(text = "Se Cadastre!")
                            }


                            text?.let {
                                Text(text = "Obrigado por cadastre. Confira os dados logo em baixo.", textAlign = TextAlign.Center,
                                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 12.dp),
                                    style = TextStyle(
                                        fontSize = 17.sp,
                                        shadow = Shadow(
                                            color = Color.Gray,
                                            blurRadius = 1f,
                                        )
                                    )
                                )
                            }

                            nome?.let {
                                Text(text = "Seu nome é $nome", textAlign = TextAlign.Center,
                                    style = TextStyle(
                                        fontSize = 15.sp,
                                        shadow = Shadow(
                                            color = Color.Gray,
                                            blurRadius = 1f,
                                        )
                                    )
                                )
                            }

                            password?.let {
                                Text(text = "Sua senha é $password", textAlign = TextAlign.Center,
                                    style = TextStyle(
                                        fontSize = 15.sp,
                                        shadow = Shadow(
                                            color = Color.Gray,
                                            blurRadius = 1f,
                                        )
                                    )
                                )
                            }

                            email?.let {
                                Text(text = "Seu email é $email", textAlign = TextAlign.Center,
                                    style = TextStyle(
                                        fontSize = 15.sp,
                                        shadow = Shadow(
                                            color = Color.Gray,
                                            blurRadius = 1f,
                                        )
                                    )
                                )
                            }

                            telefone?.let {
                                Text(text = "Seu telefone é $telefone", textAlign = TextAlign.Center,
                                    style = TextStyle(
                                        fontSize = 15.sp,
                                        shadow = Shadow(
                                            color = Color.Gray,
                                            blurRadius = 1f,
                                        )
                                    )
                                )
                            }


                            cpf?.let {
                                Text(text = "Seu cpf é $cpf", textAlign = TextAlign.Center,
                                    style = TextStyle(
                                        fontSize = 15.sp,
                                        shadow = Shadow(
                                            color = Color.Gray,
                                            blurRadius = 1f,
                                        )
                                    )
                                )
                            }

                            rg?.let {
                                Text(text = "Seu rg é $rg", textAlign = TextAlign.Center,
                                    style = TextStyle(
                                        fontSize = 15.sp,
                                        shadow = Shadow(
                                            color = Color.Gray,
                                            blurRadius = 1f,
                                        )
                                    )
                                )
                            }

                        }
                    }
                    composable("screen2") {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .fillMaxHeight()
                                .padding(0.dp, 130.dp, 0.dp, 0.dp),
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment  =  Alignment.CenterHorizontally
                        ) {
                            var text by remember {
                                mutableStateOf("")
                            }

                            var password by remember {
                                mutableStateOf("")
                            }

                            var nome by remember {
                                mutableStateOf("")
                            }
                            var email by remember {
                                mutableStateOf("")
                            }

                            var telefone by remember {
                                mutableStateOf("")
                            }

                            var rg by remember {
                                mutableStateOf("")
                            }

                            var cpf by remember {
                                mutableStateOf("")
                            }


                            Text(
                                text = "Seja-Bem vindo ao Sistema de Messagem!",textAlign = TextAlign.Center,
                                modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 20.dp),
                                style = TextStyle(
                                    fontSize = 24.sp,
                                    shadow = Shadow(
                                        color = Color.Black,
                                        blurRadius = 2f,
                                    )
                                )
                            )

                            Image(
                                painter = painterResource(R.drawable._4889859),
                                contentDescription = "Circle Image",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(128.dp)
                                    .clip(CircleShape) // clip to the circle shape
                                    .border(2.dp, Color.White, CircleShape)
                            )
                            OutlinedTextField(
                                value = nome,
                                label = { Text(text = "Entre com seu nome: ") },
                                onValueChange = {
                                    nome = it
                                }
                            )

                            OutlinedTextField(
                                value = email,
                                label = { Text(text = "Entre com seu email: ") },
                                onValueChange = {
                                    email = it
                                }
                            )

                            OutlinedTextField(
                                value = telefone,
                                label = { Text(text = "Entre com seu telefone: ") },
                                onValueChange = {
                                    telefone = it
                                }
                            )

                            OutlinedTextField(
                                value = rg,
                                label = { Text(text = "Entre com seu RG: ") },
                                onValueChange = {
                                    rg = it
                                }
                            )

                            OutlinedTextField(
                                value = cpf,
                                label = { Text(text = "Entre com seu CPF: ") },
                                onValueChange = {
                                    cpf = it
                                }
                            )

                            OutlinedTextField(
                                value = password,
                                onValueChange = { password = it },
                                label = { Text("Enter com sua senha: ") },
                                visualTransformation = PasswordVisualTransformation(),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                                modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 20.dp),
                            )

                            Button(onClick = {
                                navController.previousBackStackEntry
                                    ?.savedStateHandle
                                    ?.set("my_text", "$nome $telefone $email $password $rg $cpf")

                                navController.popBackStack() },
                                elevation = ButtonDefaults.elevatedButtonElevation(
                                    defaultElevation = 10.dp,
                                    pressedElevation = 15.dp,
                                    disabledElevation = 0.dp,
                                )
                            ) {
                                Text(text = "Clique para confirma")
                            }

                        }
                    }
                }
            }
        }
    }
}


