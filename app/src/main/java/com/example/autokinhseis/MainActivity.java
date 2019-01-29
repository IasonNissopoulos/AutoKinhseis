package com.example.autokinhseis;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    ImageButton logoImageButton, ixImageButton, epaggelmatikaImageButton, diplomataImageButton;
    TextView ixTextView, epaggelmatikaTextView, diplomataTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Resources res = getResources();

        logoImageButton = (ImageButton) findViewById(R.id.imageButton_logo);
        ixImageButton = (ImageButton) findViewById(R.id.imageButton_ix);
        epaggelmatikaImageButton = (ImageButton) findViewById(R.id.imageButton_epaggelmatika);
        diplomataImageButton = (ImageButton) findViewById(R.id.imageButton_diplomata);

        ixTextView = (TextView) findViewById(R.id.textView_ix);
        epaggelmatikaTextView = (TextView) findViewById(R.id.textView_epaggelmatika);
        diplomataTextView = (TextView) findViewById(R.id.textView_diplomata);

        logoImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

        ixImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), InfoType.class);
                i.putExtra("list", res.getStringArray(R.array.ix_list));
                i.putExtra("title", getString(R.string.ix_main));
                startActivity(i);
            }
        });

        epaggelmatikaImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), InfoType.class);
                i.putExtra("list", res.getStringArray(R.array.epaggelmatika_list));
                i.putExtra("title", getString(R.string.epaggelmatika_main));
                startActivity(i);
            }
        });

        diplomataImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), InfoType.class);
                i.putExtra("list", res.getStringArray(R.array.diplomata_list));
                i.putExtra("title", getString(R.string.diplomata_main));
                startActivity(i);
            }
        });
    }
}
