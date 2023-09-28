package net.simplifiedcoding.ui.medical

import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import net.simplifiedcoding.Medical


import android.annotation.SuppressLint
import android.widget.Toast
import android.content.Context

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.firestore.FirebaseFirestore
import net.simplifiedcoding.ui.auth.AuthViewModel


@OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnrememberedMutableState", "UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun MedicalScreen( viewModel: AuthViewModel?, navController: NavController){

        Surface(
            // on below line we are specifying modifier and color for our app
            modifier = Modifier.fillMaxSize(),
        ) {
            // on the below line we are specifying
            // the theme as the scaffold.
            Scaffold(
                // in scaffold we are specifying the top bar.
                topBar = {
                    // inside top bar we are specifying
                    // background color.
                    SmallTopAppBar(
                        // along with that we are
                        // specifying title for our top bar.
                        title = {
                            // in the top bar we are specifying
                            // tile as a text
                            Text(
                                // on below line we are specifying
                                // text to display in top app bar
                                text = "GFG",
                                // on below line we are specifying
                                // modifier to fill max width
                                modifier = Modifier.fillMaxWidth(),
                                // on below line we are specifying
                                // text alignment
                                textAlign = TextAlign.Center,
                                // on below line we are specifying
                                // color for our text.
                                color = Color.White
                            )
                        })
                }) {

                // on below line creating variable for list of data.
                var medicalList = mutableStateListOf<Medical?>()
                // on below line creating variable for freebase database
                // and database reference.
                var db: FirebaseFirestore = FirebaseFirestore.getInstance()

                // on below line getting data from our database
                db.collection("Medical").get()
                    .addOnSuccessListener { queryDocumentSnapshots ->
                        // after getting the data we are calling
                        // on success method
                        // and inside this method we are checking
                        // if the received query snapshot is empty or not.
                        if (!queryDocumentSnapshots.isEmpty) {
                            // if the snapshot is not empty we are
                            // hiding our progress bar and adding
                            // our data in a list.
                            // loadingPB.setVisibility(View.GONE)
                            val list = queryDocumentSnapshots.documents
                            for (d in list) {
                                // after getting this list we are passing that
                                // list to our object class.
                                val c: Medical? = d.toObject(Medical::class.java)
                                // and we will pass this object class inside
                                // our arraylist which we have created for list view.
                                medicalList.add(c)

                            }
                        } else {
                            // if the snapshot is empty we are displaying
                            // a toast message.
//                            Toast.makeText(
//                                context,
//                                "No data found",
//                                Toast.LENGTH_SHORT
//                            ).show()
                        }
                    }
                    // if we don't get any data or any error
                    // we are displaying a toast message
                    // that we donot get any data
                    .addOnFailureListener {
//                        Toast.makeText(
//                            context,
//                            "Fail to get the data.",
//                            Toast.LENGTH_SHORT
//                        ).show()
                    }
                // on below line we are calling method to display UI
                firebaseUI(LocalContext.current, medicalList)
            }
        }
    }



    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun firebaseUI(context: Context, medicalList: SnapshotStateList<Medical?>) {

        // on below line creating a column
        // to display our retrieved list.
        Column(
            // adding modifier for our column
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(Color.Black),
            // on below line adding vertical and
            // horizontal alignment for column.
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // on below line we are
            // calling lazy column
            // for displaying listview.
            LazyColumn {
                // on below line we are setting data
                // for each item of our listview.
                itemsIndexed(medicalList) { index, item ->
                    // on below line we are creating
                    // a card for our list view item.
                    Card(
                        onClick = {
                            // inside on click we are
                            // displaying the toast message.
                            Toast.makeText(
                                context,
                                medicalList[index]?.doctorsName + " selected..",
                                Toast.LENGTH_SHORT
                            ).show()
                        },

                        // on below line we are adding
                        // padding from our all sides.
                        modifier = Modifier.padding(8.dp),

                        // on below line we are adding
                        // elevation for the card.

                    ) {
                        // on below line we are creating
                        // a row for our list view item.
                        Column(
                            // for our row we are adding modifier
                            // to set padding from all sides.
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth()
                        ) {
                            // on below line inside row we are adding spacer
                            Spacer(modifier = Modifier.width(5.dp))
                            // on below line we are displaying course name.
                            medicalList[index]?.doctorsName
                                ?.let {
                                Text(
                                    // inside the text on below line we are
                                    // setting text as the language name
                                    // from our modal class.
                                    text = it,

                                    // on below line we are adding padding
                                    // for our text from all sides.
                                    modifier = Modifier.padding(4.dp),

                                    // on below line we are adding
                                    // color for our text

                                    textAlign = TextAlign.Center,
                                    style = TextStyle(
                                        fontSize = 20.sp, fontWeight = FontWeight.Bold
                                    )
                                )
                            }
                            // adding spacer on below line.
                            Spacer(modifier = Modifier.height(5.dp))
                            // on below line inside row we are adding spacer
                            Spacer(modifier = Modifier.width(5.dp))
                            // on below line we are displaying course name.
                            medicalList[index]?.doctorsLocation?.let {
                                Text(
                                    // inside the text on below line we are
                                    // setting text as the language name
                                    // from our modal class.
                                    text = it,

                                    // on below line we are adding padding
                                    // for our text from all sides.
                                    modifier = Modifier.padding(4.dp),

                                    // on below line we are adding
                                    // color for our text

                                    textAlign = TextAlign.Center,
                                    style = TextStyle(
                                        fontSize = 20.sp, fontWeight = FontWeight.Bold
                                    )
                                )
                            }
                            // adding spacer on below line.
                            Spacer(modifier = Modifier.height(5.dp))

                            // on below line displaying text for course duration
                            medicalList[index]?.doctorsSpecialisation?.let {
                                Text(
                                    // inside the text on below line we are
                                    // setting text as the language name
                                    // from our modal class.
                                    text = it,

                                    // on below line we are adding padding
                                    // for our text from all sides.
                                    modifier = Modifier.padding(4.dp),

                                    // on below line we are
                                    // adding color for our text
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    style = TextStyle(
                                        fontSize = 15.sp
                                    )
                                )
                            }
                            // adding spacer on below line.
                            Spacer(modifier = Modifier.width(5.dp))

                            // on below line displaying text for course description
                            medicalList[index]?.doctorsContacts?.let {
                                Text(
                                    // inside the text on below line we are
                                    // setting text as the language name
                                    // from our modal class.
                                    text = it,

                                    // on below line we are adding padding
                                    // for our text from all sides.
                                    modifier = Modifier.padding(4.dp),

                                    // on below line we are adding color for our text
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    style = TextStyle(fontSize = 15.sp)
                                )
                            }
                            // adding spacer on below line.
                            Spacer(modifier = Modifier.width(5.dp))

                            // on below line displaying text for course description
                            medicalList[index]?.consoltationCharges?.let {
                                Text(
                                    // inside the text on below line we are
                                    // setting text as the language name
                                    // from our modal class.
                                    text = it,

                                    // on below line we are adding padding
                                    // for our text from all sides.
                                    modifier = Modifier.padding(4.dp),

                                    // on below line we are adding color for our text
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    style = TextStyle(fontSize = 15.sp)
                                )
                            }
                            // adding spacer on below line.
                            Spacer(modifier = Modifier.width(5.dp))

                            // on below line displaying text for course description
                            medicalList[index]?.regestrationNumber?.let {
                                Text(
                                    // inside the text on below line we are
                                    // setting text as the language name
                                    // from our modal class.
                                    text = it,

                                    // on below line we are adding padding
                                    // for our text from all sides.
                                    modifier = Modifier.padding(4.dp),

                                    // on below line we are adding color for our text
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    style = TextStyle(fontSize = 15.sp)
                                )
                            }
                        }
                    }
                }

            }
        }
    }

