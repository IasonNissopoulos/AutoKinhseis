package com.example.autokinhseis;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
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

public class IXMain extends AppCompatActivity implements RecyclerViewAdapter.OnClickListener {

    private static final String TAG = "IXMain";

    private ImageButton logoImageButton;
    private ArrayList<String> mItemTexts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ixmain);
        Log.d(TAG, "onCreate: started.");

        makeTextArray();

        logoImageButton = (ImageButton) findViewById(R.id.imageButton_logo_ix);

        logoImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
    }

    private void makeTextArray() {
        Log.d(TAG, "makeTextArray: making listitems");

        mItemTexts.add("Αλλαγή Χρώματος");

        mItemTexts.add("Αντικατάσταση Άδειας Κυκλοφορίας");

        mItemTexts.add("Αντικατάσταση Πινακίδων");

        mItemTexts.add("Άρση Παρακράτησης Κυριότητας");

        mItemTexts.add("Δήλωση Κλοπής Ι.Χ. ή Μοτοσυκλέτας");

        mItemTexts.add("Εξαγωγή Ι.Χ. στο Εξωτερικό");

        mItemTexts.add("Έκδοση Νέας Άδειας Κυκλοφορίας");

        mItemTexts.add("Κάρτα Στάθμευσης ΑμεΑ");

        mItemTexts.add("Κάρτα Στάθμευσης Μόνιμου Κατοίκου");

        mItemTexts.add("Μεταβίβαση Αυτοκινήτου ή Μοτοσυκλέτας");

        mItemTexts.add("Μεταβίβαση Ι.Χ. Λόγω Κληρονομιάς");

        mItemTexts.add("Οριστική Διαγραφή Οχήματος");

        mItemTexts.add("Οριστική Διαγραφή Ι.Χ. (πριν τις 4.3.2004)");

        mItemTexts.add("Σημείωμα Ρυμούλκησης");

        initRecyclerView();

    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerview");
        RecyclerView recyclerView = findViewById(R.id.ix_list);
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
