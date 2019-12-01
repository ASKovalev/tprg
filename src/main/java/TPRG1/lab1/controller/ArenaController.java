package TPRG1.lab1.controller;

import TPRG1.lab1.domain.Arena;
import TPRG1.lab1.repos.ArenaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@PreAuthorize("hasAuthority('ADMIN')")
//Контроллер для класса Arena
public class ArenaController {
    @Autowired
    private ArenaRepo arenaRepo;

    @GetMapping("/arena")
    public String arena(Model model) {
        Iterable<Arena> arenas;
        arenas=arenaRepo.findAll();
        model.addAttribute("arenas", arenas);
        return "arena";
    }

    @PostMapping("/addarena")
    public String addArena(
            @RequestParam String nameArena,
            @RequestParam String numberOfSeats,
            @RequestParam Integer freeSpace,
            @RequestParam String costTicket, Model model)
    {
        Arena arena = new Arena(nameArena, numberOfSeats, freeSpace, costTicket);
        arenaRepo.save(arena);
        Iterable<Arena> arenas;
        arenas=arenaRepo.findAll();


        return "redirect:/arena";
    }

    @GetMapping("/arena/{arena}")
    public String arenaEditForm(@PathVariable Arena arena, Model model) {
        model.addAttribute("arena", arena);

        return "arenaedit";
    }

    @GetMapping("/arenadel/{arena}")
    public String arenaDel(@PathVariable Arena arena) {
        arenaRepo.delete(arena);

        return "redirect:/arena";
    }

    @PostMapping("/arena")
    public String arenaSave(
            @RequestParam String nameArena,
            @RequestParam String numberOfSeats,
            @RequestParam Integer freeSpace,
            @RequestParam String costTicket,
            @RequestParam("id") Arena arena
    ){
        arena.setNameArena(nameArena);
        arena.setNumberOfSeats(numberOfSeats);
        arena.setFreeSpace(freeSpace);
        arena.setCostTicket(costTicket);

        arenaRepo.save(arena);
        return"redirect:/arena";
    }
}
