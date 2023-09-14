package net.simplifiedcoding.ui.updatemedical


import androidx.navigation.NavController
import net.simplifiedcoding.ui.auth.AuthViewModel


import android.annotation.SuppressLint
import android.content.Context
import android.text.TextUtils
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
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


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun updatemedicalScreen(viewModel: AuthViewModel?, navController: NavController){

    Surface(
        // on below line we are specifying modifier and color for our app
        modifier = Modifier.fillMaxSize(),
    ) {
        // on the below line we are specifying the theme as the scaffold.
        Scaffold(
            // in scaffold we are specifying the top bar.
            topBar = {
                // inside top bar we are specifying background color.
                SmallTopAppBar(
                    // along with that we are specifying
                    // title for our top bar.
                    title = {
                        // in the top bar we are
                        // specifying tile as a text
                        Text(
                            // on below line we are specifying
                            // text to display in top app bar
                            text = "GFG",
                            // on below line we are specifying
                            // modifier to fill max width
                            modifier = Modifier.fillMaxWidth(),
                            // on below line we are
                            // specifying text alignment
                            textAlign = TextAlign.Center,
                            // on below line we are specifying
                            // color for our text.
                            color = Color.White
                        )
                    })
            }) {
            // on below line we are calling
            // method to display UI
            firebaseUI(LocalContext.current)
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun firebaseUI(context: Context) {

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
                .padding(16.dp)
                .fillMaxWidth(),

            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),

            // on below line we are adding
            // single line to it.
            singleLine = true,
        )

        Spacer(modifier = Modifier.height(10.dp))

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
                .padding(16.dp)
                .fillMaxWidth(),

            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),

            // on below line we are adding
            // single line to it.
            singleLine = true,
        )

        Spacer(modifier = Modifier.height(10.dp))

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
                .padding(16.dp)
                .fillMaxWidth(),

            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),

            // on below line we are adding
            // single line to it.
            singleLine = true,
        )

        Spacer(modifier = Modifier.height(10.dp))

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
                .padding(16.dp)
                .fillMaxWidth(),

            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),

            // on below line we are adding
            // single line to it.
            singleLine = true,
        )
        Spacer(modifier = Modifier.height(10.dp))

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
                .padding(16.dp)
                .fillMaxWidth(),

            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),

            // on below line we are adding
            // single line to it.
            singleLine = true,
        )
        Spacer(modifier = Modifier.height(10.dp))

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
                .padding(16.dp)
                .fillMaxWidth(),

            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),

            // on below line we are adding
            // single line to it.
            singleLine = true,
        )
        // on below line creating button to
        // add data to firebase firestore database.

        // on below line we are validating user input parameters.
        if (TextUtils.isEmpty(doctorsName.value.toString())) {
            Toast.makeText(context, "Please enter your name", Toast.LENGTH_SHORT).show()
        } else if (TextUtils.isEmpty(doctorsLocation.value.toString())) {
            Toast.makeText(context, "Please enter your location", Toast.LENGTH_SHORT)
                .show()
        } else if (TextUtils.isEmpty(doctorsSpecialisation.value.toString())) {
            Toast.makeText(context, "Please enter your specialisation", Toast.LENGTH_SHORT)
                .show()
        } else if (TextUtils.isEmpty(doctorsContacts.value.toString())) {
            Toast.makeText(context, "Please enter your contacts", Toast.LENGTH_SHORT)
                .show()
        } else if (TextUtils.isEmpty(consoltationCharges.value.toString())) {
            Toast.makeText(context, "Please enter your consoltation charges", Toast.LENGTH_SHORT)
                .show()
        }else if (TextUtils.isEmpty(regestrationNumber.value.toString())) {
            Toast.makeText(context, "Please enter regestration Numbers", Toast.LENGTH_SHORT)
                .show()
        } else {
            // Print a debug message before calling updateToFirebase.
            println("Calling updateToFirebase")

            // Call the updateToFirebase function.
            updateToFirebase(
               doctorsName.value,
                doctorsLocation.value,
               doctorsSpecialisation.value,
                doctorsContacts.value,
                consoltationCharges.value,
                regestrationNumber.value
            )
        }
    }
}

fun updateToFirebase(
    doctorsName: String,
    doctorsLocation: String,
    doctorsSpecialisation: String,
    doctorsContacts: String,
    consoltationCharges: String,
    regestrationNumber: String,
) {
    // Print a debug message to check if this function is called.
    println("updateToFirebase Called")

    val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    val dbCourses: CollectionReference = db.collection("Courses") // Remove $courseId here

    // Create a map with updated data.
    val updatedData = mapOf(
        "doctorsName" to doctorsName,
        "doctorsLocation" to doctorsLocation,
        "doctorsSpecialisation" to doctorsSpecialisation,
        "doctorsContacts" to doctorsContacts,
        " consoltationCharges" to  consoltationCharges,
        " regestrationNumber" to  regestrationNumber
    )

    // Print the updatedData for debugging.
    println("Updated Data: $updatedData")

    // Add your logic to update Firestore here
    // Make sure to generate a unique document ID or use an existing one.

    // Example:
    // dbCourses.add(updatedData)
    //   .addOnSuccessListener { /* Handle success */ }
    //   .addOnFailureListener { e -> /* Handle failure */ }
}

// on below line we are
    // adding modifier to our button.


