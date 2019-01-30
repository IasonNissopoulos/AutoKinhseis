package com.example.autokinhseis.viewholders;

import android.view.View;
import android.widget.TextView;

import com.example.autokinhseis.R;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

public class HeaderViewHolder extends GroupViewHolder {

    private static final String TAG = "HeaderViewHolder";

    private TextView headerText;

    public HeaderViewHolder(View itemView) {
        super(itemView);
        headerText = (TextView) itemView.findViewById(R.id.item_description);
    }

    public void setHeaderTitle(String title) {
        headerText.setText(title);
    }
}
