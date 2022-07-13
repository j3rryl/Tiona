package com.tione.tiona.Admin;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.tione.tiona.Firebase.Database;
import com.tione.tiona.Models.City;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class TestRun {
    private static Firestore db=null;
    private static ObservableList<City>cities= FXCollections.observableArrayList();
    private static City city;
    public static ObservableList<City> getCities(){
        return cities;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        insertData();
        retrieveData();
    }
    public static void insertData() throws ExecutionException, InterruptedException {
        Database database=new Database();
        db=database.startFirebase();
        Map<String, Object> sample = new HashMap<>();
        sample.put("name", "Kisumu");
        sample.put("state", "Nyalenda");
        // Add a new document (asynchronously) in collection "cities" with id "LA"
        ApiFuture<WriteResult> future = db.collection("cities").document(UUID.randomUUID().toString()).set(sample);
//        // ...
//        // future.get() blocks on response
        System.out.println("Update time : " + future.get().getUpdateTime());
        System.out.println("Connected now");
    }
    public static void retrieveData() throws ExecutionException, InterruptedException {
        Database database=new Database();
        db=database.startFirebase();
    ApiFuture<QuerySnapshot> future = db.collection("cities").get();
    // future.get() blocks on response
    List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        for(QueryDocumentSnapshot document:documents) {
//            System.out.println(document.getId() + " => " + document.getData().get("name"));
            city=new City(String.valueOf(document.getData().get("name")),String.valueOf(document.getData().get("state")));
            cities.add(city);
        }
        System.out.println(city.getState());
    }
}
