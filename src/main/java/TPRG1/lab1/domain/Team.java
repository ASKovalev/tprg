package TPRG1.lab1.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Team")
//Класс команда
public class Team{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "gen_team")
    @SequenceGenerator(name = "gen_team", sequenceName = "Seq_Team")

    private Integer id;

    private String nameTeam;
    private String coach;
    //Один ко многим
    @OneToMany(mappedBy="club", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Athelete> person;
    //Многие ко многим
    @ManyToMany
    @JoinTable(name="competitionTeam",
            joinColumns=@JoinColumn(name="teamIId"),
            inverseJoinColumns=@JoinColumn(name="competitionIId"))
    private Set<Competition> tournaments = new HashSet<>();



    public Team() {
    }


    public Team(String nameTeam, String coach, Set<Competition> tournaments) {
        this.nameTeam = nameTeam;
        this.coach = coach;
        this.tournaments = tournaments;

    }

    public Set<Competition> getTournaments() {
        return tournaments;
    }

    public void setTournaments(Set<Competition> tournaments) {
        this.tournaments = tournaments;
    }

    public Set<Athelete> getPerson() {
        return person;
    }

    public void setPerson(Set<Athelete> person) {
        this.person = person;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameTeam() {
        return nameTeam;
    }

    public void setNameTeam(String nameTeam) {
        this.nameTeam = nameTeam;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }
}
