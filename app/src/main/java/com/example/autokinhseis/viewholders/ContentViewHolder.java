package com.example.autokinhseis.viewholders;

import android.view.View;
import android.widget.TextView;

import com.example.autokinhseis.R;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class ContentViewHolder extends ChildViewHolder {

    private static final String TAG = "ContentViewHolder";

    private TextView contentText;

    public ContentViewHolder(View itemView) {
        super(itemView);
        contentText = (TextView) itemView.findViewById(R.id.item_description);
    }

    public void setContentText(String text) {
        contentText.setText(text);
    }
}
