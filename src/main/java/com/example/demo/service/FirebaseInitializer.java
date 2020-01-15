package com.example.demo.service;

import java.io.FileInputStream;

import com.google.firebase.FirebaseOptions;
import com.google.firebase.FirebaseApp;
import org.springframework.stereotype.Service;
import com.google.auth.oauth2.GoogleCredentials;

import javax.annotation.PostConstruct;

@Service
public class FirebaseInitializer {

    @PostConstruct
    public void initialize(){
        try{
            FileInputStream serviceAccount =
                    new FileInputStream("/home/akshay/Documents/Soban/archive/spring-boot-REST-firebase/ServiceAccount.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://firedemo-161eb.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
