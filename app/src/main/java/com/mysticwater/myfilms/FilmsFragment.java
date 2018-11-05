package com.mysticwater.myfilms;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import com.mysticwater.myfilms.databinding.FragmentFilmsBinding;

public class FilmsFragment extends Fragment {

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


        setupFilmsRecyclerView(rootView);

        return rootView;
    }

    private void setupFilmsRecyclerView(View rootView) {
        RecyclerView filmsRecyclerView = rootView.findViewById(R.id.recycler_view_films);
        filmsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        List<Film> films = new ArrayList();
        Film testFilm = new Film(1, "Film Title", "01/01/1970", "", 2.5, 2);
        films.add(testFilm);
        FilmsAdapter adapter = new FilmsAdapter(films);

        filmsRecyclerView.setAdapter(adapter);
    }



}
