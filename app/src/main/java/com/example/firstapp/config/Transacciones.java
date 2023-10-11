package com.example.firstapp.config;

public class Transacciones {
    //nombre de la bd
    public static final String nameBD = "PM012023";

    // tablas

    public static final String table="personas";

    //campos de la table

    public static final String id="id";
    public static final String nombres="nombres";
    public static final String apellidos="apellidos";
    public static final String edad="edad";
    public static final String correo="correo";

    //consultas

    public static final String crearTablaPersonas = "create table personas (id integer primary key autoincrement," +
            " nombres text, apellidos text, edad text, correo text);";



    public static final String eliminarTablaPersonas="drop table if exists personas";

    public static final String SeleccionarTablaPersonas="select * from "+Transacciones.table;


}
