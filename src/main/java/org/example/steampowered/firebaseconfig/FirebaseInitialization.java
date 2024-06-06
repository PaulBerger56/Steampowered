package org.example.steampowered.firebaseconfig;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import jakarta.annotation.PostConstruct;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class FirebaseInitialization {
    
    @PostConstruct
    public void initialization() throws IOException {

        String localPath = "./serviceAccountKey.json";
        String fallbackPath = "/etc/secrets/serviceAccountKey.json";

        FileInputStream serviceAccount;

        if (new File(localPath).exists()) {
            serviceAccount = new FileInputStream(localPath);
            System.out.println("Using service account key from " + localPath);
        } else if (new File(fallbackPath).exists()) {
            serviceAccount = new FileInputStream(fallbackPath);
            System.out.println("Using service account key from " + fallbackPath);
        } else {
            throw new IOException("Service account key not found in either " + localPath + " or " + fallbackPath);
        }

        // Do not remove deprecated code with yellow underlines
        FirebaseOptions options = new FirebaseOptions.Builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        .build();

        FirebaseApp.initializeApp(options);
    }
}
