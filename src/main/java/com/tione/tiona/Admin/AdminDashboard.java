package com.tione.tiona.Admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminDashboard implements Initializable {
    @FXML
    private LineChart<?, ?> lineChart;

    @FXML
    private PieChart pieChart;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inlineChart();
        iniPieChart();
    }
    private void inlineChart(){
        XYChart.Series series=new XYChart.Series();
        series.getData().add(new XYChart.Data("Monday",8));
        series.getData().add(new XYChart.Data("Tueday",12));
        series.getData().add(new XYChart.Data("Wednesday",10));
        series.getData().add(new XYChart.Data("Thurday",15));
        series.getData().add(new XYChart.Data("Friday",12));
        series.getData().add(new XYChart.Data("Saturday",8));
        series.getData().add(new XYChart.Data("Sunday",5));
        lineChart.getData().addAll(series);
        lineChart.lookup(".chart-plot-background").setStyle("-fx-background-color: transparent");
        series.getNode().setStyle("-fx-stroke: linear-gradient(from 25% 25% to 100% 100%, #D9AFD9,#97D9E1)");

    }
    private void iniPieChart(){
        ObservableList<PieChart.Data> pieChartData= FXCollections.observableArrayList(
                new PieChart.Data("January",15),
                new PieChart.Data("February",30),
                new PieChart.Data("March",10),
                new PieChart.Data("April",3),
                new PieChart.Data("May",2),
                new PieChart.Data("June",10)
        );
        pieChart.setData(pieChartData);
    }
}
