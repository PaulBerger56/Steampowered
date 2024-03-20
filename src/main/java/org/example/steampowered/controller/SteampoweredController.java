package org.example.steampowered.controller;

import jakarta.servlet.http.HttpSession;
import org.example.steampowered.pojo.User;
import org.example.steampowered.service.OpenIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
public class SteampoweredController {

    @Autowired
    OpenIdService openIdService;

    @GetMapping("/")
    public String getIndexPage(HttpServletRequest request, Model model){
        openIdService.filterOpenIdResults(request);
        String steamId = openIdService.getSteamId();
        if (steamId != null) {
            try {
                User.SteamUserInfo userInfo = openIdService.SteamUserInfo(steamId);
                model.addAttribute("avatarUrl", userInfo.getAvatarUrl());
                model.addAttribute("personaname", userInfo.getPersonaname());
            } catch (IOException e) {
                // Handle error
            }
        }
        return "index";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping("/multiplayer")
    public String getMultiplayerPage(){
        return "multiplayer";
    }

    @GetMapping("/profile")
    public String getProfilePage(){
        return "profile";
    }

    @RequestMapping(value="/redirect", method = RequestMethod.GET)
    public ModelAndView runManager(){
        String url = openIdService.activateOpenId();
        return new ModelAndView("redirect:" + url);
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // Invalidate the session
        }
        return "http://localhost:8080"; // Redirect to the home page or any other page after logout
    }

}