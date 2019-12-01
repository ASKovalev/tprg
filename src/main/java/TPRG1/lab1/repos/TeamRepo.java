package TPRG1.lab1.repos;

import TPRG1.lab1.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepo extends JpaRepository<Team, Integer> {
    Team findByNameTeam (String nameTeam);
}
