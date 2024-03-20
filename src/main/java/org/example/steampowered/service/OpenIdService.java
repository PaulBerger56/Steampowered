package org.example.steampowered.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


import org.example.steampowered.pojo.User;
import org.expressme.openid.Association;
import org.expressme.openid.Endpoint;
import org.expressme.openid.OpenIdManager;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;

import static org.example.steampowered.Constants.PLAYER_SUMMARIES_API_URL;

@Service
public class OpenIdService {

    private String steamId;

    public String getSteamId() {
        return steamId;
    }    
    
    public String activateOpenId() {
        OpenIdManager manager = new OpenIdManager();
        // TODO  change these from localhost after uploading the project to a hosting site
        manager.setReturnTo("http://localhost:8080");
        manager.setRealm("http://localhost:8080");

        Endpoint endpoint = manager.lookupEndpoint("https://steamcommunity.com/openid/");      
        Association association = manager.lookupAssociation(endpoint);      
        String url = manager.getAuthenticationUrl(endpoint, association); 
        return url;        
    }

    public void filterOpenIdResults(HttpServletRequest request) {
        // When the openID returns the user to the index page, grab the values from the nav bar
        Map<String, String[]> parameterMap = request.getParameterMap();     
        
        // Filter out only the parameters openid.claimed_id and openid.identity
        Map<String, String[]> filteredParameters = new HashMap<>();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            String paramName = entry.getKey();
            if ("openid.claimed_id".equals(paramName) || "openid.identity".equals(paramName)) {
                filteredParameters.put(paramName, entry.getValue());
            }
        }       

        // print out the values to verify that it worked
        if(filteredParameters.size() > 0){
            for (Map.Entry<String, String[]> entry : filteredParameters.entrySet()) {
                String paramName = entry.getKey();
                String[] paramValues = entry.getValue();

                System.out.println("Parameter: " + paramName);
                System.out.print("Values: ");
                for (String value : paramValues) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } 
        
        // Extract Steam ID from openid.claimed_id
        if (filteredParameters.containsKey("openid.claimed_id")) {
            String[] claimedIdValues = filteredParameters.get("openid.claimed_id");
            for (String claimedId : claimedIdValues) {
                String[] parts = claimedId.split("/");
                steamId = parts[parts.length - 1];
            }
        }    
        // print the id to console
        // if(steamId != null) {
        //     System.out.println("Steam id: " + steamId);
        // }        
    }

    public User.SteamUserInfo SteamUserInfo(String steamId) throws IOException {
        String apiUrl = PLAYER_SUMMARIES_API_URL + steamId;

        URL url = new URL(apiUrl);
        InputStream inputStream = url.openStream();
        Scanner scanner = new Scanner(inputStream);
        String responseBody = scanner.useDelimiter("\\A").next();
        scanner.close();

        JSONObject jsonResponse = new JSONObject(responseBody);
        JSONObject playerInfo = jsonResponse.getJSONObject("response").getJSONArray("players").getJSONObject(0);

        String avatarUrl = playerInfo.getString("avatarmedium");
        String personaname = playerInfo.getString("personaname");

        return new User.SteamUserInfo(avatarUrl, personaname);
    }

}