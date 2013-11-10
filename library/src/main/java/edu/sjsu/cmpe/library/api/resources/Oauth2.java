package edu.sjsu.cmpe.library.api.resources;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.plus.Plus;
import com.google.api.services.plus.model.Person;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: shankey
 * Date: 11/9/13
 * Time: 9:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class Oauth2 {



    // Set up the HTTP transport and JSON factory
    HttpTransport httpTransport = new NetHttpTransport();
    JsonFactory jsonFactory = new JacksonFactory();

    private Credential.AccessMethod accessMethod;
    // Set up OAuth 2.0 access of protected resources
// using the refresh and access tokens, automatically
// refreshing the access token when it expires
    Credential credential = new Credential.Builder(accessMethod)
            .setJsonFactory(jsonFactory)
            .setTransport(httpTransport)
            .setTokenServerEncodedUrl(tokenServerEncodedUrl)
            .setClientAuthentication(clientAuthentication)
            .setRequestInitializer(requestInitializer)
            .build();

    // Set up the main Google+ class
    Plus plus = new Plus(httpTransport, jsonFactory, credential);

    // Make a request to access your profile and display it to console
    Person profile;

    {
        try {
            profile = plus.people().get("me").execute();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    System.out.println("ID: " + profile.getId());
        System.out.println("Name: " + profile.getDisplayName());
        System.out.println("Image URL: " + profile.getImage().getUrl());
        System.out.println("Profile URL: " + profile.getUrl());

    }


}