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

public class ChalisaFragment extends Fragment implements OnItemClickListener {
    private View rootView;
    private OnItemClickListener onItemClickListener;

    public ChalisaFragment() {
    }

    ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.chalisa, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        onItemClickListener = ChalisaFragment.this;
        initView();
    }

    void initView() {
        RecyclerView mDrawerRecycler = rootView.findViewById(R.id.rvChalisa);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        mDrawerRecycler.setLayoutManager(layoutManager);
        mDrawerRecycler.setHasFixedSize(false);
        String[] chalisaList = getResources().getStringArray(R.array.chalisaAndAartiCollection);
        CommonRecyclerViewAdapter chalisaRecyclerAdapter = new CommonRecyclerViewAdapter(Arrays.asList(chalisaList), getContext(), getContext().getString(R.string.chalisa), onItemClickListener);
        mDrawerRecycler.setAdapter(chalisaRecyclerAdapter);
    }

    @Override
    public void showDetails(String bookName) {
        Intent intent = new Intent(getActivity(), ShowBook.class);
        intent.putExtra("BookName", bookName);
        startActivity(intent);

    }
}
