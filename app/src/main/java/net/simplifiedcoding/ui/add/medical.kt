package net.simplifiedcoding.ui.add

import androidx.navigation.NavController
import net.simplifiedcoding.ui.auth.AuthViewModel


import android.annotation.SuppressLint
import android.content.Context
import android.text.TextUtils
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import net.simplifiedcoding.Medical
import net.simplifiedcoding.data.Resource
import net.simplifiedcoding.navigation.ROUTE_ADDMEDICAL
import net.simplifiedcoding.navigation.ROUTE_HOME
import net.simplifiedcoding.navigation.ROUTE_LANDINGPAGE
import net.simplifiedcoding.navigation.ROUTE_SIGNUP


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreen(viewModel: AuthViewModel?, navController: NavController){

    Surface(

        // on below line we are specifying modifier and color for our app
        modifier = Modifier.fillMaxSize(),
    ) {
        // on the below line we are specifying the theme as the scaffold.
        Scaffold(
            // in scaffold we are specifying the top bar.
            ) {
            // on below line we are calling
            // method to display UI
            firebaseUI(LocalContext.current,navController)
        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun firebaseUI(context: Context, navController: NavController) {

    // on below line creating variable for course name,
    // course duration and course description.
    val doctorsName = remember {
        mutableStateOf("")
    }

    val doctorsLocation = remember {
        mutableStateOf("")
    }

    val doctorsSpecialisation = remember {
        mutableStateOf("")
    }
    val doctorsContacts = remember {
        mutableStateOf("")
    }
    val consoltationCharges = remember {
        mutableStateOf("")
    }
    val regestrationNumber = remember {
        mutableStateOf("")
    }

    // on below line creating a column
    // to display our retrieved image view.
    Column(
        // adding modifier for our column
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color.White),
        // on below line adding vertical and
        // horizontal alignment for column.
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {


        TextField(
            // on below line we are specifying
            // value for our course name text field.
            value = doctorsName.value,

            // on below line we are adding on
            // value change for text field.
            onValueChange = {  doctorsName.value = it },

            // on below line we are adding place holder
            // as text as "Enter your name"
            placeholder = { Text(text = "Enter your name") },

            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),

            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 20.sp),

            // on below line we are adding
            // single line to it.
            singleLine = true,
        )

        Spacer(modifier = Modifier.height(2.dp))

        TextField(
            // on below line we are specifying
            // value for our course duration text field.
            value = doctorsLocation.value,

            // on below line we are adding on
            // value change for text field.
            onValueChange = { doctorsLocation.value = it },

            // on below line we are adding place holder
            // as text as "Enter your location"
            placeholder = { Text(text = "Enter your location") },

            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),

            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 20.sp),

            // on below line we are adding
            // single line to it.
            singleLine = true,
        )

        Spacer(modifier = Modifier.height(2.dp))

        TextField(
            // on below line we are specifying
            // value for our course description text field.
            value = doctorsSpecialisation.value,

            // on below line we are adding on
            // value change for text field.
            onValueChange = { doctorsSpecialisation.value = it },

            // on below line we are adding place holder
            // as text as "Enter your proffession"
            placeholder = { Text(text = "Enter your specialisation") },

            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),

            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 20.sp),

            // on below line we are adding
            // single line to it.
            singleLine = true,
        )

        Spacer(modifier = Modifier.height(2.dp))

        TextField(
            // on below line we are specifying
            // value for our course description text field.
            value = doctorsContacts.value,

            // on below line we are adding on
            // value change for text field.
            onValueChange = { doctorsContacts.value = it },

            // on below line we are adding place holder
            // as text as "Enter your Contacts"
            placeholder = { Text(text = "Enter your contacts") },

            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),

            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 20.sp),

            // on below line we are adding
            // single line to it.
            singleLine = true,
        )
        Spacer(modifier = Modifier.height(2.dp))

        TextField(
            // on below line we are specifying
            // value for our course description text field.
            value = consoltationCharges.value,

            // on below line we are adding on
            // value change for text field.
            onValueChange = { consoltationCharges.value = it },

            // on below line we are adding place holder
            // as text as "Enter your Contacts"
            placeholder = { Text(text = "Enter your consoltation charges") },

            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),

            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 20.sp),

            // on below line we are adding
            // single line to it.
            singleLine = true,
        )
        Spacer(modifier = Modifier.height(2.dp))

        TextField(
            // on below line we are specifying
            // value for our course description text field.
            value = regestrationNumber.value,

            // on below line we are adding on
            // value change for text field.
            onValueChange = { regestrationNumber.value = it },

            // on below line we are adding place holder
            // as text as "Enter your Contacts"
            placeholder = { Text(text = "Enter your regestration Numbers") },

            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),

            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 20.sp),

            // on below line we are adding
            // single line to it.
            singleLine = true,
        )
        // on below line creating button to
        // add data to firebase firestore database.
        Button(
            onClick = {
                // on below line we are validating user input parameters.
                if (TextUtils.isEmpty(doctorsName.value.toString())) {
                    Toast.makeText(context, "Please enter  doctors Name", Toast.LENGTH_SHORT).show()
                } else if (TextUtils.isEmpty(doctorsLocation.value.toString())) {
                    Toast.makeText(context, "Please enter doctors Location", Toast.LENGTH_SHORT)
                        .show()
                } else if (TextUtils.isEmpty(doctorsSpecialisation.value.toString())) {
                    Toast.makeText(context, "Please enter doctors Specialisation", Toast.LENGTH_SHORT)
                        .show()
                } else if (TextUtils.isEmpty(doctorsContacts.value.toString())) {
                    Toast.makeText(context, "Please enter the doctors Contacts", Toast.LENGTH_SHORT)
                        .show()
                } else if (TextUtils.isEmpty(consoltationCharges.value.toString())) {
                    Toast.makeText(context, "Please enter consoltation Charges", Toast.LENGTH_SHORT)
                        .show()
                }else if (TextUtils.isEmpty(regestrationNumber.value.toString())) {
                    Toast.makeText(context, "Please enter regestration Numbers", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    // on below line adding data to
                    // firebase firestore database.
                    addDataToFirebase(
                        doctorsName.value,
                        doctorsLocation.value,
                        doctorsSpecialisation.value,
                        doctorsContacts.value,
                        consoltationCharges.value,
                        regestrationNumber.value,context
                    )
                }
            },
            // on below line we are
            // adding modifier to our button.
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            // on below line we are adding text for our button
            Text(text = "Add Data", modifier = Modifier.padding(10.dp))
        }
        Spacer(modifier = Modifier.height(2.dp))
        //another button
        
        Button(onClick = {
            navController.navigate(ROUTE_LANDINGPAGE)
        },
           modifier = Modifier
               .fillMaxWidth()
               .padding(16.dp)

        ){
           Text(text = "Back") 
        }
    }
}

fun addDataToFirebase(
    doctorsName: String,
    doctorsLocation: String,
    doctorsSpecialisation: String,
    doctorsContacts: String,
    consoltationCharges: String,
    regestrationNumber: String,
    context: Context
) {
    // on below line creating an instance of firebase firestore.
    val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    //creating a collection reference for our Firebase Firestore database.
    val dbCourses: CollectionReference = db.collection("Courses")
    //adding our data to our courses object class.
    val courses = Medical(doctorsName, doctorsLocation, doctorsSpecialisation, doctorsContacts,consoltationCharges,regestrationNumber)

    //below method is use to add data to Firebase Firestore.
    dbCourses.add(courses).addOnSuccessListener {
        // after the data addition is successful
        // we are displaying a success toast message.
        Toast.makeText(
            context,
            "Your account has been added to Firebase Firestore",
            Toast.LENGTH_SHORT
        ).show()

    }.addOnFailureListener { e ->
        // this method is called when the data addition process is failed.
        // displaying a toast message when data addition is failed.
        Toast.makeText(context, "Fail to add account \n$e", Toast.LENGTH_SHORT).show()
    }

}






