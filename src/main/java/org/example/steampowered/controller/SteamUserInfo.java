package org.example.steampowered.controller;

public class SteamUserInfo {
    private String avatarUrl;
    private String personaname;

    public SteamUserInfo(String avatarUrl, String personaname) {
        this.avatarUrl = avatarUrl;
        this.personaname = personaname;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getPersonaname() {
        return personaname;
    }
}
