package com.example.autokinhseis.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.autokinhseis.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mListItemTexts = new ArrayList<>();
    private Context mContext;
    private OnClickListener mOnClickListener;

    public RecyclerViewAdapter(ArrayList<String> mListItemTexts, Context mContext, OnClickListener onClickListener) {
        this.mListItemTexts = mListItemTexts;
        this.mContext = mContext;
        this.mOnClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view, mOnClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Log.d(TAG, "onBindViewHolder: called.");

        viewHolder.listItemText.setText(mListItemTexts.get(i));

    }

    @Override
    public int getItemCount() {
        return mListItemTexts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView listItemText;
        RelativeLayout parentLayout;
        OnClickListener onClickListener;

        public ViewHolder(@NonNull View itemView, OnClickListener onClickListener) {
            super(itemView);

            listItemText = itemView.findViewById(R.id.item_description);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            this.onClickListener = onClickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onClickListener.onItemClick(getAdapterPosition());
        }
    }

    public interface OnClickListener {
        void onItemClick(int position);
    }
}
