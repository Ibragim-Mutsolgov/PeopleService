package vip.redcode.people.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Snils {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String snils_number;

    @ManyToOne
    @JoinColumn(name = "people_id")
    private People people;

    public Snils(String snils_number, People people) {
        this.snils_number = snils_number;
        this.people = people;
    }
}
