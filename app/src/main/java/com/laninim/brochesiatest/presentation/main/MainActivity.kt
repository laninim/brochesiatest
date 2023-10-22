package com.laninim.brochesiatest.presentation.main

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.laninim.brochesiatest.presentation.main.components.DrinkCard
import com.laninim.brochesiatest.presentation.second.JavaActivity
import com.laninim.brochesiatest.ui.theme.AzureBrochesia
import com.laninim.brochesiatest.ui.theme.BrochesiatestTheme
import com.laninim.brochesiatest.ui.theme.GreenBrochesia
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            BrochesiatestTheme {
                val viewModel : MainViewModel = viewModel()
                val screenState by viewModel.mainScreenState.collectAsState()
                
                Scaffold {
                    if(!screenState.dataIsLoaded){
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            CircularProgressIndicator(
                                color = GreenBrochesia
                            )
                        }
                    }
                    else if(screenState.drinkList.isEmpty() && screenState.dataIsLoaded){
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(text = "No drinks results for this category")
                        }
                    }else{
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Row (
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                Text(
                                    text = "Brochesia",
                                    style = MaterialTheme.typography.headlineLarge.copy(
                                        color = AzureBrochesia,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                )
                                Text(text = "Drinks",
                                    style = MaterialTheme.typography.headlineSmall.copy(
                                        color = GreenBrochesia,
                                        fontWeight = FontWeight.SemiBold
                                    ))
                            }
                            Button(
                                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                                onClick = {
                                    val changeActivityIntent = Intent(applicationContext,JavaActivity::class.java)
                                    startActivity(changeActivityIntent)
                                }
                            ) {
                                Text(text = "Show Xml Version")
                            }
                            LazyVerticalGrid(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(
                                        start = 8.dp,
                                        top = 8.dp,
                                        bottom = it.calculateBottomPadding() + 35.dp
                                    ),
                                columns = GridCells.Fixed(2),
                                contentPadding = PaddingValues(start = 4.dp, end = 4.dp, bottom = 12.dp, top = 8.dp)
                            ){
                                items(screenState.drinkList){
                                    DrinkCard(
                                        drinkModel = it
                                    )
                                }
                            }


                        }
                    }
                }
            }
        }
    }
}

