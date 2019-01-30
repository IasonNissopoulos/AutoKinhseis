package com.example.autokinhseis.activities;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
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

import com.example.autokinhseis.R;
import com.example.autokinhseis.adapters.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Collections;

public class InfoType extends AppCompatActivity implements RecyclerViewAdapter.OnClickListener {

    private static final String TAG = "InfoType";

    private ImageButton logoImageButton;
    private TextView viewTitle;
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

        viewTitle = (TextView) findViewById(R.id.textView_ix_title);
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

//        Toast.makeText(this, mItemTexts.get(position), Toast.LENGTH_SHORT).show();
        Resources res = getResources();
        Intent intent = new Intent(getApplicationContext(), InstructionsActivity.class);
        intent.putExtra("title", mItemTexts.get(position));
        Log.d(TAG, "onItemClick: put intent extra \"title\": " + mItemTexts.get(position));

//        int j = 0;
//        String source = mItemTexts.get(position);
//        Log.d(TAG, "onItemClick: source: " + source);
//        switch (source) {
//            case "Αλλαγή Χρώματος":
//                j = 0;
//                break;
//            case "Αλλαγή Επωνυμίας - Νομικής Μορφής":
//                j = 14;
//                break;
//            case "Ανανέωση Διπλώματος Οδήγησης":
//                j = 22;
//                break;
//        }

        if (position <= 4) {
            if (viewTitle.getText().toString().equals(getString(R.string.diplomata_main))) {
                position += 22;
            }
        } else if (position <= 7 && viewTitle.getText().toString().equals(getString(R.string.epaggelmatika_main))) {
            position +=14;
        }
        Log.d(TAG, "onItemClick: position: " + position);

        TypedArray papersTa = res.obtainTypedArray(R.array.papaers_ref);
        TypedArray instTa = res.obtainTypedArray(R.array.inst_ref);
        int idPapers = papersTa.getResourceId(position, 0);
        Log.d(TAG, "onItemClick: idPapers: " + idPapers);
        int idInst = instTa.getResourceId(position, 0);
        Log.d(TAG, "onItemClick: idInst: " + idInst);


        intent.putExtra("papers", res.getStringArray(idPapers));
        Log.d(TAG, "onItemClick: put intent extra \"papers\": " + res.getStringArray(idPapers).toString());
        intent.putExtra("instructions", res.getStringArray(idInst));
        Log.d(TAG, "onItemClick: put intent extra \"instructions\": " + res.getStringArray(idInst).toString());

        startActivity(intent);
    }
}
