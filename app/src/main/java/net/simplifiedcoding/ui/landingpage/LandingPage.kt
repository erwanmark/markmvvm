package net.simplifiedcoding.ui.landingpage

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import net.simplifiedcoding.ui.auth.AuthViewModel
@Composable
fun LandingScreen(viewModel: AuthViewModel?, navController: NavController) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color.Transparent)
            .fillMaxSize()

    ) {
//start scope
        Text(text = "Welcome to MedicNear", color = Color.Green, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(12.dp))

        var viewmedical = LocalContext.current

        Button(onClick =
        { viewmedical.startActivity(Intent(viewmedical, viewmedical::class.java)) }
        )
        {
            Text(text = "I am a Patient")
        }

        var AddScreen = LocalContext.current

        Button(onClick =
        { AddScreen.startActivity(Intent(AddScreen, AddScreen::class.java)) }
        )
        {
            Text(text = "I am a Doctor")
        }

//end scope

    }

}






