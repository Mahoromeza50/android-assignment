package com.example.carinem.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.carinem.R;
import com.example.carinem.model.friend;

import java.util.List;

class searchViewHolder extends RecyclerView.ViewHolder{
    public TextView name,address,phone,email;
    public searchViewHolder(@NonNull View itemView) {
        super(itemView);
        name=(TextView)itemView.findViewById(R.id.name);
        address =(TextView)itemView.findViewById(R.id.address);
        phone=(TextView)itemView.findViewById(R.id.phone);
        email=(TextView)itemView.findViewById(R.id.email);
    }
}





public class searchadapter extends RecyclerView.Adapter <searchViewHolder>{

    private Context context;
    private List<friend>friends;

    public searchadapter(Context context, List<friend> friends) {
        this.context = context;
        this.friends = friends;
    }


    @Override
    public searchViewHolder onCreateViewHolder(ViewGroup parent, int ViewGroup) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View itemView=inflater.inflate(R.layout.layout_item,parent,false);
        return new searchViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(searchViewHolder holder, int position) {
        holder.name.setText(friends.get(position).getName());
        holder.address.setText(friends.get(position).getAddress());
        holder.phone.setText(friends.get(position).getPhone());
        holder.email.setText(friends.get(position).getEmail());


    }

    @Override
    public int getItemCount() {
        return friends.size();
    }
}
