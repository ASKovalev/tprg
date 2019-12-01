package TPRG1.lab1.repos;

import TPRG1.lab1.domain.Athelete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtheleteRepo extends JpaRepository<Athelete, Integer> {
        Athelete findByName (String name);
        }
