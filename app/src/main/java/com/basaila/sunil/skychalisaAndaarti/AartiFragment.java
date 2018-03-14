package com.basaila.sunil.skychalisaAndaarti;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;

/**
 * Created by Sunil on 11/19/2017.
 */

public class AartiFragment extends Fragment implements OnItemClickListener {
    View rootView;
    private OnItemClickListener onItemClickListener;

    public AartiFragment() {
    }

    ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.aarti, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        onItemClickListener = AartiFragment.this;
        initView();
    }

    void initView() {
        RecyclerView mDrawerRecycler = rootView.findViewById(R.id.rvAarti);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        mDrawerRecycler.setLayoutManager(layoutManager);
        mDrawerRecycler.setHasFixedSize(false);
        String[] aartiList = getResources().getStringArray(R.array.chalisaAndAartiCollection);
        CommonRecyclerViewAdapter aartiRecyclerAdapter = new CommonRecyclerViewAdapter(Arrays.asList(aartiList), getContext(), getContext().getString(R.string.aarti),onItemClickListener);
        mDrawerRecycler.setAdapter(aartiRecyclerAdapter);
    }

    @Override
    public void showDetails(String bookName) {
        Intent intent = new Intent(getActivity(), ShowBook.class);
        intent.putExtra("BookName", bookName);
        startActivity(intent);
    }
}
