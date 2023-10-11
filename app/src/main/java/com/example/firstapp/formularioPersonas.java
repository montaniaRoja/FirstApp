package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.firstapp.config.Transacciones;
import com.example.firstapp.config.sqlLiteConexion;

public class formularioPersonas extends AppCompatActivity {

    EditText txtName, txtLastName, txtEdad, txtCorreo;
    Button btnProcesar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName=(EditText)findViewById(R.id.txtNombre);
        txtLastName=(EditText)findViewById(R.id.txtApellido);
        txtEdad=(EditText)findViewById(R.id.txtEdad);
        txtCorreo=(EditText)findViewById(R.id.txtCorreo);
        btnProcesar=(Button)findViewById(R.id.btnGuardar);

        /*
        este es un ejemplo para pasar o enviar info entre pantallas
        txtName.setText(getIntent().getStringExtra("nombres"));
        txtLastName.setText(getIntent().getStringExtra("apellidos"));

        */


        btnProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddPerson();
            }
        });

    }

    private void AddPerson() {
        try {
            sqlLiteConexion conexion = new sqlLiteConexion(this, Transacciones.nameBD, null, 1);
            //poner la base de datos en modo readwrite
            SQLiteDatabase db = conexion.getWritableDatabase();

            ContentValues valores = new ContentValues();
            valores.put(Transacciones.nombres, txtName.getText().toString());
            valores.put(Transacciones.apellidos, txtLastName.getText().toString());
            valores.put(Transacciones.edad, txtEdad.getText().toString());
            valores.put(Transacciones.correo, txtCorreo.getText().toString());

            Long Result = db.insert(Transacciones.table, Transacciones.id, valores);
            Toast.makeText(this, getString(R.string.app_exito), Toast.LENGTH_SHORT).show();
            txtName.setText("");
            txtLastName.setText("");
            txtEdad.setText("");
            txtCorreo.setText("");

            db.close();
        }
        catch (Exception exception){
            Toast.makeText(this, getString(R.string.app_error), Toast.LENGTH_SHORT).show();
        }
    }
}