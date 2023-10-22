package com.laninim.brochesiatest.presentation.second;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import com.laninim.brochesiatest.R;
import com.laninim.brochesiatest.data.dto.Drink;
import com.laninim.brochesiatest.databinding.ActivityJavaBinding;
import com.laninim.brochesiatest.model.repositories.DrinkModel;
import com.laninim.brochesiatest.presentation.second.adapter.DrinkViewAdapter;

import java.util.ArrayList;

public class JavaActivity extends AppCompatActivity {

    private ActivityJavaBinding activityJavaBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityJavaBinding = ActivityJavaBinding.inflate(getLayoutInflater());
        View view = activityJavaBinding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        ArrayList<DrinkModel> drinkList = (ArrayList<DrinkModel>) intent.getSerializableExtra("drinkList");
        RecyclerView myRecyclerView = activityJavaBinding.showdrinkgridview;
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);

        if(drinkList != null){
            Log.d("Dati passati con intent: ", "Drinklist: " + drinkList);
            activityJavaBinding.showdrinkgridview.setAdapter(new DrinkViewAdapter(drinkList));
            myRecyclerView.setLayoutManager(layoutManager);
        }else{
            Toast.makeText(getApplicationContext(), "Can't load data", Toast.LENGTH_SHORT).show();
        }
    }


}