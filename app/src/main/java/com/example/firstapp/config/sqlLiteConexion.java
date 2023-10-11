package com.example.firstapp.config;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class sqlLiteConexion extends SQLiteOpenHelper {


    public sqlLiteConexion(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //este metodo se llama cuando se crea la base de datos por primera vez

        sqLiteDatabase.execSQL(Transacciones.crearTablaPersonas);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL(Transacciones.eliminarTablaPersonas);
        onCreate(sqLiteDatabase);

    }
}
