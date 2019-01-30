package com.example.autokinhseis.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.autokinhseis.R;
import com.example.autokinhseis.viewholders.ContentViewHolder;
import com.example.autokinhseis.viewholders.HeaderViewHolder;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class ExpanderAdapter extends ExpandableRecyclerViewAdapter<HeaderViewHolder, ContentViewHolder> {

    private static final String TAG = "ExpanderAdapter";

    public ExpanderAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public HeaderViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        return new HeaderViewHolder(view);
    }

    @Override
    public ContentViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_expanded_list_child, parent, false);
        return new ContentViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(ContentViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        Log.d(TAG, "onBindChildViewHolder: called.");

        String instruction = (String) group.getItems().get(childIndex);

        holder.setContentText(instruction);
    }

    @Override
    public void onBindGroupViewHolder(HeaderViewHolder holder, int flatPosition, ExpandableGroup group) {
        Log.d(TAG, "onBindGroupViewHolder: called.");

        holder.setHeaderTitle(group.getTitle());
    }
}
