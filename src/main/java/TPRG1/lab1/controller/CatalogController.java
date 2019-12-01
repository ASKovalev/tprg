package TPRG1.lab1.controller;

import TPRG1.lab1.domain.Arena;
import TPRG1.lab1.domain.Competition;
import TPRG1.lab1.domain.Team;
import TPRG1.lab1.repos.ArenaRepo;
import TPRG1.lab1.repos.CompetitionRepo;
import TPRG1.lab1.repos.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;


@Controller
public class CatalogController {

    @Autowired
    private CompetitionRepo competitionRepo;
    @Autowired
    private ArenaRepo arenaRepo;
//    @Autowired
//    private TeamRepo teamRepo;

    @GetMapping("/catalog")
    public String maincompetition(Map<String, Object> model) {

        Iterable<Competition> competitions = competitionRepo.findAll();
        model.put("competitions", competitions);

        Iterable<Arena> arenas = arenaRepo.findAll();
        model.put("arenas", arenas);


        return "catalog";
    }

    @GetMapping("/catalog/{arena}")
    @PreAuthorize("hasAuthority('USER')")
    public String buyticket(@PathVariable Arena arena, Model model) {

        Integer i = arena.getFreeSpace();
        i--;
        arena.setFreeSpace(i);
        arenaRepo.save(arena);

        return "redirect:/catalog";

    }
}
