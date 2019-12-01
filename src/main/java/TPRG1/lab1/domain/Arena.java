package TPRG1.lab1.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Arena")
//Создаем класс Arena
public class Arena {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "gen_arena")
    @SequenceGenerator(name = "gen_arena", sequenceName = "Seq_Arena")
    private Integer id;

    private String nameArena;
    private String numberOfSeats;
    private Integer freeSpace;
    private String costTicket;
//   Связь один ко многим
    @OneToMany(mappedBy="stage", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Competition> versus;


    public Arena() {
    }
//  Конструктор
    public Arena(String nameArena, String numberOfSeats, Integer freeSpace, String costTicket) {
        this.nameArena = nameArena;
        this.numberOfSeats = numberOfSeats;
        this.freeSpace = freeSpace;
        this.costTicket = costTicket;

    }
// Методы Get Set
    public Set<Competition> getVersus() {
        return versus;
    }

    public void setVersus(Set<Competition> versus) {
        this.versus = versus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameArena() {
        return nameArena;
    }

    public void setNameArena(String nameArena) {
        this.nameArena = nameArena;
    }

    public String getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(String numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Integer getFreeSpace() {
        return freeSpace;
    }

    public void setFreeSpace(Integer freeSpace) {
        this.freeSpace = freeSpace;
    }

    public String getCostTicket() {
        return costTicket;
    }

    public void setCostTicket(String costTicket) {
        this.costTicket = costTicket;
    }
}
