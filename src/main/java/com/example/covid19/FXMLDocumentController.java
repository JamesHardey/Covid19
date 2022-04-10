/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.covid19;

import java.net.URL;
import java.text.NumberFormat;
import java.util.*;

import com.example.covid19.models1.Country;
import com.example.covid19.models1.Global;
import com.example.covid19.models1.Root;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 *
 * @author James.J
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Text header;
    @FXML
    private TextField newConfirmCases;
    @FXML
    private TextField newDeaths;
    @FXML
    private TextField newRecovered;
    @FXML
    private TextField totalConfirm;
    @FXML
    private TextField totalDeaths;
    @FXML
    private TextField totalRecovered;
    
    OperationPerform op;
    @FXML
    private TextField countryInput;
    @FXML
    private AnchorPane rootPane;
    double xpos=0;
    double ypos=0;
    
    @FXML
    private ComboBox<String> combo;



    @Override
    public void initialize(URL url, ResourceBundle rb) {

        loadEmpty();
        combo.getItems().addAll(getValidFaceNames());
        combo.setValue("Global");

        //stage=(Stage)rootPane.getScene().getWindow();
        op=OperationPerform.getOperationPerform();

        retrieveValues();

        op.obProperty().addListener((ob,ov,nv) -> {
            System.out.println(op.getOb());
            if(op.getOb()!= null){
                retrieveValues();
            }
        });
    }    
    
    public List<String> getValidFaceNames(){
        return Arrays.asList("Global","Nigeria","United States of America","China","Italy");
    }


    private void load(){


    }

    private void retrieveValues(){
        Platform.runLater(() ->{
            Root covidModel = op.getCovidModel();
            if(covidModel != null) {

            }
        });

    }
    
    @FXML
    public void loadCountryCases() {
        String country = countryInput.getText();
        getCountryCase(country);
    }
    
    private void reload() {
        load();
    }

    private void getCountryCase(String country){
        if(Objects.isNull(country)) return;
        List<Country> countries  = op.getOb().countries;
        for(Country country1: countries){
            if(country1.getCountry().equalsIgnoreCase(country)){
                loadUpInfo(country1);
                return;
            }
        }
        loadEmpty();
    }

    private void loadEmpty(){
        newDeaths.setText("-----------");
        newConfirmCases.setText("-----------");
        newRecovered.setText("-----------");
        totalConfirm.setText("-----------");
        totalDeaths.setText("-----------");
        totalRecovered.setText("-----------");
    }

    private void loadUpGlobalInfo(){
        Global globalStatus = op.getCovidModel().getGlobal();
        newDeaths.setText(formatNumber(globalStatus.getNewDeaths()));
        newConfirmCases.setText(formatNumber(globalStatus.getNewConfirmed()));
        newRecovered.setText(formatNumber(globalStatus.getNewRecovered()));
        totalConfirm.setText(formatNumber(globalStatus.getTotalConfirmed()));
        totalDeaths.setText(formatNumber(globalStatus.getTotalDeaths()));
        totalRecovered.setText(formatNumber(globalStatus.getTotalRecovered()));
    }

    private void loadUpInfo(Country country){
        newDeaths.setText(formatNumber(country.getNewDeaths()));
        newConfirmCases.setText(formatNumber(country.getNewConfirmed()));
        newRecovered.setText(formatNumber(country.getNewRecovered()));
        totalConfirm.setText(formatNumber(country.getTotalConfirmed()));
        totalDeaths.setText(formatNumber(country.getTotalDeaths()));
        totalRecovered.setText(formatNumber(country.getTotalRecovered()));
    }

    public String formatNumber(long num){
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setGroupingUsed(true);
        return numberFormat.format(num);
    }

    @FXML
    private void onMouseDragged(MouseEvent e) {
        (rootPane.getScene().getWindow()).setX(e.getSceneX()-xpos);
        (rootPane.getScene().getWindow()).setY(e.getSceneY()-ypos);
        
    }

    @FXML
    private void onMousePressed(MouseEvent e) {
        xpos=e.getSceneX();
        ypos=e.getSceneY();
    }

    @FXML
    private void dropDownCountry(ActionEvent event) {
        String value=combo.getValue();
        if(value.equalsIgnoreCase("Global")){
            loadUpGlobalInfo();
            return;
        }
        getCountryCase(value);
    }
}
