package com.example.tra120290011;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tra120290011.configuracion.SQLiteConexion;
import com.example.tra120290011.configuracion.Transacciones;
import com.example.tra120290011.tablas.Personas;

import java.util.ArrayList;

public class ActivityList extends AppCompatActivity {

    SQLiteConexion conexion;
    ListView listapersonas;
    ArrayList<Personas> lista;
    ArrayList<String> ArregloPersonas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        conexion = new SQLiteConexion( this, Transacciones.NameDatabase, null, 1);
        listapersonas =(ListView) findViewById(R.id.litapersonas);

        ObtenerListaPersona();
        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ArregloPersonas);
        listapersonas.setAdapter(adp);


        listapersonas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getApplicationContext(), lista.get(i).getCorreo().toString(),Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void ObtenerListaPersona() {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Personas person = null;
        lista = new ArrayList<Personas>();

        Cursor cursor = db.rawQuery("SELECT * FROM "+ Transacciones.tablaperson,null);

        while(cursor.moveToNext())
        {
            person = new Personas();
            person.setId(cursor.getInt(0));
            person.setNombres(cursor.getString(1));
            person.setApellidos(cursor.getString(2));
            person.setEdad(cursor.getInt(3));
            person.setCorreo(cursor.getString(4));
            lista.add(person);
        }

        cursor.close();

        filllist();
    }

    private void filllist() {
        ArregloPersonas = new ArrayList<String>();
        for(int i = 0 ; i <lista.size(); i++)
        {
            ArregloPersonas.add(lista.get(i).getId()+ " | "+
                    lista.get(i).getNombres()+ " | "+
                    lista.get(i).getId()+ " | ");
        }
    }
}