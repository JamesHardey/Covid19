/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.covid19;


import com.example.covid19.models1.Root;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


/**
 *
 * @author James.J
 */
public class OperationPerform {

    private static OperationPerform op;
    private Root rootModel;
    private ObjectProperty<Root> ob = new SimpleObjectProperty<>();

    public Root getOb() {
        return ob.get();
    }

    public ObjectProperty<Root> obProperty() {
        return ob;
    }

    public void setOb(Root ob) {
        this.ob.set(ob);
    }

    public OperationPerform(){
        perform();
    }

    public Root getCovidModel() {
        return rootModel;
    }


    public static OperationPerform getOperationPerform(){
        if(op == null)
            op = new OperationPerform();

        return op;
    }

    
    public  void perform() {
        retrieve();
    }


    private void retrieve(){
        try{
            String url = "https://api.covid19api.com/summary";
            if(!isConnected()) return;
            System.out.println("Its Connected");
            ObjectMapper objectMapper = new ObjectMapper();
            rootModel = objectMapper.readValue(new URL(url), Root.class );
            setOb(rootModel);
        } catch (Exception me){
            me.printStackTrace();
        }

    }
    


    private boolean isConnected(){
        boolean connected = false;
        try{
            URL url = new URL("http://www.google.com");
            URLConnection connection = url.openConnection();
            connection.connect();
            connected = true;
        }
        catch (MalformedURLException e){
            connected = false;
        }
        catch (IOException e){
            connected = false;
        }
        return connected;
    }
        

}
       