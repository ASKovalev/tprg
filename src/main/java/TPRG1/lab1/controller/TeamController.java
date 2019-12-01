package TPRG1.lab1.controller;


import TPRG1.lab1.domain.Athelete;
import TPRG1.lab1.domain.Competition;
import TPRG1.lab1.domain.Team;
import TPRG1.lab1.repos.CompetitionRepo;
import TPRG1.lab1.repos.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;


@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class TeamController {
    @Autowired
    private TeamRepo teamRepo;
    @Autowired
    private CompetitionRepo competitionRepo;


    @GetMapping("/team")
    public String team(Model model) {

            Iterable<Team> teams;
            teams=teamRepo.findAll();
            model.addAttribute("teams", teams);

            Iterable<Competition> competitions;
            competitions=competitionRepo.findAll();
            model.addAttribute("competitions", competitions);

        return "team";
    }

    @PostMapping("/addteam")
    public String addTeam(
            @RequestParam String nameTeam,
            @RequestParam String coach,
            @RequestParam Set<Competition> tournaments,
            Model model)
    {
        Team team = new Team(nameTeam, coach, tournaments);
        teamRepo.save(team);

        Iterable<Team> teams;
        teams=teamRepo.findAll();
        model.addAttribute("teams", teams);

        Iterable<Competition> competitions;
        competitions=competitionRepo.findAll();
        model.addAttribute("competitions", competitions);


        return "redirect:/team";
    }

    @GetMapping("/team/{team}")
    public String teamEditForm(@PathVariable Team team, Model model) {
        model.addAttribute("team", team);

        Iterable<Competition> competitions;
        competitions=competitionRepo.findAll();
        model.addAttribute("competitions", competitions);

        return "teamedit";
    }

    @GetMapping("/teamdel/{team}")
    public String teamDel(@PathVariable Team team) {
        teamRepo.delete(team);
        return "redirect:/team";
    }

    @PostMapping("/team")
    public String teamSave(
            @RequestParam String nameTeam,
            @RequestParam String coach,
            @RequestParam Set<Competition> tournaments,
            @RequestParam("id") Team team
    ){
        team.setNameTeam(nameTeam);
        team.setCoach(coach);
        team.setTournaments(tournaments);

        teamRepo.save(team);
        return"redirect:/team";
    }
}
