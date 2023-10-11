package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menuPersonas extends AppCompatActivity {

    Button crear;
    Button listar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dos);

        crear=(Button)findViewById(R.id.btnCrear);
        listar=(Button)findViewById(R.id.btnListar);

        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentCreate=new Intent(getApplicationContext(),formularioPersonas.class);
               // intentCreate.putExtra("nombres","Juan Paco Pedro");
              //  intentCreate.putExtra("apellidos","De la Mar");

                startActivity(intentCreate);



            }
        });

        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCreate=new Intent(getApplicationContext(),ActivityList.class);
                startActivity(intentCreate);
            }
        });

    }
}