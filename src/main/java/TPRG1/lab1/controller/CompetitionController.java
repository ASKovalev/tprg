package TPRG1.lab1.controller;

import TPRG1.lab1.domain.Arena;
import TPRG1.lab1.domain.Competition;
import TPRG1.lab1.domain.Team;
import TPRG1.lab1.repos.ArenaRepo;
import TPRG1.lab1.repos.CompetitionRepo;
import TPRG1.lab1.repos.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Map;
import java.util.Set;

@Controller

public class CompetitionController {
    @Autowired
    private CompetitionRepo competitionRepo;
    @Autowired
    private ArenaRepo arenaRepo;
    @Autowired
    private TeamRepo teamRepo;


    @GetMapping("/competition")
    public String maincompetition(Map<String, Object> model) {

        Iterable<Competition> competitions = competitionRepo.findAll();
        model.put("competitions", competitions);

        Iterable<Arena> arenas = arenaRepo.findAll();
        model.put("arenas", arenas);

        Iterable<Team> teams = teamRepo.findAll();
        model.put("teams", teams);

        return "competition";
    }

    @PostMapping("/addcompetition")
    public String addCompetition(
            @RequestParam String nameCompetition,
            @RequestParam String sport,
            @RequestParam String competitionTime,
            @RequestParam String result,
            @RequestParam Arena stage,
            @RequestParam Set<Team> opponents, Map<String, Object> model)
    {
        Competition competition = new Competition(nameCompetition, sport, competitionTime, result, stage, opponents);

        competitionRepo.save(competition);

        Iterable<Competition> competitions = competitionRepo.findAll();
        model.put("competitions", competitions);


        Iterable<Arena> arenas = arenaRepo.findAll();
        model.put("arenas", arenas);

        Iterable<Team> teams = teamRepo.findAll();
        model.put("teams", teams);

        return "competition";
    }

    @GetMapping("/competition/{competition}")
    public String competitionEditForm(@PathVariable Competition competition, Model model) {
        model.addAttribute("competition", competition);

        Iterable<Arena> arenas;
        arenas = arenaRepo.findAll();
        model.addAttribute("arenas", arenas);

        Iterable<Team> teams;
        teams = teamRepo.findAll();
        model.addAttribute("teams", teams);


        return "competitionedit";
    }

    @GetMapping("/competitiondel/{competition}")
    public String competitionDel(@PathVariable Competition competition) {
        competitionRepo.delete(competition);

        return "redirect:/competition";
    }

    @PostMapping("/competition")
    public String competitionSave(
            @RequestParam String nameCompetition,
            @RequestParam String sport,
            @RequestParam String competitionTime,
            @RequestParam String result,
            @RequestParam Arena stage,
            @RequestParam Set<Team> opponents,
            @RequestParam("id") Competition competition
    ){
        competition.setNameCompetition(nameCompetition);
        competition.setSport(sport);
        competition.setCompetitionTime(competitionTime);
        competition.setResult(result);
        competition.setStage(stage);
        competition.setOpponents(opponents);

        competitionRepo.save(competition);
        return"redirect:/competition";
    }
}
