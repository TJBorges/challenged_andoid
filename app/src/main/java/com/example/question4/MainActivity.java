package com.example.question4;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter adapter;
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> namesContains = new ArrayList<>();
    private String filtroDig;
    private ListView lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final EditText filtro = (EditText) findViewById(R.id.filtro);

        iniciarLista();
        filtro.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                filtroDig = charSequence.toString().trim();
                if (filtroDig.isEmpty()) {
                    adapter.clear();
                    iniciarLista();
                } else {
                    adapter.clear();
                    iniciarLista();
                    for (String name : names) {
                        if (name.toLowerCase().contains(filtroDig.trim().toLowerCase())) {
                            namesContains.add(name);
                        }
                    }
                    adapter.clear();
                    atualizarLista(namesContains);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void iniciarLista() {
        lista = (ListView) findViewById(R.id.listaNomes);
        names.add("Marcos Farinha");
        names.add("Marco Tulio");
        names.add("Arthur Lira");
        names.add("Artur Marcal");
        names.add("Carol Ferreira");
        names.add("Carlos Jose");
        names.add("Carina Barros");
        names.add("Karina Borges");
        names.add("Marcela de Souza");
        names.add("Marcerlia Cabral");
        names.add("Maria Fernanda");
        names.add("Julio Henrique");
        names.add("Marcos Edgar");
        names.add("Tulio Silva");

        atualizarLista(names);
    }

    private void atualizarLista(ArrayList<String> name) {
        adapter = new ArrayAdapter(this, R.layout.fragment_first, name);
        lista.setAdapter(adapter);
    }
}