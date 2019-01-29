package com.example.autokinhseis;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class InfoType extends AppCompatActivity implements RecyclerViewAdapter.OnClickListener {

    private static final String TAG = "InfoType";

    private ImageButton logoImageButton;
    private ArrayList<String> mItemTexts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_type);
        Log.d(TAG, "onCreate: started.");

        getIncomingIntent();

        logoImageButton = (ImageButton) findViewById(R.id.imageButton_logo_info_type);

        logoImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
    }

    private void getIncomingIntent() {
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");

        if (getIntent().hasExtra("list") && getIntent().hasExtra("title")) {
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            String title = getIntent().getStringExtra("title");
            String[] list = getIntent().getStringArrayExtra("list");

            setViews(title, list);
        }
    }

    private void setViews(String title, String[] list) {
        Log.d(TAG, "setViews: making views.");

        TextView viewTitle = (TextView) findViewById(R.id.textView_ix_title);
        viewTitle.setText(title);

        Collections.addAll(mItemTexts, list);
        Log.d(TAG, "setViews: mItemTexts:" + mItemTexts.toString());

        initRecyclerView();

    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: initializing recyclerView.");
        RecyclerView recyclerView = findViewById(R.id.ix_list);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mItemTexts, this, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration itemDecor = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecor);
    }

    @Override
    public void onItemClick(int position) {
        Log.d(TAG, "onClick: clicked on: " + mItemTexts.get(position));

        Toast.makeText(this, mItemTexts.get(position), Toast.LENGTH_SHORT).show();
        Resources res = getResources();

        Intent intent = new Intent(getApplicationContext(), InfoType.class);
        intent.putExtra("list", res.getStringArray(R.array.diplomata_list));
        intent.putExtra("title", getString(R.string.diplomata_main));
        startActivity(intent);
    }
}
