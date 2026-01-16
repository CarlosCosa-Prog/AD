package com.dam2.ut2empresamusica;// FER ÚS DE CLASSPATH (-cp) EN EXECUTAR, AMB LA RUTA AL JAR DE MYSQL


import java.sql.*;

public class ex3ResultSet {
    
    public static void main(String[] args) {

        try ( Connection conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/empresa","root","root");
        	//Statement stmt = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
              Statement stmt = conexion.createStatement();
        	ResultSet rs = stmt.executeQuery("select * from grupos");	
        ) {
            // Establir la connexió amb la Base de Dades
            System.out.println("Connexió establida amb la base de dades...");
            int id ; String descr;
            while(rs.next() )
            { 
            	id = rs.getInt(1);	// llig la primera columna (1) de la fila actual, que és int (getInt)
            	// id = rs.getInt("id");	, equivalent a la línia anterior
            	//descr = rs.getString(2);
            	descr = rs.getString("descripcion");	// equivalent a la línia anterior
            	System.out.println("Identificador: " + id + ", descripció: " + descr);
            }

        } catch(SQLException se) {
            se.printStackTrace();
        }
    }
    
}
