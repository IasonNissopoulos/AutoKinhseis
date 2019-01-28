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

public class EpaggelmatikaMain extends AppCompatActivity implements RecyclerViewAdapter.OnClickListener {

    private static final String TAG = "EpaggelmatikaMain";

    private ImageButton logoImageButton;
    private ArrayList<String> mItemTexts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epaggelmatika_main);
        Log.d(TAG, "onCreate: started.");

        makeTextArray();

        logoImageButton = (ImageButton) findViewById(R.id.imageButton_logo_epaggelmatika);

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

        mItemTexts.add("Αλλαγή Επωνυμίας - Νομικής Μορφής");

        mItemTexts.add("Άρση Ακινησίας Φ.Ι.Χ. ή Λ.Ι.Χ.");

        mItemTexts.add("Έκδοση Νέας Άδειας Φορτηγού");

        mItemTexts.add("Επανέκδοση Άδειας Φ.Ι.Χ. ή Λ.Ι.Χ.");

        mItemTexts.add("Κατάθεση Πινακίδων Φ.Ι.Χ. ή Λ.Ι.Χ.");

        mItemTexts.add("Μεταβίβαση Φ.Ι.Χ. ή Λ.Ι.Χ. (Πώληση)");

        mItemTexts.add("Μεταβίβαση Λόγω Κληρονομιάς");

        mItemTexts.add("Μεταβίβαση Λόγω Λύσεως της Εταιρίας");

        initRecyclerView();

    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerview");
        RecyclerView recyclerView = findViewById(R.id.epaggelmatika_list);
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
