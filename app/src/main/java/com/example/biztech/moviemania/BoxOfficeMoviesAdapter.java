package com.example.biztech.moviemania;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import com.squareup.picasso.Picasso;

public class BoxOfficeMoviesAdapter extends RecyclerView.Adapter<BoxOfficeMoviesAdapter.ViewHolder> {

    private List<Movie> aMovies;

    public BoxOfficeMoviesAdapter(List<Movie> aMovies) {
        this.aMovies = aMovies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.adapter_item_box_office_movie, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTitle;
        public TextView tvCriticsScore;
        public TextView tvCast;
        public ImageView ivPosterImage;

        public ViewHolder(View itemView) {
            super(itemView);

            this.tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            this.tvCriticsScore = (TextView) itemView.findViewById(R.id.tvCriticsScore);
            this.tvCast = (TextView) itemView.findViewById(R.id.tvCast);
            this.ivPosterImage = (ImageView) itemView.findViewById(R.id.ivPosterImage);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BoxOfficeMoviesAdapter.ViewHolder holder, int position) {

        final Movie movie = aMovies.get(position);
        // Populate the data into the template view using the data object
        holder.tvTitle.setText(movie.getTitle());
        holder.tvCriticsScore.setText("Score: " + movie.getTitle() + "%");
        holder.tvCast.setText(movie.getTitle().toString());
        Picasso.get().load(movie.getPosterPath()).into(holder.ivPosterImage);

    }


    @Override
    public int getItemCount() {
        return aMovies.size();
    }
}
