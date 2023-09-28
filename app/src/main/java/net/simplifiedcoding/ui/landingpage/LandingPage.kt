package net.simplifiedcoding.ui.landingpage

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import net.simplifiedcoding.R
import net.simplifiedcoding.navigation.ROUTE_ADDMEDICAL
import net.simplifiedcoding.navigation.ROUTE_LANDINGPAGE
import net.simplifiedcoding.navigation.ROUTE_LOGIN
import net.simplifiedcoding.navigation.ROUTE_SIGNUP
import net.simplifiedcoding.navigation.ROUTE_VIEWMEDICAL
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

        Text(
            modifier = Modifier

                .clickable {
                    navController.navigate(ROUTE_VIEWMEDICAL) {
                        popUpTo(ROUTE_LANDINGPAGE) { inclusive = true }
                    }
                },

            text = "I am a Patient",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurface
        )
        
        Text(
            modifier = Modifier

                .clickable {
                    navController.navigate(ROUTE_ADDMEDICAL) {
                        popUpTo(ROUTE_LANDINGPAGE) { inclusive = true }
                    }
                },

            text = "I am a Doctor",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurface
        )

//end scope

    }

}






