package com.mysticwater.myfilms;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mysticwater.myfilms.databinding.ViewRowFilmBinding;

import java.util.ArrayList;
import java.util.List;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.ViewHolder> {

    private List<Film> films;

    FilmsAdapter() {
        this.films = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewRowFilmBinding binding = ViewRowFilmBinding.inflate(inflater, parent, false);

        binding.executePendingBindings();
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Film film = films.get(i);
        viewHolder.binding.setFilm(film);
    }

    @Override
    public int getItemCount() {
        return films != null ? films.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final ViewRowFilmBinding binding;

        ViewHolder(final ViewRowFilmBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }

}
