package com.example.nftcentral;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.nftcentral.Api.ApiLoader;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean darkmode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        Button b = findViewById(R.id.button);
        b.setOnClickListener(this);

        updateChart();
    }


    private void updateChart() {
        //Define chart
        LineChart chart = (LineChart) findViewById(R.id.chart);

        ArrayList<BalanceUpdates> datalist = new ArrayList();

        BalanceUpdates j = new BalanceUpdates();
        j.bal = 5;
        j.date = 0;

        BalanceUpdates k = new BalanceUpdates();
        k.bal = 45;
        k.date = 1;

        BalanceUpdates l = new BalanceUpdates();
        l.bal = 40;
        l.date = 2;

        BalanceUpdates h = new BalanceUpdates();
        h.bal = 35;
        h.date = 3;

        datalist.add(j);
        datalist.add(k);
        datalist.add(l);
        datalist.add(h);

        List<Entry> entries = new ArrayList<Entry>();
        for (BalanceUpdates data : datalist) {
            // turn your data into Entry objects
            entries.add(new Entry(data.date, data.bal));
        }

        LineDataSet dataSet = new LineDataSet(entries, ""); // add entries to dataset
        dataSet.setCubicIntensity(0f);
        dataSet.setDrawFilled(true);
        dataSet.setFillColor(Color.GREEN);
        dataSet.setDrawHighlightIndicators(false);
        if (darkmode) {
            dataSet.setColor(0);
        }

        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.invalidate(); // refresh
        //dataSet.setColor(...);
        //dataSet.setValueTextColor(...); // styling,
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.action_favorite) {
            Toast toast = Toast.makeText(getApplicationContext(), "yo", Toast.LENGTH_SHORT);
            toast.show();
            // Favorites was pressed!
        } else if (itemId == R.id.action_settings) {
            Toast toast = Toast.makeText(getApplicationContext(), "yo2", Toast.LENGTH_SHORT);
            toast.show();
            // Settings was pressed!
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View view) {

        ApiLoader apiLoader = new ApiLoader();
        apiLoader.execute();
        //startActivity(new Intent(this, Login.class));
    }
}