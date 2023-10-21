package com.laninim.brochesiatest.presentation.main.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.laninim.brochesiatest.model.repositories.DrinkModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrinkCard(
    drinkModel: DrinkModel =  DrinkModel(
        idDrink = "15346",
        category = "Cocktail",
        drinkName = "Belmont",
        imageUrl = "https://www.thecocktaildb.com/images/media/drink/yqvvqs1475667388.jpg"
    )
){
   Card(
       modifier = Modifier.fillMaxWidth().padding(8.dp)
   ) {
       Box{
           AsyncImage(model = drinkModel.imageUrl, contentDescription = "drink")
       }
       Text(text = drinkModel.drinkName, modifier = Modifier.padding(6.dp), style = MaterialTheme.typography.bodyLarge.copy(
           fontWeight = FontWeight.SemiBold,
           fontStyle = FontStyle.Normal,

       ), overflow = TextOverflow.Clip,
           maxLines = 1)
   }
}

@Preview
@Composable
fun DrinkPreview(){
    DrinkCard(
    )
}