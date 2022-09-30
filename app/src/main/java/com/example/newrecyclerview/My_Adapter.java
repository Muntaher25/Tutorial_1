package com.example.newrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class My_Adapter extends RecyclerView.Adapter<My_Adapter.MyViewHolder> {
    private static ClickListener clickListener;
    Context context;
    String[] title,description;
    int[] images;

    public My_Adapter(Context context, String[] title, String[] description, int[] images) {
        this.context = context;
        this.title = title;
        this.description = description;
        this.images = images;
    }

    @NonNull
    @Override
    public My_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.sample_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull My_Adapter.MyViewHolder holder, int position) {
            holder.TitleTextView.setText(title[position]);
            holder.descTextView.setText(description[position]);
            holder.appview.setImageResource(images[position]);

    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {

        TextView TitleTextView,descTextView;
        ImageView appview;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            TitleTextView = itemView.findViewById(R.id.textid);
            descTextView = itemView.findViewById(R.id.descriptionid);
            appview = itemView.findViewById(R.id.imageid);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View view) {

            clickListener.onItemClick(getAbsoluteAdapterPosition(),view);

        }

        @Override
        public boolean onLongClick(View view) {
            clickListener.onItemLongClick(getAbsoluteAdapterPosition(),view);

            return false;
        }
    }

    public interface ClickListener{
        void  onItemClick (int position,View v);
        void  onItemLongClick(int position,View v);
    }
    public void setOnItemClickListener(ClickListener clickListener)
    {
        My_Adapter.clickListener = clickListener;
    }
}
