package com.example.c5234873.sampleparallax;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.builder.AnimateGifMode;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by C5234873 on 11/6/2016.
 */

public class MovieArrayAdapter extends RecyclerView.Adapter<MovieArrayAdapter.ItemViewHolder> {

    private Context mContext;
    private ArrayList<Movie> mMovieList;

    public MovieArrayAdapter(Context context, ArrayList<Movie> movieList) {
        this.mContext = context;
        this.mMovieList = movieList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.card_view_items, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(itemView);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Movie movieInfo = mMovieList.get(position);
        Ion.with(mContext).load(movieInfo.movieName).withBitmap().intoImageView(holder.imageView);
        holder.textView.setText(movieInfo.movieId);
    }

    @Override
    public int getItemCount() {
        if (mMovieList != null) {
            return mMovieList.size();
        }
        return 0;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public ImageView imageView;
        private TextView textView;

        public ItemViewHolder(View itemView) {

            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cView);
            imageView = (ImageView) itemView.findViewById(R.id.imgView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}
