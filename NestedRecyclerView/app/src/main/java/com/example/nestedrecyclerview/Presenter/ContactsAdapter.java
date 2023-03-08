package com.example.nestedrecyclerview.Presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nestedrecyclerview.Model.ContactModel;
import com.example.nestedrecyclerview.R;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    Context context;
    ArrayList<ContactModel> contactModelArrayList;

    public ContactsAdapter(Context context, ArrayList<ContactModel> contactModelArrayList) {
        this.context = context;
        this.contactModelArrayList = contactModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @SuppressLint("InflateParams")
        View view = LayoutInflater.from(context).inflate(R.layout.contacts_items, null, false);
        return new ViewHolder(view);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ContactModel gamesModelClass = contactModelArrayList.get(position);
        holder.tvAlphabet.setText(gamesModelClass.getProfileLetter().toString());
        holder.tvAlphabet.setBackgroundColor(ContactModel.getColor());

        holder.tvName.setText(contactModelArrayList.get(position).name);
        holder.tvNumber.setText(contactModelArrayList.get(position).number);
    }

    @Override
    public int getItemCount() {
        return contactModelArrayList.size();
    }

    // sub classes
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvAlphabet, tvName, tvNumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAlphabet = itemView.findViewById(R.id.iv_contacts_item);
            tvName = itemView.findViewById(R.id.tvName);
            tvNumber = itemView.findViewById(R.id.tvNumber);
        }
    }
}
