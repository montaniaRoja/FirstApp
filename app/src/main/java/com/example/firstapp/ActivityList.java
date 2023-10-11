package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.firstapp.config.Transacciones;
import com.example.firstapp.config.sqlLiteConexion;
import com.example.firstapp.models.Personas;

import java.util.ArrayList;

public class ActivityList extends AppCompatActivity {

    sqlLiteConexion conexion;
    ListView listView;
    ArrayList<Personas> listPerson;

    ArrayList<String> arregloPersonas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        conexion = new sqlLiteConexion(this, Transacciones.nameBD, null, 1);
        listView = (ListView) findViewById(R.id.listPersonas);

        // Inicializa el ArrayList arregloPersonas
        arregloPersonas = new ArrayList<String>();

        GetPersons();
        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, arregloPersonas);
        listView.setAdapter(adp);
    }


    private void GetPersons() {
        SQLiteDatabase db= conexion.getWritableDatabase();
        Personas person=null;
        listPerson=new ArrayList<Personas>();

        Cursor cursor = db.rawQuery(Transacciones.SeleccionarTablaPersonas,null);
        while(cursor.moveToNext()){
            person =new Personas();
            person.setId(cursor.getInt(0));
            person.setNombres(cursor.getString(1));
            person.setApellidos(cursor.getString(2));
            person.setEdad(cursor.getInt(3));
            person.setCorreo(cursor.getString(4));

            listPerson.add(person);

        }

        cursor.close();

        FillList();



    }

    private void FillList() {
        for(int i=0;i<listPerson.size();i++){
            arregloPersonas.add(listPerson.get(i).getId()+"-"+
                    listPerson.get(i).getNombres()+" "+
                    listPerson.get(i).getApellidos());

        }



    }
}