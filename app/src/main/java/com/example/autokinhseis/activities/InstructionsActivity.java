package com.example.autokinhseis.activities;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.autokinhseis.R;
import com.example.autokinhseis.adapters.ExpanderAdapter;
import com.example.autokinhseis.models.Header;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InstructionsActivity extends AppCompatActivity {

    private static final String TAG = "InstructionsActivity";

    private RecyclerView mRecyclerView;
    private ExpanderAdapter mAdapter;
    private TextView viewTitle;
    private List<Header> headers;
    private ImageButton logoImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
        Log.d(TAG, "onCreate: started.");

        mRecyclerView = (RecyclerView) findViewById(R.id.instructions_list);

        getIncomingIntent();
        mAdapter = new ExpanderAdapter(headers);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(InstructionsActivity.this));
        mRecyclerView.setAdapter(mAdapter);

        logoImageButton = (ImageButton) findViewById(R.id.imageButton_logo_instructions);

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

        if (getIntent().hasExtra("papers") && getIntent().hasExtra("instructions") && getIntent().hasExtra("title")) {
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            String[] papers = getIntent().getStringArrayExtra("papers");
            String[] instructions = getIntent().getStringArrayExtra("instructions");
            String title = getIntent().getStringExtra("title");

            viewTitle = (TextView) findViewById(R.id.textView_instructions_title);
            viewTitle.setText(title);

            getHeaders(instructions, papers);
        }
    }

    private void getHeaders(String[] instructions, String[] papers) {
        Resources res = getResources();
        headers = new ArrayList<>(2);
        List<String> instructionsList = new ArrayList<String>(Arrays.asList(instructions));
        List<String> papersList = new ArrayList<String>(Arrays.asList(papers));
        headers.add(new Header(getString(R.string.papers), papersList));
        headers.add(new Header(getString(R.string.steps), instructionsList));
    }
}