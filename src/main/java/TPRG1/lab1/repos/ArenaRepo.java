package TPRG1.lab1.repos;

import TPRG1.lab1.domain.Arena;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ArenaRepo extends JpaRepository<Arena, Integer> {
    Arena findByNameArena(String nameArena);
}
