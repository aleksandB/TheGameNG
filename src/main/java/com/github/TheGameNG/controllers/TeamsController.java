package com.github.TheGameNG.controllers;

import antlr.StringUtils;
import com.github.TheGameNG.entities.Team;
import com.github.TheGameNG.functions.ReadWriteExcel;
import com.github.TheGameNG.repositories.TeamsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping("/addteams")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) {
        List<Team> teamList = new ArrayList<>();
        //check if file is empty
        if (file.isEmpty()) {
            attributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:/";
        }

        log.info(file.getOriginalFilename());
        ReadWriteExcel readWriteExcel = new ReadWriteExcel();
        readWriteExcel.convertMultipart(file);
        readWriteExcel.testPrint(readWriteExcel.ReadExcelFileTeams());
        teamList = readWriteExcel.ReadExcelFileTeams();
        for(Team team : teamList){
            teamsRepository.save(team);
        }

        attributes.addFlashAttribute("message","You successfully uploaded file");

        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteTeam(Model model) {
        List<Team> teamList = new ArrayList<>();
        teamsRepository.findAll().forEach(teamList::add);

        for (Team team : teamList){
            teamsRepository.delete(team);
        }
        return "redirect:/";
    }


/*
    @GetMapping("/signup")
    public String showSignUpForm(Team team) {
        return "add-user";
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



*/
}