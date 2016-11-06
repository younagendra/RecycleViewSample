package com.example.c5234873.sampleparallax;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import static android.os.Build.VERSION_CODES.M;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    ArrayList<Movie> mMovieList;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_blank, container, false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.rcView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setHasFixedSize(true);

        mMovieList = new ArrayList<>();
        setMovieList();

        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(new MovieArrayAdapter(getContext().getApplicationContext(), mMovieList));

        return rootView;
    }

    private void setMovieList() {
        mMovieList.clear();

        Movie arrayInfo = new Movie();
        for (int i = 1; i < 20; i++) {

            arrayInfo.movieId = "Movie" + 1;
            arrayInfo.movieName = "http://www.inkyourcode.com/wp-content/uploads/2016/08/interview.gif";

            mMovieList.add(arrayInfo);
        }
    }

}
