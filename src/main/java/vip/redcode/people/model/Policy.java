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
public class Policy {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "people_id")
    private People people;

    private String policy;

    private String type_policy;

    public Policy(People people, String policy, String type_policy) {
        this.people = people;
        this.policy = policy;
        this.type_policy = type_policy;
    }
}
