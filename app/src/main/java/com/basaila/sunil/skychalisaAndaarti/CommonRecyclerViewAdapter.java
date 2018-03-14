package com.basaila.sunil.skychalisaAndaarti;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sunil on 11/20/2017.
 */

public class CommonRecyclerViewAdapter extends RecyclerView.Adapter<CommonRecyclerViewAdapter.CollectionHolder> implements View.OnClickListener {
    private List<String> dataList = new ArrayList<>();
    private Context mContext;
    private String mDataType;
    private OnItemClickListener itemClickListener;
    private String[] itemClicked;
    private String tappedBook;


    public CommonRecyclerViewAdapter(List<String> dataList, Context context, String dataType, OnItemClickListener onItemClickListener) {
        this.dataList = dataList;
        mContext = context;
        mDataType = dataType;
        itemClickListener = onItemClickListener;
    }

    @Override
    public CollectionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerdrawerimage, parent, false);
        return new CollectionHolder(view);
    }

    @Override
    public void onBindViewHolder(final CollectionHolder holder, int position) {
        final int holderPosition = holder.getAdapterPosition();
        String data = dataList.get(holderPosition);

        final String defaultImage = data;
        final int defaultImageId = getImageId(defaultImage);
        String description = mContext.getString(R.string.shri) + " " + data + " " + mDataType;
        holder.tvBookName.setText(description);
        holder.ivBookImage.setImageResource(defaultImageId);
        holder.ivBookImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClicked = ((String) holder.tvBookName.getText()).split(mContext.getString(R.string.shri));
                tappedBook = itemClicked[1].split(mDataType)[0].trim() + "_" + mDataType;
                itemClickListener.showDetails(tappedBook);
            }
        });
        holder.tvBookName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.showDetails(tappedBook);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public void onClick(View view) {
//        String book = view.toString();
//        itemClickListener.showDetails(itemClicked);
    }

    public static class CollectionHolder extends RecyclerView.ViewHolder {

        TextView tvBookName;
        ImageView ivBookImage;

        public CollectionHolder(View itemView) {
            super(itemView);
            tvBookName = itemView.findViewById(R.id.tvFeatureName);
            ivBookImage = itemView.findViewById(R.id.imgFeature);
        }
    }

    private int getImageId(String name) {
        String imageName = name.toLowerCase();
        return mContext.getResources().getIdentifier(imageName, "drawable",
                mContext.getPackageName());
    }

}
