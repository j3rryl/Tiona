package com.tione.tiona.Admin;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.tione.tiona.Firebase.Database;
import com.tione.tiona.Models.AdminInbox.UserVBox;

import com.tione.tiona.Models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

import static com.tione.tiona.Admin.AdminPanel.db;

public class AdminInbox implements Initializable {
    @FXML
    private VBox inbox_usermessages;

    private ObservableList<User> users= FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            retrieveData();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(User user:users){
            UserVBox vbox=new UserVBox(user.getUser_id(),user.getFirst_name(),user.getLast_name(),user.getEmail());
            inbox_usermessages.getChildren().add(vbox.getContent());
        }
    }
    public void retrieveData() throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> future = db.collection("users").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        for(QueryDocumentSnapshot document:documents) {
//            System.out.println(document.getId() + " => " + document.getData().get("name"));
            users.add(new User(String.valueOf(document.getData().get("user_id")),
                    String.valueOf(document.getData().get("first_name")),
                    String.valueOf(document.getData().get("last_name")),
                    String.valueOf(document.getData().get("email"))
                    ));
        }
    }

}
