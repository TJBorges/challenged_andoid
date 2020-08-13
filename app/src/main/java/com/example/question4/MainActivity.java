package com.example.question4;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListView lista = (ListView) findViewById(R.id.listaNomes);
        final EditText filtro = (EditText) findViewById(R.id.filtro);

        final ArrayList<String> names = new ArrayList<>();
        names.add("Marcos");
        names.add("Marco");
        names.add("Arthur");
        names.add("Artur");
        names.add("Carol");
        names.add("Carlos");
        names.add("Carina");
        names.add("Karina");
        names.add("Marcela");
        names.add("Marcerlia");
        names.add("Maria");

        adapter = new ArrayAdapter(this, R.layout.fragment_first, names);
        lista.setAdapter(adapter);

        filtro.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                (MainActivity.this).adapter.getFilter().filter(editable);

            }

        });

    }

}