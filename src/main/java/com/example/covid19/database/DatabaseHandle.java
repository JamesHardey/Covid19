/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.covid19.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author James.J
 */
public final class DatabaseHandle {
    private static DatabaseHandle handle=null;
    private static final String URL="jdbc:derby:database;create=true";
    private static Connection conn=null;
    private static Statement stmt=null;
    
    private DatabaseHandle(){
        createConnection();
    }
    
    public static DatabaseHandle getInstance(){
        if(handle==null){
            handle=new DatabaseHandle();
        }
        return handle;
    }

    private void createConnection() {
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            conn=DriverManager.getConnection(URL);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    void setupGlobalTable(){
        String TABLE_NAME="Global";
        try{
            stmt=conn.createStatement();
            DatabaseMetaData dbm=conn.getMetaData();
            ResultSet tables=dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);
            if(tables.next()){
                System.out.println("Table "+TABLE_NAME+" already exists.Ready to go!");
            }
            else{
                stmt.execute("CREATE TABLE "+TABLE_NAME+"("
                        + "     id varchar(200) primary key,\n"
                        + "     country_name varchar(25),\n"
                        + "     new_case varchar(25),\n"
                        + "     total_confirmed varchar(25),\n"
                        + "     new_deaths varchar(25),\n"
                        + "     new_confirmed varchar(25),\n"
                        + "     total_case int ,\n"
                        + "     total_deaths int,\n"
                        + ")");
            }
        
        }
        catch(SQLException e){
            System.err.println(e.getMessage()+".....setupDatabase");
        }
        finally{
            
        }
    }
    
    
    void setupCountryTable(String country,String[]states){
        String TABLE_NAME="Global";
        try{
            stmt=conn.createStatement();
            DatabaseMetaData dbm=conn.getMetaData();
            ResultSet tables=dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);
            if(tables.next()){
                System.out.println("Table "+TABLE_NAME+" already exists.Ready to go!");
            }
            else{
                stmt.execute("CREATE TABLE "+TABLE_NAME+"("
                        + "     id varchar(200) primary key,\n"
                        + "     new_case varchar(200),\n"
                        + "     total_confirmed varchar(200),\n"
                        + "     new_deaths varchar(200),\n"
                        + "     new_confirmed varchar(200),\n"
                        + "     total_case varchar(200),\n"
                        + "     total_deaths varchar(200),\n"
                        + ")");
            }
        
        }
        catch(SQLException e){
            System.err.println(e.getMessage()+".....setupDatabase");
        }
        finally{
            
        }
    }
    
}
