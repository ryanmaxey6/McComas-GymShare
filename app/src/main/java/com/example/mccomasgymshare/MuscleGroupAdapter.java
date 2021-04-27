package com.example.mccomasgymshare;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MuscleGroupAdapter extends RecyclerView.Adapter<MuscleGroupAdapter.ImageViewHolder> {
    private int[] images;
    private String[] imagesText;
    
    public MuscleGroupAdapter(int[] images, String[] imagesText){
        this.images = images;
        this.imagesText = imagesText;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.exercise_layout, parent, false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        int image_id = images[position];
        holder.image.setImageResource(image_id);
        String image_text = imagesText[position];
        holder.text.setText(image_text);

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView text;

        public ImageViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.ivExercise);
            text = itemView.findViewById(R.id.tvExercise);
        }
    }
}
