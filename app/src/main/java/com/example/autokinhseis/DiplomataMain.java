package com.example.autokinhseis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class DiplomataMain extends AppCompatActivity implements RecyclerViewAdapter.OnClickListener {

    private static final String TAG = "DiplomataMain";

    private ImageButton logoImageButton;
    private ArrayList<String> mItemTexts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diplomata_main);
        Log.d(TAG, "onCreate: started.");

        makeTextArray();

        logoImageButton = (ImageButton) findViewById(R.id.imageButton_logo_diplomata);

        logoImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }

    private void makeTextArray() {
        Log.d(TAG, "makeTextArray: making listitems");

        mItemTexts.add("Ανανέωση Διπλώματος Οδήγησης");

        mItemTexts.add("Αντικατάσταση Παλαιάς Άδειας με Νέου Τύπου");

        mItemTexts.add("Διεθνές Δίπλωμα Οδήγησης");

        mItemTexts.add("Επανέκδοση Διπλώματος Οδήγησης");

        mItemTexts.add("Μετατροπή Επαγγελματικής Άδειας σε Ερασιτεχνική");

        initRecyclerView();

    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerview");
        RecyclerView recyclerView = findViewById(R.id.diplomata_list);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mItemTexts, this, this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL);
        dividerItemDecoration.setDrawable(this.getResources().getDrawable(R.drawable.line_divider));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void onItemClick(int position) {
        Log.d(TAG, "onClick: clicked on: " + mItemTexts.get(position));

        Toast.makeText(this, mItemTexts.get(position), Toast.LENGTH_SHORT).show();
    }
}
