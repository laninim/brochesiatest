package com.laninim.brochesiatest.presentation.second.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.laninim.brochesiatest.R;
import com.laninim.brochesiatest.data.dto.Drink;
import com.laninim.brochesiatest.model.repositories.DrinkModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DrinkViewAdapter extends RecyclerView.Adapter<DrinkViewAdapter.DrinkViewHolder> {

    private List<DrinkModel> mydrinkList;

    public DrinkViewAdapter(List<DrinkModel> mydrinkList){
        this.mydrinkList = mydrinkList;
    }

    @NonNull
    @Override
    public DrinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_layout_item, parent, false);
        return new DrinkViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DrinkViewHolder holder, int position) {
        ImageView drinkImage = holder.itemView.findViewById(R.id.drinkimageview);
        TextView drinkName = holder.itemView.findViewById(R.id.drink_name);

        DrinkModel myDrink = mydrinkList.get(position);
        Picasso.get().load(myDrink.getImageUrl()).into(drinkImage);
        drinkName.setText(myDrink.getDrinkName());
    }



    @Override
    public int getItemCount() {
        return mydrinkList.size();
    }

    public class DrinkViewHolder extends RecyclerView.ViewHolder {

        public DrinkViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
