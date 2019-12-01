package TPRG1.lab1.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Competition")
// Класс Competition
public class Competition {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator = "gen_com")
    @SequenceGenerator(name = "gen_com", sequenceName = "Seq_Com")
    private Integer id;

    private String nameCompetition;
    private String sport;
    private String competitionTime;
    private String result;

    @ManyToOne
    @JoinColumn(name="arenaId")
    private Arena stage;

    @ManyToMany
    @JoinTable(name="competitionTeam",
            joinColumns=@JoinColumn(name="competitionIId"),
            inverseJoinColumns=@JoinColumn(name="teamIId"))
    private Set<Team> opponents= new HashSet<>();



    public Competition() {
    }




    public Competition(String nameCompetition, String sport, String competitionTime, String result, Arena nameArena,Set<Team> opponents)  {
        this.nameCompetition = nameCompetition;
        this.sport = sport;
        this.competitionTime = competitionTime;
        this.result = result;
        this.stage = nameArena;
        this.opponents = opponents;

    }
    public Integer getIdStage(){
        return stage.getId();
    }

    public Integer getSpaceStage(){
        return stage != null ? stage.getFreeSpace() : 0;
    }

    public String getCostStage(){
        return stage != null ? stage.getCostTicket() : "<none>";
    }

    public String getNameStage(){
        return stage != null ? stage.getNameArena() : "<none>";
    }

    public Set<Team> getOpponents() {
        return opponents;
    }

    public void setOpponents(Set<Team> opponents) {
        this.opponents = opponents;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getCompetitionTime() {
        return competitionTime;
    }

    public void setCompetitionTime(String competitionTime) {
        this.competitionTime = competitionTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Arena getStage() {
        return stage;
    }

    public void setStage(Arena stage) {
        this.stage = stage;
    }

    public String getNameCompetition() {
        return nameCompetition;
    }

    public void setNameCompetition(String nameCompetition) {
        this.nameCompetition = nameCompetition;
    }
}
