package TPRG1.lab1.repos;

import TPRG1.lab1.domain.Competition;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompetitionRepo extends CrudRepository<Competition, Integer> {
    List<Competition> findBySport(String sport);
}
