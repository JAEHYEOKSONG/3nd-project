package org.techtown.dongseomap;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.ViewHolder> implements OnPersonItemClickListener{
    ArrayList<Searchinfo> items = new ArrayList<Searchinfo>();
    OnPersonItemClickListener listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_list, parent, false);

        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Searchinfo item = items.get(position);
        holder.setItem(item);
    }

    public void setOnItemClickListener(OnPersonItemClickListener listener)
    {
        this.listener = listener;
    }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if(listener != null){
            listener.onItemClick(holder, view, position);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Searchinfo item){
        items.add(item);
    }
    public void setItem(ArrayList<Searchinfo> items){
        this.items = items;
    }
    public Searchinfo getItem(int position){
        return items.get(position);
    }
    public void setItem(int position, Searchinfo item){
        items.set(position, item);
    }







    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        TextView textView2;

        public ViewHolder(View itemView, final OnPersonItemClickListener listener){
            super(itemView);

            textView = itemView.findViewById(R.id.textView_list_id);
            //textView2 = itemView.findViewById(R.id.textView_list_name);

            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(listener != null){
                        listener.onItemClick(ViewHolder.this, v, position);
                    }
                }
            });
        }

        public void setItem(Searchinfo item)
        {
            textView.setText(item.getName());
            //textView2.setText(item.getMobile());
        }
    }


}

