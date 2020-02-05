package id.ac.poliban.mi.maya.listnegara;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Country> countries = new ArrayList<>();
    private ListView lvCountry;
    private BaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;
        setContentView(R.layout.activity_main);

        lvCountry = findViewById(R.id.listview);
        countries.addAll(CountryData.getAllCountries());
        adapter = new CountryAdapter(countries);
        lvCountry.setAdapter(adapter);
        lvCountry.setOnItemClickListener((parent, view, position, id) -> {
            new AlertDialog.Builder(this)
                    .setTitle("Info")
                    .setMessage(countries.get(position).toString())
                    .setPositiveButton("OK", null).show();
        });

    }
}
