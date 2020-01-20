package com.example.footballsimulator;

/**
 * MainActivity is de startpagina van de app.
 *
 * Auteur EK
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonStartSimulation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStartSimulation = (Button) findViewById(R.id.buttonStartSimulation);
        buttonStartSimulation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSimulation();
            }
        });
    }

    public void startSimulation() {
        Intent intent = new Intent(this, DisplaySchedule.class);
        startActivity(intent);


    }
}
