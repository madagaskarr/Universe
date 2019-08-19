package io.tigranes.universe.ViewHolder;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import io.tigranes.universe.Listener.OnNasaSearchItemClickListener;
import io.tigranes.universe.R;

public class NasaImageSearchViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ImageView nasaImageView;
    private TextView nasaTitleEditText;
    private OnNasaSearchItemClickListener onNasaSearchItemClickListener;


    public NasaImageSearchViewHolder(@NonNull View itemView, OnNasaSearchItemClickListener onNasaSearchItemClickListener) {
        super(itemView);

        this.nasaImageView = itemView.findViewById(R.id.nasa_image_view);
        this.nasaTitleEditText = itemView.findViewById(R.id.nasa_title_text_view);
        this.onNasaSearchItemClickListener = onNasaSearchItemClickListener;
    }

    @Override
    public void onClick(View view) {
        onNasaSearchItemClickListener.onNasaSearchItemClicked(getAdapterPosition());
    }

    public void setTitle(String title) {
        this.nasaTitleEditText.setText(title);
    }

    public String getTitle() {
        return this.nasaTitleEditText.getText().toString();
    }

    public ImageView getNasaImageView() {
        return nasaImageView;
    }

    public void setNasaImageView(ImageView nasaImageView) {
        this.nasaImageView = nasaImageView;
    }
}
