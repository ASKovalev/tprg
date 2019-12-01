package TPRG1.lab1.domain;

import javax.persistence.*;

@Entity
@Table(name="Athelete")
//Создаю класс Athelete
public class Athelete {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "gen_athelete")
    @SequenceGenerator(name = "gen_athelete", sequenceName = "Seq_Athelete")
    private Integer id;

    private String name;
    private String surname;
    private String patronymic;
    private String biography;
//Связь многие к одному
    @ManyToOne
    @JoinColumn(name="teamId")
    private Team club;

    public Athelete() {
    }

    public Athelete(String name, String surname, String patronymic, String biography, Team nameTeam) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.biography = biography;
        this.club = nameTeam;


    }

    public String getNameClub(){
        return club != null ? club.getNameTeam() : "<none>";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Team getClub() {
        return club;
    }

    public void setClub(Team club) {
        this.club = club;
    }

}
