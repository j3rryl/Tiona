package com.tione.tiona.Firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;

public class Database {
    public Firestore startFirebase(){
        try {
            FileInputStream serviceAccount =
                    new FileInputStream("src/main/resources/Firebase/tione-tiona-firebase-adminsdk-ksshj-4d24222cc2.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://tione-tiona-default-rtdb.firebaseio.com/")
                    .build();

            FirebaseApp.initializeApp(options);
            System.out.println("Connected to Firebase successfully");
        } catch (Exception e){
            e.printStackTrace();
        }
        return FirestoreClient.getFirestore();
    }
}
