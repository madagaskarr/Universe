package io.tigranes.universe.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import io.tigranes.universe.Listener.OnNasaSearchItemClickListener;
import io.tigranes.universe.Model.NasaReturnedArray;
import io.tigranes.universe.R;
import io.tigranes.universe.ViewHolder.NasaImageSearchViewHolder;

public class NasaImageSearchRecyclerViewAdapter extends RecyclerView.Adapter<NasaImageSearchViewHolder> {

    private List<NasaReturnedArray> nasaList;
    private OnNasaSearchItemClickListener onNasaSearchItemClickListener;

    public NasaImageSearchRecyclerViewAdapter(OnNasaSearchItemClickListener onNasaSearchItemClickListener) {
        this.onNasaSearchItemClickListener = onNasaSearchItemClickListener;
    }

    public List<NasaReturnedArray> getNasaList() {
        return nasaList;
    }

    public void setNasaList(List<NasaReturnedArray> nasaList) {
        this.nasaList = nasaList;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public NasaImageSearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NasaImageSearchViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.nasa_image_search_item_view, parent, false), onNasaSearchItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NasaImageSearchViewHolder holder, int position) {
        holder.setTitle(nasaList.get(position).getData().get(0).getTitle());
        Log.d("abrakadabra", holder.getTitle() + " " + position);
        RequestOptions requestOptions = new RequestOptions().placeholder(R.drawable.ic_launcher_background);
        Glide.with(holder.itemView.getContext()).setDefaultRequestOptions(requestOptions).load(nasaList.get(position).getLinks().get(0).getHref()).into(holder.getNasaImageView());
    }

    @Override
    public int getItemCount() {
        if (nasaList == null) {
            return 0;
        } else {
            return nasaList.size();
        }
    }
}
