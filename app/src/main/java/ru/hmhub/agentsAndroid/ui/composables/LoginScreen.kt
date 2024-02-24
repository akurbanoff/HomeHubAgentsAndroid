package ru.hmhub.agentsAndroid.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowRightAlt
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.material.icons.filled.ArrowRightAlt
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.LockOpen
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.times
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.hmhub.agentsAndroid.ui.navigation.NavigationRoutes
import ru.hmhub.agentsAndroid.R

@Preview(showBackground = true)
@Composable
fun LoginScreen(navigator: NavHostController = rememberNavController()){
    var userName by remember{ mutableStateOf("") }
    var password by remember{ mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.fillMaxHeight(0.1f))
        Image(
            painter = painterResource(R.drawable.ic_homehub_main),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.fillMaxHeight(0.25f))
        Box(modifier = Modifier.fillMaxWidth()) {
            Column {
                TextField(
                    value = userName,
                    onValueChange = {
                        userName = it
                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Gray,
                        unfocusedContainerColor = Color.Gray,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent
                    ),
                    leadingIcon = {
                                  Icon(
                                      imageVector = Icons.Default.Person,
                                      contentDescription = null,
                                      modifier = Modifier.size(44.dp).padding(start = 8.dp)
                                  )
                    },
                    shape = RoundedCornerShape(topEnd = 1000.dp, topStart = 0.dp, bottomStart = 0.dp),
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .height(70.dp)
                )
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Divider(color = Color.Gray, thickness = 2.dp, modifier = Modifier.fillMaxWidth(0.9f))
                    Divider(color = Color.Black, thickness = 2.dp, modifier = Modifier.fillMaxWidth(0.7f))
                }
                TextField(
                    value = "*".repeat(password.length),
                    onValueChange = {
                        password = it
                    },
                    leadingIcon = {
                                  Icon(
                                      imageVector = Icons.Default.Lock,
                                      contentDescription = null,
                                      modifier = Modifier.size(44.dp).padding(start = 8.dp)
                                  )
                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Gray,
                        unfocusedContainerColor = Color.Gray,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(bottomEnd = 1000.dp, topStart = 0.dp, bottomStart = 0.dp),
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .height(70.dp)
                )
            }
            Button(
                onClick = {
                    navigator.popBackStack()
                    navigator.navigate(NavigationRoutes.NewsScreen.route)
                          },
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .size(80.dp),
                shape = CircleShape,
                contentPadding = PaddingValues(8.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowRightAlt,
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
            }
        }
        Text(
            text = "forgot password?",
            modifier = Modifier
                .align(Alignment.End)
                .padding(top = 16.dp)
        )
        Spacer(modifier = Modifier.fillMaxHeight(0.25f))
        Button(
            onClick = { navigator.navigate(NavigationRoutes.RegistrationScreen.route) },
            shape = RoundedCornerShape(topEnd = 1000.dp, bottomEnd = 1000.dp, topStart = 0.dp, bottomStart = 0.dp),
            modifier = Modifier.size(height = 80.dp, width = 200.dp)
        ) {
            Text(
                text = "REGISTER",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}