package com.github.TheGameNG.controllers;

import com.github.TheGameNG.entities.Team;
import com.github.TheGameNG.repositories.TeamsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TeamsController {
    private static final Logger log = LoggerFactory.getLogger(TeamsController.class);


    @Autowired
    TeamsRepository teamsRepository;


    @GetMapping("/")
    public String showUserList(Model model) {
        List<Team> teamList = new ArrayList<>();
        teamsRepository.findAll().forEach(teamList::add);
        model.addAttribute("teams", teamsRepository.findAll());
        log.info("size = " + teamList.size());
        return "index";
    }
/*
    @GetMapping("/signup")
    public String showSignUpForm(Team team) {
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid Team team, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }

        teamsRepository.save(team);
        return "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Team team = teamsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("team", team);

        return "update-user";
    }

    @PostMapping("/update/{id}")
    public String updateTeam(@PathVariable("id") long id, @Valid Team team, BindingResult result, Model model) {
        if (result.hasErrors()) {
            team.setId(id);
            return "update-user";
        }

        teamsRepository.save(team);

        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteTeam(@PathVariable("id") long id, Model model) {
        Team team = teamsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        teamsRepository.delete(team);

        return "redirect:/index";
    }

*/
}