package edu.cs4730.lotsoflists;

/**
 * Created by Seker on 1/22/2015.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

/*
 * this adapter is very similar to the adapters used for listview, except a ViewHolder is required
 * see http://developer.android.com/training/improving-layouts/smooth-scrolling.html
 * except instead having to implement a ViewHolder, it is implemented within
 * the adapter.
 */

public class myAdapter extends RecyclerView.Adapter<myAdapter.ViewHolder> {

    private morelists myList;
    private int rowLayout;
    private Context mContext;

    public myAdapter(morelists myList, int rowLayout, Context context) {
        this.myList = myList;
        this.rowLayout = rowLayout;
        this.mContext = context;
    }

    //a simple method to make sure the recyclerview knows I have changed the data in the list.
    public void newData() {
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        String entry = myList.get(i);
        viewHolder.myName.setText(entry);
        viewHolder.myName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView) v;
                Toast.makeText(mContext, tv.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.Pic.setImageResource(R.drawable.phone);
    }  //mContext.getDrawable(country.getImageResourceId(mContext))

    @Override
    public int getItemCount() {
        return myList == null ? 0 : myList.getsize();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView myName;
        public ImageView Pic;

        public ViewHolder(View itemView) {
            super(itemView);
            myName = (TextView) itemView.findViewById(R.id.Name);
            Pic = (ImageView) itemView.findViewById(R.id.picture);
        }
    }
}
