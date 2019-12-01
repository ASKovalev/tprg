package TPRG1.lab1.controller;

import TPRG1.lab1.domain.Athelete;
import TPRG1.lab1.domain.Team;
import TPRG1.lab1.repos.AtheleteRepo;
import TPRG1.lab1.repos.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AtheleteController {
    @Autowired
    private AtheleteRepo atheleteRepo;
    @Autowired
    private TeamRepo teamRepo;

    @GetMapping("/athelete")
    public String athelete(Map<String, Object> model) {
        Iterable<Athelete> atheletes = atheleteRepo.findAll();
        model.put("atheletes", atheletes);

        Iterable<Team> teams = teamRepo.findAll();
        model.put("teams", teams);
        return "athelete";
    }

    @PostMapping("/addathelete")
    public String addAthelete(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String patronymic,
            @RequestParam String biography,
            @RequestParam Team club, Map<String, Object> model)
    {
        Athelete athelete = new Athelete(name, surname, patronymic, biography, club);
        atheleteRepo.save(athelete);

        Iterable<Athelete> atheletes = atheleteRepo.findAll();
        model.put("atheletes", atheletes);

        Iterable<Team> teams = teamRepo.findAll();
        model.put("teams", teams);

        return "athelete";
    }

    @GetMapping("/athelete/{athelete}")
    public String atheleteEditForm(@PathVariable Athelete athelete,  Model model) {
        model.addAttribute("athelete", athelete);

        Iterable<Team> teams;
        teams = teamRepo.findAll();
        model.addAttribute("teams", teams);


        return "atheleteedit";
    }

    @GetMapping("/atheletedel/{athelete}")
    public String atheleteDel(@PathVariable Athelete athelete) {
        atheleteRepo.delete(athelete);

        return "redirect:/athelete";
    }

    @PostMapping("/athelete")
    public String atheleteSave(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String patronymic,
            @RequestParam String biography,
            @RequestParam Team club,
            @RequestParam("id") Athelete athelete
    ){
        athelete.setName(name);
        athelete.setSurname(surname);
        athelete.setPatronymic(patronymic);
        athelete.setBiography(biography);
        athelete.setClub(club);

        atheleteRepo.save(athelete);
        return"redirect:/athelete";
    }


}
