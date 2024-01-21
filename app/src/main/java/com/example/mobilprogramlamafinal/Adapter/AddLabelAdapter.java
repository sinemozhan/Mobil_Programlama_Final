package com.example.mobilprogramlamafinal.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilprogramlamafinal.Modals.AddLabelModals;
import com.example.mobilprogramlamafinal.R;

import java.util.ArrayList;

public class AddLabelAdapter extends RecyclerView.Adapter <AddLabelAdapter.ViewHolder> {

     private ArrayList<AddLabelModals> add_label_item;
     private Context context;

    public AddLabelAdapter(ArrayList<AddLabelModals> fragment_add_label, Context context) {
        this.add_label_item = fragment_add_label;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_add_label,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return add_label_item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button btnAddLabel;
        EditText label, description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           btnAddLabel=itemView.findViewById(R.id.btnAddLabel);
           label=itemView.findViewById(R.id.Label);
           description=itemView.findViewById(R.id.Description);
        }
    }
}
