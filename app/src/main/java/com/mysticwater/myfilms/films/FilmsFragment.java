package com.mysticwater.myfilms.films;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mysticwater.myfilms.R;
import com.mysticwater.myfilms.adapters.FilmsAdapter;
import com.mysticwater.myfilms.databinding.FragmentFilmsBinding;

public class FilmsFragment extends Fragment {

    private FilmsViewModel filmsViewModel;
    private FragmentFilmsBinding fragmentFilmsBinding;

    public FilmsFragment() {
    }

    public static FilmsFragment newInstance() {
        return new FilmsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentFilmsBinding = FragmentFilmsBinding.inflate(inflater, container, false);

        View rootView = fragmentFilmsBinding.getRoot();

        filmsViewModel = ViewModelProviders.of(this).get(FilmsViewModel.class);
        fragmentFilmsBinding.setViewmodel(filmsViewModel);

        setupFilmsRecyclerView(rootView);

        return rootView;
    }

    private void setupFilmsRecyclerView(View rootView) {
        RecyclerView filmsRecyclerView = rootView.findViewById(R.id.recycler_view_films);
        filmsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        FilmsAdapter adapter = new FilmsAdapter();
        filmsRecyclerView.setAdapter(adapter);

        filmsViewModel.getFilms().observe(this, adapter::setData);
    }


}
