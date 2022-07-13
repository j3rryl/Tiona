package com.tione.tiona.Admin;

import com.google.cloud.firestore.Firestore;
import com.tione.tiona.Firebase.Database;
import com.tione.tiona.HelperClass.ViewLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminPanel implements Initializable {
    @FXML
    private VBox admin_maindashboard;

    @FXML
    private HBox admin_clients;

    @FXML
    private HBox admin_dashboard;

    @FXML
    private HBox admin_inbox;

    @FXML
    private HBox admin_meetings;

    @FXML
    private HBox admin_notes;

    @FXML
    private BorderPane admin_panel;

    @FXML
    private HBox admin_projects;

    @FXML
    private HBox admin_suggestions;
    @FXML
    private LineChart<?, ?> lineChart;

    @FXML
    private PieChart pieChart;
    public static Firestore db=null;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    inlineChart();
    iniPieChart();
    initializeFirebase();
    }
    public void initializeFirebase(){
        Database database=new Database();
        db=database.startFirebase();
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

    @FXML
    void onDashboardClicked(MouseEvent event) {
        admin_inbox.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_clients.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_meetings.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_notes.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_projects.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_suggestions.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_dashboard.getStyleClass().add("selected-button-container");
        ViewLoader loader= new ViewLoader();
        VBox vBox=loader.getPage("admin_dashboard");
        admin_panel.setCenter(vBox);
        BorderPane.setMargin(vBox,new Insets(0,20,0,0));
        admin_panel.setRight(null);
//        admin_panel.setCenter(admin_maindashboard);
//        admin_panel.setRight(null);
    }
    @FXML
     void onInboxClicked(MouseEvent mouseEvent) throws IOException {
        admin_dashboard.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_clients.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_meetings.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_notes.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_projects.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_suggestions.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_inbox.getStyleClass().add("selected-button-container");
        ViewLoader loader= new ViewLoader();
        VBox vBox=loader.getPage("admin_inbox");
        admin_panel.setCenter(vBox);
        BorderPane.setMargin(vBox,new Insets(0,10,50,0));
        VBox vBox2=loader.getPage("inbox_messages");
        admin_panel.setRight(vBox2);
        BorderPane.setMargin(vBox2,new Insets(0,20,50,0));

    }
    @FXML
    void onClientsClicked(MouseEvent event) {
        admin_dashboard.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_inbox.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_meetings.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_notes.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_projects.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_suggestions.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_clients.getStyleClass().add("selected-button-container");
        ViewLoader loader= new ViewLoader();
        VBox vBox=loader.getPage("admin_clients");
        admin_panel.setCenter(vBox);
        admin_panel.setRight(null);
    }

    @FXML
    void onMeetingsClicked(MouseEvent event) {
        admin_dashboard.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_inbox.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_clients.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_notes.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_projects.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_suggestions.getStyleClass().removeIf(style -> style.equals("selected-button-container"));        admin_meetings.getStyleClass().add("selected-button-container");
        ViewLoader loader= new ViewLoader();
        VBox vBox=loader.getPage("admin_meetings");
        admin_panel.setCenter(vBox);
        admin_panel.setRight(null);
    }

    @FXML
    void onNotesClicked(MouseEvent event) {
        admin_dashboard.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_inbox.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_clients.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_meetings.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_notes.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_projects.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_suggestions.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_notes.getStyleClass().add("selected-button-container");
        ViewLoader loader= new ViewLoader();
        VBox vBox=loader.getPage("admin_notes");
        admin_panel.setCenter(vBox);
        admin_panel.setRight(null);
    }

    @FXML
    void onProjectsClicked(MouseEvent event) {
        admin_dashboard.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_inbox.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_clients.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_meetings.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_notes.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_suggestions.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_projects.getStyleClass().add("selected-button-container");
        ViewLoader loader= new ViewLoader();
        VBox vBox=loader.getPage("admin_projects");
        admin_panel.setCenter(vBox);
        admin_panel.setRight(null);
    }

    @FXML
    void onSuggestionsClicked(MouseEvent event) {
        admin_dashboard.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_inbox.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_clients.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_meetings.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_notes.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_projects.getStyleClass().removeIf(style -> style.equals("selected-button-container"));
        admin_suggestions.getStyleClass().add("selected-button-container");
        ViewLoader loader= new ViewLoader();
        VBox vBox=loader.getPage("admin_suggestions");
        admin_panel.setCenter(vBox);
        admin_panel.setRight(null);
    }
}
